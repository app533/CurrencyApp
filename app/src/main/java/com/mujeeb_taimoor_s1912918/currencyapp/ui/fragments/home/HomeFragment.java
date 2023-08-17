// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.mujeeb_taimoor_s1912918.currencyapp.R;
import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.MainActivity;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.adapters.HomeListAdapter;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.adapters.HomeSearchAdapter;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.listeners.ItemOnClickListener;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.TimeUtils;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.enums.SearchFilter;

import java.util.List;

public class HomeFragment extends Fragment implements ItemOnClickListener {

    HomeViewModel viewModel;
    HomeSearchAdapter homeSearchAdapter;
    HomeListAdapter homeListAdapter;

    RecyclerView homeSearchRecyclerview;
    RecyclerView homeListRecyclerview;
    TextView lastUpdatedTextView;
    TextView lastFetchedTextView;
    AppCompatTextView refreshButton;
    SearchView searchView;
    Chip currencyChip;
    Chip countryChip;
    CircularProgressIndicator progressIndicator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        currencyChip = (Chip) root.findViewById(R.id.currency_code_chip);
        countryChip = (Chip) root.findViewById(R.id.country_chip);
        homeSearchRecyclerview = (RecyclerView) root.findViewById(R.id.home_search_recyclerview);
        homeListRecyclerview = (RecyclerView) root.findViewById(R.id.home_list_recyclerview);
        lastUpdatedTextView = (TextView) root.findViewById(R.id.last_updated_text);
        lastFetchedTextView = (TextView) root.findViewById(R.id.last_fetched_text);
        searchView = (SearchView) root.findViewById(R.id.country_search);
        refreshButton = (AppCompatTextView) root.findViewById(R.id.refresh_button);
        progressIndicator = (CircularProgressIndicator) root.findViewById(R.id.loading_progress);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    void init() {
        evalFocus();
        initSearchView();
        listenForLiveData(getViewLifecycleOwner());

        refreshButton.setOnClickListener((view) -> {
            viewModel.getCurrencies();
        });

        currencyChip.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            searchView.setQuery("", true);
        });
    }

    void evalFocus() {
        if (searchView.isFocused() || !searchView.getQuery().toString().isEmpty()) {
            homeListRecyclerview.setVisibility(View.GONE);
            homeSearchRecyclerview.setVisibility(View.VISIBLE);
        } else {
            homeListRecyclerview.setVisibility(View.VISIBLE);
            homeSearchRecyclerview.setVisibility(View.GONE);
        }
    }

    void initSearchView() {
        searchView.setOnQueryTextFocusChangeListener((view, isFocused) -> {
            evalFocus();
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                viewModel.filterList(query, getFilterType());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.filterList(newText, getFilterType());
                return false;
            }
        });
    }

    SearchFilter getFilterType() {
        SearchFilter filter;
        if (currencyChip.isChecked())
            filter = SearchFilter.CURRENCY_CODE;
        else filter = SearchFilter.COUNTRY_NAME;
        return filter;
    }

    void listenForLiveData(LifecycleOwner owner) {
        viewModel.homeSearchViewModel.observe(owner, listModel -> {
            evalFocus();
            setHomeSearchAdapter(listModel.getCurrencyList());
        });

        viewModel.homeRecyclerViewModel.observe(owner, listModel -> {
            setHomeListAdapter(listModel.getCurrencyList());
            lastUpdatedTextView.setText("Last Updated on Website: " + listModel.getLastUpdated());
            lastFetchedTextView.setText("Last Fetched: " + TimeUtils.getUTCstring());
        });

        viewModel.isLoading.observe(owner, isLoading -> {
            if (isLoading) {
                progressIndicator.setVisibility(View.VISIBLE);
            } else {
                progressIndicator.setVisibility(View.GONE);
            }
        });
    }

    void setHomeSearchAdapter(List<CurrencyModel> list) {
        homeSearchAdapter = new HomeSearchAdapter(list, this);
        homeSearchRecyclerview.setAdapter(homeSearchAdapter);
    }

    void setHomeListAdapter(List<CurrencyModel> list) {
        homeListAdapter = new HomeListAdapter(list, this);
        homeListRecyclerview.setAdapter(homeListAdapter);
    }

    @Override
    public void onItemClick(CurrencyModel model) {
        MainActivity.getNavController().navigate(HomeFragmentDirections.actionHomeFragmentToConversionFragment(model));
    }

    @Override
    public void onStop() {
        homeSearchAdapter = null;
        homeListAdapter = null;

        super.onStop();
    }
}
