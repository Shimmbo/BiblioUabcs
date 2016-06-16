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

import com.jimmy.uabcs.bibliouabcs.App;
import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Publisher;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;
import com.jimmy.uabcs.bibliouabcs.views.BooksFragment;

import java.util.ArrayList;
import java.util.List;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.GSON;

public class PublisherAdapter extends RecyclerView.Adapter<PublisherAdapter.ViewHolder> {
    private List<Publisher> mItems;
    private Context context;
    private List<Publisher> itemsCopy;

    public PublisherAdapter(Context context) {
        super();
        mItems = new ArrayList<Publisher>();
        itemsCopy = new ArrayList<Publisher>();
        this.context = context;
    }

    public void addData(Publisher mPublisher) {
        mItems.add(mPublisher);
        itemsCopy.add(mPublisher);
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
            ArrayList<Publisher> result = new ArrayList<>();
            text = text.toLowerCase();
            for (Publisher item : itemsCopy) {
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
                .inflate(R.layout.publishers, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Publisher mPublisher = mItems.get(i);
        viewHolder.name.setText(mPublisher.getName());
        String message = App.getContext().getString(R.string.books, mPublisher.getBook().size());
        viewHolder.counts.setText(message);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView counts;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.publisherName);
            name.setOnClickListener(this);

            counts = (TextView) itemView.findViewById(R.id.publisherBooksCount);
            counts.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String jsonBooks = GSON.toJson(mItems.get(pos).getBook());
            Fragment booksFragment = BooksFragment.newInstance(jsonBooks);
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            Utils.startFragment(manager, booksFragment);
        }
    }
}
