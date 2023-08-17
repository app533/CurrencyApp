// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.data.repository.base;

import okhttp3.OkHttpClient;

public class ClientProvider {

    private ClientProvider() {
    }

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
        return okHttpClient;
    }

}
