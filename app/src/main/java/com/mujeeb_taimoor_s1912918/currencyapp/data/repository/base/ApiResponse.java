// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.data.repository.base;

public interface ApiResponse<T> {

    void Success(T obj);
    void Failure(String message);
}
