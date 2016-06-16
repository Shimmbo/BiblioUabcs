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
import com.jimmy.uabcs.bibliouabcs.adapter.AuthorAdapter;
import com.jimmy.uabcs.bibliouabcs.models.Author;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import java.util.List;

public class AuthorsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AuthorAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    private TextView emptyView;

    public AuthorsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_authors, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.authorsList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new AuthorAdapter(getContext());
        emptyView = (TextView) rootView.findViewById(R.id.empty_view);
        mRecyclerView.setAdapter(mAdapter);
        LibraryService.getAuthors(new CustomSubscriber<List<Author>>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Utils.showToast(getActivity(), getString(R.string.error_authors));
            }

            @Override
            public void onNext(List<Author> authors) {
                super.onNext(authors);
                if (authors.size() == 0) {
                    mRecyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                } else
                    for (Author author : authors)
                        mAdapter.addData(author);
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
