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
import com.jimmy.uabcs.bibliouabcs.adapter.PublisherAdapter;
import com.jimmy.uabcs.bibliouabcs.models.Author;
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
    public PublisherFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_publisher, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.publisherList);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
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
                for(Publisher publisher:publishers)
                    mAdapter.addData(publisher);
            }
        });
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
