package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Map.Entry<String, String>> cardsItems;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, List<Map.Entry<String, String>> cardsItems) {
        this.cardsItems = cardsItems;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map.Entry<String, String> item = cardsItems.get(position);
        holder.textViewHeader.setText(item.getKey());
        holder.textViewInfo.setText(item.getValue());
    }

    public void updateCardInfo(List<Map.Entry<String, String>> cardsItems){
        this.cardsItems = cardsItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cardsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewHeader;
        TextView textViewInfo;
        public ViewHolder(@NonNull View view) {
            super(view);
            textViewHeader = view.findViewById(R.id.textViewHeader);
            textViewInfo = view.findViewById(R.id.textViewInfo);
        }
    }
}
