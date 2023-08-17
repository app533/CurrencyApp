// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.utils;

import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.DESCRIPTION;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.ITEM;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.LAST_BUILD_DATE;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.REGEX_BRACKETS;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.REGEX_EQUALS;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.REGEX_FORWARD_SLASH;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.REGEX_SPACE;
import static com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants.TITLE;
import static com.mujeeb_taimoor_s1912918.currencyapp.utils.CountryUtil.getCountryFromCountryCode;
import static com.mujeeb_taimoor_s1912918.currencyapp.utils.CurrencyHelper.getCurrencyByISO;

import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;
import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyResponseModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class CurrencyParser {

    public static CurrencyResponseModel parseCurrencyResponse(String response) {
        ArrayList<CurrencyModel> currencyList = new ArrayList<>();
        CurrencyResponseModel model = new CurrencyResponseModel();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(response));
            int eventType = xpp.getEventType();
            CurrencyModel listModel = null;
            String text = "";

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase(ITEM)) {
                            listModel = new CurrencyModel();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase(ITEM)) {
                            if (listModel != null) currencyList.add(listModel);
                        } else if (tagName.equalsIgnoreCase(TITLE)) {
                            if (listModel != null) {
                                String[] title = text.split(REGEX_FORWARD_SLASH);
                                listModel.setTitle(title[1]);
                                String[] countryCode = title[1].split(REGEX_BRACKETS);
                                listModel.setCurrencyName(countryCode[0]);
                                listModel.setCountryCode(countryCode[1]);
                                String code = countryCode[1].substring(0, 2);
                                String name = getCountryFromCountryCode(code);
                                listModel.setCountryName(name);
                                CurrencyHelper flag = getCurrencyByISO(countryCode[1]);
                                if (flag != null) listModel.setCountryFlagId(flag.getFlag());
                            }
                        } else if (tagName.equalsIgnoreCase(DESCRIPTION)) {
                            if (listModel != null) {
                                String[] description = text.split(REGEX_EQUALS);
                                listModel.setDescription(text);
                                String[] currency = description[1].trim().split(REGEX_SPACE);
                                listModel.setConversionRate(currency[0]);
                            }
                        } else if (tagName.equalsIgnoreCase(LAST_BUILD_DATE)) {
                            model.setLastUpdated(text);
                        }
                        break;
                }
                eventType = xpp.next();
            }

            model.setCurrencyList(currencyList);
            return model;
        } catch (Exception Ignored) {
            return model;
        }
    }
}
