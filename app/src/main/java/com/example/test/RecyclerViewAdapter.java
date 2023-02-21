package com.example.test;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<CardInfoItemModel> dataSet;
    private OnBankUrlClickListener onBankUrlClickListener;
    private OnBankPhoneClickListener onBankPhoneClickListener;
    private OnBankMapClickListener onBankMapClickListener;

    public void setOnBankUrlClickListener(OnBankUrlClickListener onBankUrlClickListener) {
        this.onBankUrlClickListener = onBankUrlClickListener;
    }

    public void setOnBankPhoneClickListener(OnBankPhoneClickListener onBankPhoneClickListener) {
        this.onBankPhoneClickListener = onBankPhoneClickListener;
    }

    public void setOnBankMapClickListener(OnBankMapClickListener onBankMapClickListener) {
        this.onBankMapClickListener = onBankMapClickListener;
    }

    public RecyclerViewAdapter(List<CardInfoItemModel> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int getItemViewType(int position) {
        if (dataSet.get(position) instanceof MainCardInfo) {
            return 1;
        } else if (dataSet.get(position) instanceof CountryInfoItemModel) {
            return 2;
        } else {
            return 3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_item, parent, false);
            return new MainInfoViewHolder(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_country_info, parent, false);
            return new CountryInfoViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_bank_info, parent, false);
            return new BankInfoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainInfoViewHolder) {
            MainInfoViewHolder mapViewHolder = (MainInfoViewHolder) holder;
            MainCardInfo mainCardInfo = (MainCardInfo) dataSet.get(position);
            mapViewHolder.textViewHeader.setText(mainCardInfo.header());
            mapViewHolder.textViewInfo.setText(mainCardInfo.getValue());
        } else if (holder instanceof CountryInfoViewHolder) {
            CountryInfoViewHolder countryInfoViewHolder = (CountryInfoViewHolder) holder;
            CountryInfoItemModel countryInfoItemModel = (CountryInfoItemModel) dataSet.get(position);
            if (countryInfoItemModel.getCountryName() != null && !countryInfoItemModel.getCountryName().isEmpty()) {
                countryInfoViewHolder.textViewCountryHeader.setVisibility(View.VISIBLE);
                countryInfoViewHolder.textViewCountryName.setVisibility(View.VISIBLE);
                countryInfoViewHolder.textViewCountryHeader.setText(countryInfoItemModel.getHeader());
                countryInfoViewHolder.textViewCountryName.setText(countryInfoItemModel.getCountryName());
            }
            if (countryInfoItemModel.getCoordinate() != null && !countryInfoItemModel.getCoordinate().isEmpty()) {
                countryInfoViewHolder.textViewLatitudeLongitude.setVisibility(View.VISIBLE);
                countryInfoViewHolder.textViewCountryCoordinates.setVisibility(View.VISIBLE);
                countryInfoViewHolder.textViewLatitudeLongitude.setText(countryInfoItemModel.getHeaderCoordinate());
                countryInfoViewHolder.textViewCountryCoordinates.setText(countryInfoItemModel.getCoordinate());
                countryInfoViewHolder.textViewCountryCoordinates.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBankMapClickListener.onBankMapClick(
                                countryInfoItemModel.getCoordinate());
                    }
                });
            }
        } else {
            BankInfoViewHolder bankInfoViewHolder = (BankInfoViewHolder) holder;
            BankInfoItemModel bankInfoItemModel = (BankInfoItemModel) dataSet.get(position);
            bankInfoViewHolder.textViewBankHeader.setText(bankInfoItemModel.header());
            if (bankInfoItemModel.getBankName() != null && !bankInfoItemModel.getBankName().isEmpty()) {
                bankInfoViewHolder.textViewBankName.setVisibility(View.VISIBLE);
                bankInfoViewHolder.textViewBankName.setText(bankInfoItemModel.getBankName());
            }
            if (bankInfoItemModel.getBankUrl() != null && !bankInfoItemModel.getBankUrl().isEmpty()) {
                bankInfoViewHolder.textViewBankUrl.setVisibility(View.VISIBLE);
                bankInfoViewHolder.textViewBankUrl.setText(bankInfoItemModel.getBankUrl());
                bankInfoViewHolder.textViewBankUrl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBankUrlClickListener.onBankUrlClick(bankInfoItemModel.getBankUrl());
                    }
                });
            }
            if (bankInfoItemModel.getBankPhone() != null && !bankInfoItemModel.getBankPhone().isEmpty()) {
                bankInfoViewHolder.textViewBankPhone.setVisibility(View.VISIBLE);
                bankInfoViewHolder.textViewBankPhone.setText(bankInfoItemModel.getBankPhone());
                bankInfoViewHolder.textViewBankPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBankPhoneClickListener.onBankPhoneClick(bankInfoItemModel.getBankPhone());
                    }
                });
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateCardInfo(List<CardInfoItemModel> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    interface OnBankUrlClickListener {
        void onBankUrlClick(String url);
    }

    interface OnBankPhoneClickListener {
        void onBankPhoneClick(String phone);
    }

    interface OnBankMapClickListener {
        void onBankMapClick(String map);
    }

    public static class BankInfoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewBankHeader;
        public TextView textViewBankName;
        public TextView textViewBankUrl;
        public TextView textViewBankPhone;

        public BankInfoViewHolder(View view) {
            super(view);
            textViewBankHeader = view.findViewById(R.id.textViewBankHeader);
            textViewBankName = view.findViewById(R.id.textViewBankName);
            textViewBankUrl = view.findViewById(R.id.textViewBankUrl);
            textViewBankPhone = view.findViewById(R.id.textViewBankPhone);
        }
    }

    public static class CountryInfoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCountryHeader;
        public TextView textViewLatitudeLongitude;
        public TextView textViewCountryName;
        public TextView textViewCountryCoordinates;

        public CountryInfoViewHolder(View view) {
            super(view);
            textViewCountryHeader = view.findViewById(R.id.textViewCountryHeader);
            textViewLatitudeLongitude = view.findViewById(R.id.textViewLatitudeLongitude);
            textViewCountryName = view.findViewById(R.id.textViewCountryName);
            textViewCountryCoordinates = view.findViewById(R.id.textViewCountryCoordinates);
        }
    }

    public class MainInfoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewHeader;
        TextView textViewInfo;

        public MainInfoViewHolder(@NonNull View view) {
            super(view);
            textViewHeader = view.findViewById(R.id.textViewHeader);
            textViewInfo = view.findViewById(R.id.textViewInfo);
        }
    }
}
