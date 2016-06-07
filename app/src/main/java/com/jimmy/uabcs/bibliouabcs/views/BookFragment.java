package com.jimmy.uabcs.bibliouabcs.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.utils.Constants;

public class BookFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private Book jsonBook;

    public BookFragment() {

    }

    public static BookFragment newInstance(String param1) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            jsonBook = Constants.GSON.fromJson(getArguments().getString(ARG_PARAM1), Book.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }
}
