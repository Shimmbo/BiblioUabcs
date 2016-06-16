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

import com.google.gson.reflect.TypeToken;
import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.adapter.BookAdapter;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.network.CustomSubscriber;
import com.jimmy.uabcs.bibliouabcs.network.LibraryService;
import com.jimmy.uabcs.bibliouabcs.utils.Utils;

import java.lang.reflect.Type;
import java.util.List;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.GSON;

public class BooksFragment extends Fragment {
    private static final String BOOKS_PARAM = "books";
    private List<Book> booksParam;
    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private TextView emptyView;
    private LinearLayoutManager layoutManager;

    public BooksFragment() {
    }

    public static BooksFragment newInstance(String param1) {
        BooksFragment fragment = new BooksFragment();
        Bundle args = new Bundle();
        args.putString(BOOKS_PARAM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            booksParam = (List<Book>) GSON.fromJson(getArguments().getString(BOOKS_PARAM), listType);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.bookList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        emptyView = (TextView) rootView.findViewById(R.id.empty_view);
        mAdapter = new BookAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        if (booksParam == null)
            LibraryService.getBooks(new CustomSubscriber<List<Book>>() {

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    Utils.showToast(getActivity(), getString(R.string.error_books));
                }

                @Override
                public void onNext(List<Book> books) {
                    super.onNext(books);
                    if (books.size() == 0) {
                        mRecyclerView.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                    } else {
                        for (Book book : books) {
                            mAdapter.addData(book);
                        }
                    }

                }
            });
        else {
            if (booksParam.size() == 0) {
                mRecyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
            } else {
                for (Book book : booksParam)
                    mAdapter.addData(book);
            }
        }
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
