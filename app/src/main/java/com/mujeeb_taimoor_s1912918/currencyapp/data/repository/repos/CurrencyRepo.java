// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.data.repository.repos;

import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyResponseModel;
import com.mujeeb_taimoor_s1912918.currencyapp.data.repository.DataConstants;
import com.mujeeb_taimoor_s1912918.currencyapp.data.repository.base.ApiResponse;
import com.mujeeb_taimoor_s1912918.currencyapp.data.repository.base.ClientProvider;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.CurrencyParser;

import java.util.concurrent.Executors;

import okhttp3.Request;
import okhttp3.Response;

public class CurrencyRepo {

    private CurrencyRepo(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public static CurrencyRepo instance;
    private ApiResponse apiResponse;

    public static CurrencyRepo getInstance(ApiResponse apiResponse) {
        if (instance == null) {
            instance = new CurrencyRepo(apiResponse);
        }
        return instance;
    }

    public void getCurrencyList() {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                Request request = new Request.Builder()
                        .url(DataConstants.BASE_URL + DataConstants.GET_CURRENCY)
                        .build();

                try (Response response = ClientProvider.getHttpClient().newCall(request).execute()) {
                    CurrencyResponseModel model = CurrencyParser.parseCurrencyResponse(response.body().string());
                    apiResponse.Success(model);
                } catch (Exception e) {
                    apiResponse.Failure(e.getLocalizedMessage().toString());
                }
            } catch (Exception e) {

            }
        });
    }

}
