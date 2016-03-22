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
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    private static final int BOOK_INFORMATION_VIEW_TYPE = 0;
    private static final int BOOK_COVER_VIEW_TYPE = 1;

    private final List<Media> medias;
    private final Context context;

    public MediaAdapter(Context context, List<Media> medias) {
        this.context = context;
        this.medias = medias;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder vh;
        switch (viewType) {
            case BOOK_INFORMATION_VIEW_TYPE:
                vh = new BookInformationViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.book_information, parent, false));
                break;
            case BOOK_COVER_VIEW_TYPE:
            default:
                vh = new BookCoverViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.book_cover, parent, false));
        }
        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BOOK_INFORMATION_VIEW_TYPE:
                BookInformation bookInformation = (BookInformation) medias.get(position);
                BookInformationViewHolder bookInformationViewHolder = (BookInformationViewHolder) holder;
                bookInformationViewHolder.titleView.setText(bookInformation.getTitle());
                bookInformationViewHolder.authorView.setText(bookInformation.getAuthor());
                break;
            case BOOK_COVER_VIEW_TYPE:
            default:
                BookCover bookCover = (BookCover) medias.get(position);
                BookCoverViewHolder bookCoverViewHolder = (BookCoverViewHolder) holder;
                Picasso.with(context)
                        .load(bookCover.getCoverImageId())
                        .placeholder(R.drawable.placeholder)
                        .into(bookCoverViewHolder.coverView);
                break;
        }
    }

    @Override public int getItemCount() {
        return medias.size();
    }

    @Override public int getItemViewType(int position) {
        int viewType;
        if (medias.get(position).getType().equals(BookInformation.MEDIA_TYPE)) {
            viewType = BOOK_INFORMATION_VIEW_TYPE;
        } else {
            viewType = BOOK_COVER_VIEW_TYPE;
        }
        return viewType;
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class BookInformationViewHolder extends ViewHolder {
        @Bind(R.id.title_tv) TextView titleView;
        @Bind(R.id.author_tv) TextView authorView;

        public BookInformationViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class BookCoverViewHolder extends ViewHolder {
        @Bind(R.id.cover_iv) ImageView coverView;

        public BookCoverViewHolder(View itemView) {
            super(itemView);
        }
    }
}