package com.mariammuhammad.chips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {

    private List<MobileModel> mobileList;
    private OnMobileClickListener listener;

    public void setMobileList(List<MobileModel> mobileList) {
        this.mobileList = mobileList;
    }

    public MobileAdapter(List<MobileModel> mobileList, OnMobileClickListener listener) {
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        MobileModel mobileModel = mobileList.get(position);
        holder.textTitle.setText(mobileList.get(position).getTitle());
        holder.textDescription.setText(mobileList.get(position).getDescription());
        holder.textIcon.setText(mobileList.get(position).getIconText());


        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMobileClick(mobileModel);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mobileList.size();
    }

        public interface OnMobileClickListener {
            void onMobileClick(MobileModel mobileModel);
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle,textDescription,textIcon;
        ImageView imageView;

        public ViewHolder(View itemView) {
                super(itemView);
                textTitle= itemView.findViewById(R.id.textTitle);
                textDescription=itemView.findViewById(R.id.textDescription);
                textIcon=itemView.findViewById(R.id.txtIcon);
                imageView=itemView.findViewById(R.id.circleImage);
            }
        }
    }


