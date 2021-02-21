package com.example.testing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testing.R;
import com.example.testing.model.RawModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RawAdapter  extends RecyclerView.Adapter<RawAdapter.RawsViewHolder> {

    Context context;
    ArrayList<RawModel> rawdata;

    public RawAdapter(Context context, ArrayList<RawModel> articles) {
        this.context = context;
        this.rawdata = articles;
    }

    @NonNull
    @Override
    public RawAdapter.RawsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new  RawsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RawAdapter.RawsViewHolder holder, int position) {

        if(rawdata.get(position).getTitle()!=null) {
            holder.tvName.setText(rawdata.get(position).getTitle().toString());
        }
        if(rawdata.get(position).getDescription()!=null) {
            holder.tvDesCription.setText(rawdata.get(position).getDescription().toString());
        }

        if(rawdata.get(position).getImageHref()!=null) {
            Picasso.get().load(rawdata.get(position).getImageHref()).into(holder.ivNews);
        }
    }

    @Override
    public int getItemCount() {
        return rawdata.size();
    }

    public class RawsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDesCription;
        ImageView ivNews;

        public RawsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.title);
            tvDesCription = itemView.findViewById(R.id.des);
            ivNews = itemView.findViewById(R.id.image);

        }
    }

}
