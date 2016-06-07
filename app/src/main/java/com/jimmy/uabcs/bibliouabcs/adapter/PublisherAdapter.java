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

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Author;
import com.jimmy.uabcs.bibliouabcs.models.Publisher;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;
import com.jimmy.uabcs.bibliouabcs.views.BooksFragment;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.GSON;

public class PublisherAdapter extends RecyclerView.Adapter<PublisherAdapter.ViewHolder> {
    private List<Publisher> mItems;
    private Context context;
    public PublisherAdapter(Context context) {
        super();
        mItems = new ArrayList<Publisher>();
        this.context = context;
    }

    public void addData(Publisher mPublisher) {
        mItems.add(mPublisher);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
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
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.publisherName);
            name.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String jsonBooks = GSON.toJson(mItems.get(pos).getBook());
            Fragment booksFragment = BooksFragment.newInstance(jsonBooks);
            FragmentManager manager = ((FragmentActivity) context).getSupportFragmentManager();
            Utils.startFragment(manager,booksFragment);
        }
    }
}
