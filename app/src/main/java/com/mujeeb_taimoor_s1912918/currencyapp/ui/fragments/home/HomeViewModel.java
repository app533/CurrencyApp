// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;
import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyResponseModel;
import com.mujeeb_taimoor_s1912918.currencyapp.data.repository.base.ApiResponse;
import com.mujeeb_taimoor_s1912918.currencyapp.data.repository.repos.CurrencyRepo;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.Constants;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.enums.SearchFilter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeViewModel extends ViewModel implements ApiResponse {

    private CurrencyRepo repo;

    private CurrencyResponseModel model;

    private MutableLiveData<CurrencyResponseModel> _homeRecyclerViewModel = new MutableLiveData();
    LiveData<CurrencyResponseModel> homeRecyclerViewModel = _homeRecyclerViewModel;

    private MutableLiveData<CurrencyResponseModel> _homeSearchViewModel = new MutableLiveData();
    LiveData<CurrencyResponseModel> homeSearchViewModel = _homeSearchViewModel;

    private MutableLiveData<String> _errorMessage = new MutableLiveData<>();
    LiveData<String> message = _errorMessage;

    private MutableLiveData<Boolean> _isLoading = new MutableLiveData<>(true);
    LiveData<Boolean> isLoading = _isLoading;

    public HomeViewModel() {
        repo = CurrencyRepo.getInstance(this);
        getCurrencies();
    }

    void getCurrencies() {
        _isLoading.postValue(true);
        repo.getCurrencyList();
    }

    @Override
    public void Success(Object obj) {
        _isLoading.postValue(false);
        if (obj instanceof CurrencyResponseModel) {
            model = (CurrencyResponseModel) obj;
            List<CurrencyModel> homeList = model.getCurrencyList()
                    .stream()
                    .filter(model -> model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_USA) ||
                            model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_JAPAN) ||
                            model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_EURO) ||
                            model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_UAE) ||
                            model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_CANADA) ||
                            model.getCountryCode().equalsIgnoreCase(Constants.CURRENCY_CHINA)
                    )
                    .sorted(Comparator.comparing(CurrencyModel::getCurrencyName))
                    .collect(Collectors.toList());

            CurrencyResponseModel homeModel = new CurrencyResponseModel();
            homeModel.setCurrencyList(homeList);
            homeModel.setLastUpdated(model.getLastUpdated());

            this._homeRecyclerViewModel.postValue(homeModel);
            this._homeSearchViewModel.postValue((CurrencyResponseModel) obj);
        }
    }

    @Override
    public void Failure(String message) {
        _isLoading.postValue(false);
        if (message != null)
            this._errorMessage.postValue(message);
    }

    public void filterList(String query, SearchFilter filterBy) {
        if (model != null) {
            if (query != null || !query.isEmpty()) {
                List<CurrencyModel> filteredList;
                if (filterBy == SearchFilter.CURRENCY_CODE)
                    filteredList = model.getCurrencyList()
                            .stream()
                            .filter(model -> model.getCountryCode().toLowerCase().startsWith(query.toLowerCase()))
                            .sorted(Comparator.comparing(CurrencyModel::getCurrencyName))
                            .collect(Collectors.toList());
                else
                    filteredList = model.getCurrencyList()
                            .stream()
                            .filter(model -> model.getCountryName().toLowerCase().startsWith(query.toLowerCase()))
                            .sorted(Comparator.comparing(CurrencyModel::getCurrencyName))
                            .collect(Collectors.toList());

                CurrencyResponseModel filteredModel = new CurrencyResponseModel();
                filteredModel.setLastUpdated(model.getLastUpdated());
                filteredModel.setCurrencyList(filteredList);
                _homeSearchViewModel.postValue(filteredModel);
            } else {
                _homeSearchViewModel.postValue(model);
            }
        }
    }
}
