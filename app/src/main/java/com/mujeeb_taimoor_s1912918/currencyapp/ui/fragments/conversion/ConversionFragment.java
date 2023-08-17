// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.ui.fragments.conversion;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textview.MaterialTextView;
import com.mujeeb_taimoor_s1912918.currencyapp.R;
import com.mujeeb_taimoor_s1912918.currencyapp.ui.MainActivity;

public class ConversionFragment extends Fragment {

    ConversionViewModel viewModel;

    AppCompatImageView backButton;
    AppCompatImageView flag1;
    AppCompatImageView flag2;
    MaterialTextView currencyName1;
    MaterialTextView currencyName2;
    AppCompatEditText text1;
    AppCompatEditText text2;
    MaterialTextView titleText;
    MaterialTextView legendText;
    MaterialTextView errorText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ConversionViewModel.class);
        viewModel.model = ConversionFragmentArgs.fromBundle(getArguments()).getModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_conversion, container, false);
        titleText = (MaterialTextView) root.findViewById(R.id.title_text);
        errorText = (MaterialTextView) root.findViewById(R.id.error_text);
        backButton = (AppCompatImageView) root.findViewById(R.id.back_button);
        flag1 = (AppCompatImageView) root.findViewById(R.id.image_flag_1);
        flag2 = (AppCompatImageView) root.findViewById(R.id.image_flag_2);
        currencyName1 = (MaterialTextView) root.findViewById(R.id.currency_name_1);
        currencyName2 = (MaterialTextView) root.findViewById(R.id.currency_name_2);
        text1 = (AppCompatEditText) root.findViewById(R.id.text_1);
        text2 = (AppCompatEditText) root.findViewById(R.id.text_2);
        legendText = (MaterialTextView) root.findViewById(R.id.legend_text);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    void init() {
        initTextListeners();
        initLiveDataListeners(getViewLifecycleOwner());

        backButton.setOnClickListener(view -> {
            MainActivity.getNavController().popBackStack();
        });

        titleText.setText("Great Britain(GBP) to " + viewModel.model.getCurrencyName() + " Conversion");
        flag1.setImageDrawable(requireContext().getDrawable(R.drawable.flag_gbp));
        currencyName1.setText("Great Britain(GBP)");

        flag2.setImageDrawable(requireContext().getDrawable(viewModel.model.getCountryFlagId()));
        currencyName2.setText(viewModel.model.getTitle());

        legendText.setText(viewModel.model.getDescription());

        text1.setText("1.0");
        text2.setText(viewModel.convertText(true, "1.0"));
    }

    void initTextListeners() {
        text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().isEmpty() && text1.isFocused()) {
                    text2.setText(viewModel.convertText(true, charSequence.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        text2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().isEmpty() && text2.isFocused()) {
                    text1.setText(viewModel.convertText(false, charSequence.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    void initLiveDataListeners(LifecycleOwner owner) {
        viewModel.errorText.observe(owner, text -> {
            if (text.isEmpty()) {
                errorText.setVisibility(View.GONE);
            } else {
                errorText.setVisibility(View.VISIBLE);
                errorText.setText(text);
            }
        });

    }

}
