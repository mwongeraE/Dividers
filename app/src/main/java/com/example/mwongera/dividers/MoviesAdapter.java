package com.example.mwongera.dividers;

/**
 * Created by mwongera on 3/22/16.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private final List<Movie> items;
    private final Context context;

    public MoviesAdapter(List<Movie> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Movie item = items.get(position);

        holder.titleView.setText(item.getTitle());
        holder.directorView.setText(item.getDirector());
        holder.ratingView.setText(
                item.getRating() + context.getResources().getString(R.string.rating_by_100));
        Picasso.with(context)
                .load(item.getCoverResourceId())
                .placeholder(R.drawable.placeholder)
                .into(holder.coverView);

        holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.title_tv) TextView titleView;
        @Bind(R.id.director_tv) TextView directorView;
        @Bind(R.id.rating_tv) TextView ratingView;
        @Bind(R.id.cover_iv) ImageView coverView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}