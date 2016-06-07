package com.jimmy.uabcs.bibliouabcs.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.adapter.BookAdapter;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import java.util.List;

public class BooksFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private LinearLayoutManager layoutManager;
    public BooksFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.bookList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new BookAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        LibraryService.getBooks(new CustomSubscriber<List<Book>>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Utils.showToast(getActivity(), getString(R.string.error_books));
            }

            @Override
            public void onNext(List<Book> books) {
                super.onNext(books);
                for(Book book:books)
                    mAdapter.addData(book);
            }
        });
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
