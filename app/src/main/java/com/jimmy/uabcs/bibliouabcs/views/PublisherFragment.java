package com.jimmy.uabcs.bibliouabcs.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.adapter.PublisherAdapter;
import com.jimmy.uabcs.bibliouabcs.database.LibraryDBHelper;
import com.jimmy.uabcs.bibliouabcs.models.Publisher;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublisherFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private PublisherAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private TextView emptyView;

    public PublisherFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_publisher, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.publisherList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        emptyView = (TextView) rootView.findViewById(R.id.empty_view);
        mAdapter = new PublisherAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        LibraryService.getPublishers(new CustomSubscriber<List<Publisher>>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Utils.showToast(getActivity(), getString(R.string.error_publishers));
            }

            @Override
            public void onNext(List<Publisher> publishers) {
                super.onNext(publishers);
                if (publishers.size() == 0) {
                    mRecyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                } else
                    for (Publisher publisher : publishers)
                        mAdapter.addData(publisher);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.base, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(item);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.filter(newText);
                return true;
            }
        });
    }
}
