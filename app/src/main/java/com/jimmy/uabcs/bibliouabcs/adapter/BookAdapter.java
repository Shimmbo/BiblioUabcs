package com.jimmy.uabcs.bibliouabcs.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;
import com.jimmy.uabcs.bibliouabcs.utils.VolleySingleton;
import com.jimmy.uabcs.bibliouabcs.views.BookFragment;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.GSON;
import static com.jimmy.uabcs.bibliouabcs.utils.Constants.URL;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mItems;
    private List<Book> itemsCopy;
    private Context context;

    public BookAdapter(Context context) {
        super();
        mItems = new ArrayList<Book>();
        itemsCopy = new ArrayList<Book>();
        this.context = context;
    }

    public void addData(Book mBook) {
        mItems.add(mBook);
        itemsCopy.add(mBook);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void filter(String text) {
        if (text.isEmpty()) {
            mItems.clear();
            mItems.addAll(itemsCopy);
        } else {
            ArrayList<Book> result = new ArrayList<>();
            text = text.toLowerCase();
            for (Book item : itemsCopy) {
                if (item.getName().toLowerCase().contains(text)) {
                    result.add(item);
                }
            }
            mItems.clear();
            mItems.addAll(result);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.books, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Book mBook = mItems.get(i);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(mBook.getYear());
        viewHolder.name.setText(mBook.getName());
        if (mBook.getGenre().size() > 0)
            viewHolder.genres.setText(mBook.genreJoin());

        if (mBook.getAuthor().size() > 0)
            viewHolder.authors.setText(mBook.authorJoin());
        ImageLoader mImageLoader = VolleySingleton.getInstance().getImageLoader();
        viewHolder.mImageView.setDefaultImageResId(R.drawable.no_book_image);
        String imagePath = mBook.getImagePath();
        if (imagePath != null && imagePath != "")
            viewHolder.mImageView.setImageUrl(URL + imagePath, mImageLoader);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView genres;
        public TextView authors;
        public NetworkImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.bookName);
            genres = (TextView) itemView.findViewById(R.id.genres);
            authors = (TextView) itemView.findViewById(R.id.authors);
            mImageView = (NetworkImageView) itemView.findViewById(R.id.book_photo);
            genres.setOnClickListener(this);
            name.setOnClickListener(this);
            authors.setOnClickListener(this);
            mImageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String jsonBook = GSON.toJson(mItems.get(pos));
            Fragment bookFragment = BookFragment.newInstance(jsonBook);
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            Utils.startFragment(manager, bookFragment);
        }
    }
}
