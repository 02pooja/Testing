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

public class RawAdapter  extends RecyclerView.Adapter<RawAdapter.NewsViewHolder> {

    Context context;
    ArrayList<RawModel> articles;

    public RawAdapter(Context context, ArrayList<RawModel> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public RawAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RawAdapter.NewsViewHolder holder, int position) {

        if(articles.get(position).getTitle()!=null) {
            holder.tvName.setText(articles.get(position).getTitle().toString());
        }
        if(articles.get(position).getDescription()!=null) {
            holder.tvDesCription.setText(articles.get(position).getDescription().toString());
        }

        if(articles.get(position).getImageHref()!=null) {
            Picasso.get().load(articles.get(position).getImageHref()).into(holder.ivNews);
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDesCription;
        ImageView ivNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.title);
            tvDesCription = itemView.findViewById(R.id.des);
            ivNews = itemView.findViewById(R.id.image);

        }
    }

}
