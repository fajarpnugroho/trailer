package com.iak.finalproject.fajar.trailer.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iak.finalproject.fajar.trailer.R;
import com.iak.finalproject.fajar.trailer.model.MovieEntity;
import com.iak.finalproject.fajar.trailer.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter {

    private List<MovieEntity> items = new ArrayList<>();

    public void setItems(List<MovieEntity> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieHolder movieHolder = (MovieHolder) holder;
        movieHolder.bind(ImageUtils
                .generateImageUrl(items.get(position).getPosterPath()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(@LayoutRes int resId, ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        }
    }

    public static class MovieHolder extends BaseHolder {

        private ImageView moviePosterView;

        public MovieHolder(ViewGroup parent) {
            super(R.layout.item_movie, parent);
            moviePosterView = (ImageView)
                    itemView.findViewById(R.id.movie_poster);
        }

        public void bind(String imageUrl) {
            Picasso.with(itemView.getContext())
                    .load(imageUrl)
                    .fit()
                    .centerCrop()
                    .into(moviePosterView);
        }
    }
}
