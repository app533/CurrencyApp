// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.mujeeb_taimoor_s1912918.currencyapp.R;
import com.mujeeb_taimoor_s1912918.currencyapp.data.model.CurrencyModel;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.home.listeners.ItemOnClickListener;
import com.mujeeb_taimoor_s1912918.currencyapp.utils.CurrencyColorUtils;

import java.util.List;

public class HomeSearchAdapter extends RecyclerView.Adapter<HomeSearchAdapter.ViewHolder> {

    private List<CurrencyModel> currencyList;
    private ItemOnClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView flagImageView;
        private final MaterialTextView nameTextView;
        private final MaterialTextView conversionTextView;

        public ViewHolder(View view) {
            super(view);
            flagImageView = (AppCompatImageView) view.findViewById(R.id.image_flag);
            nameTextView = (MaterialTextView) view.findViewById(R.id.currency_name);
            conversionTextView = (MaterialTextView) view.findViewById(R.id.conversion_text);
        }

        public AppCompatImageView getFlagImageView() {
            return flagImageView;
        }

        public MaterialTextView getNameTextView() {
            return nameTextView;
        }

        public MaterialTextView getConversionTextView() {
            return conversionTextView;
        }
    }

    public HomeSearchAdapter(List<CurrencyModel> currencyList, ItemOnClickListener listener) {
        this.listener = listener;
        this.currencyList = currencyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_home_search_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        CurrencyModel model = currencyList.get(position);
        viewHolder.getFlagImageView().setImageResource(model.getCountryFlagId());
        viewHolder.getNameTextView().setText(model.getTitle());
        viewHolder.getConversionTextView().setText(model.getConversionRate());
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
