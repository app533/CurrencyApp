// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.utils;

import com.mujeeb_taimoor_s1912918.currencyapp.R;

public class CurrencyColorUtils {

    public static int getColor(Float currency) {
        if (currency < 1.0) {
           return R.color.currency_strength_0;
        } else if (currency > 1.0 && currency < 5.0) {
            return R.color.currency_strength_1;
        } else if (currency > 5.0 && currency < 10.0) {
            return R.color.currency_strength_2;
        }else{
            return R.color.currency_strength_3;
        }
    }

}
