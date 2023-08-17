// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CurrencyModel implements Parcelable {

    String title;
    String description;
    int countryFlagId;
    String conversionRate;
    String countryCode;
    String currencyName;

    String countryName;

    public CurrencyModel() {
    }

    protected CurrencyModel(Parcel in) {
        title = in.readString();
        description = in.readString();
        countryFlagId = in.readInt();
        conversionRate = in.readString();
        countryCode = in.readString();
        currencyName = in.readString();
        countryName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(countryFlagId);
        dest.writeString(conversionRate);
        dest.writeString(countryCode);
        dest.writeString(currencyName);
        dest.writeString(countryName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CurrencyModel> CREATOR = new Creator<CurrencyModel>() {
        @Override
        public CurrencyModel createFromParcel(Parcel in) {
            return new CurrencyModel(in);
        }

        @Override
        public CurrencyModel[] newArray(int size) {
            return new CurrencyModel[size];
        }
    };

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountryFlagId() {
        return countryFlagId;
    }

    public void setCountryFlagId(int countryFlagId) {
        this.countryFlagId = countryFlagId;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }
}
