package com.jimmy.uabcs.bibliouabcs.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.adapter.AuthorAdapter;
import com.jimmy.uabcs.bibliouabcs.adapter.BookAdapter;
import com.jimmy.uabcs.bibliouabcs.models.Author;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import java.util.List;

public class AuthorsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AuthorAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    public AuthorsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_authors, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.authorsList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new AuthorAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        LibraryService.getAuthors(new CustomSubscriber<List<Author>>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Utils.showToast(getActivity(), getString(R.string.error_books));
            }

            @Override
            public void onNext(List<Author> authors) {
                super.onNext(authors);
                for(Author author:authors)
                    mAdapter.addData(author);
            }
        });
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
