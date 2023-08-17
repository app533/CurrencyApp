// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.data.model;

import java.util.List;

public class CurrencyResponseModel {

    List<CurrencyModel> currencyList;
    String lastUpdated;

    public List<CurrencyModel> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<CurrencyModel> currencyList) {
        this.currencyList = currencyList;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
