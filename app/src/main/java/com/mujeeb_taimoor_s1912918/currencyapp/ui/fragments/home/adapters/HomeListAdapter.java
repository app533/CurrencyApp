// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mujeeb_taimoor_s1912918.currencyapp.R;
import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.listeners.ItemOnClickListener;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.CurrencyColorUtils;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {

    private List<CurrencyModel> currencyList;
    ItemOnClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView flagImageView;
        private final AppCompatTextView nameTextView;
        private final MaterialTextView conversionTextView;

        public ViewHolder(View view) {
            super(view);
            flagImageView = (AppCompatImageView) view.findViewById(R.id.currency_flag_image);
            nameTextView = (AppCompatTextView) view.findViewById(R.id.currency_name_text);
            conversionTextView = (MaterialTextView) view.findViewById(R.id.currency_rate_text);
        }

        public AppCompatImageView getFlagImageView() {
            return flagImageView;
        }

        public AppCompatTextView getNameTextView() {
            return nameTextView;
        }

        public MaterialTextView getConversionTextView() {
            return conversionTextView;
        }
    }

    public HomeListAdapter(List<CurrencyModel> currencyList, ItemOnClickListener listener) {
        this.currencyList = currencyList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_list_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        CurrencyModel model = currencyList.get(position);
        viewHolder.getFlagImageView().setImageResource(model.getCountryFlagId());
        viewHolder.getNameTextView().setText(model.getCurrencyName());
        viewHolder.getConversionTextView().setText(model.getConversionRate() + " " + model.getCountryCode());
        viewHolder.getConversionTextView().setTextColor(viewHolder.itemView.getContext().getColor(CurrencyColorUtils.getColor(Float.parseFloat(model.getConversionRate()))));

        viewHolder.itemView.setOnClickListener(view -> {
            listener.onItemClick(model);
        });
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }
}

