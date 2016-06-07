package com.jimmy.uabcs.bibliouabcs.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.utils.Constants;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;
import com.jimmy.uabcs.bibliouabcs.views.BookFragment;
import com.jimmy.uabcs.bibliouabcs.views.BooksFragment;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mItems;
    private Context context;
    public BookAdapter(Context context) {
        super();
        mItems = new ArrayList<Book>();
        this.context = context;
    }

    public void addData(Book mBook) {
        mItems.add(mBook);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
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
        viewHolder.date.setText(s);
        viewHolder.edition.setText(String.valueOf(mBook.getEdition()));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView edition;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.bookName);
            edition = (TextView) itemView.findViewById(R.id.edition);
            date = (TextView) itemView.findViewById(R.id.year);
            date.setOnClickListener(this);
            name.setOnClickListener(this);
            edition.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String jsonBook = Constants.GSON.toJson(mItems.get(pos));
            Fragment bookFragment = BookFragment.newInstance(jsonBook);
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            Utils.startFragment(manager,bookFragment);
        }
    }
}
