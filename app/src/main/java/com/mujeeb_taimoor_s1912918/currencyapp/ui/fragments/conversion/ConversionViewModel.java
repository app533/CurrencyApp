// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.conversion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;

public class ConversionViewModel extends ViewModel {

    CurrencyModel model;

    private MutableLiveData<String> _errorText = new MutableLiveData<>();
    public LiveData<String> errorText = _errorText;

    String convertText(Boolean isFromText1, String text) {
        try {
            Float conversionRate = Float.parseFloat(model.getConversionRate());
            Float result = 0f;
            Float requiredValue = Float.parseFloat(text);

            if (isFromText1) {
                result = requiredValue * conversionRate;
            } else {
                result = requiredValue / conversionRate;
            }
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
