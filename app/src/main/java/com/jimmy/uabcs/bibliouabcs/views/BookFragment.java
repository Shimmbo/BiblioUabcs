package com.jimmy.uabcs.bibliouabcs.views;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.jimmy.uabcs.bibliouabcs.R;
import com.jimmy.uabcs.bibliouabcs.models.Book;
import com.jimmy.uabcs.bibliouabcs.utils.Constants;
import com.jimmy.uabcs.bibliouabcs.utils.VolleySingleton;

import org.w3c.dom.Text;

import static com.jimmy.uabcs.bibliouabcs.utils.Constants.*;

public class BookFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";

    private Book mBook;

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
            mBook = GSON.fromJson(getArguments().getString(ARG_PARAM1), Book.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book, container, false);
        TextView title = (TextView) rootView.findViewById(R.id.title);
        title.setText(mBook.getName());
        String imaegPath = mBook.getImagePath();
        NetworkImageView img = (NetworkImageView) rootView.findViewById(R.id.thumbnail);
        ImageLoader mImageLoader = VolleySingleton.getInstance().getImageLoader();
        if(imaegPath == null || imaegPath == "")
            img.setImageUrl(URL + DEFAULT_IMAGE, mImageLoader);
        else
            img.setImageUrl(URL + imaegPath,mImageLoader);

        TextView authors = (TextView) rootView.findViewById(R.id.authors);
        if(mBook.getAuthor().size() > 0)
            authors.setText(mBook.authorJoin());

        TextView isbn = (TextView) rootView.findViewById(R.id.isbn);
        isbn.setText(getString(R.string.isbn,mBook.getISBN()));

        TextView genres = (TextView) rootView.findViewById(R.id.genre);
        if(mBook.getGenre().size() > 0)
            genres.setText(mBook.genreJoin());

        TextView publisher = (TextView) rootView.findViewById(R.id.publisher);
        if (mBook.getPublisher() != null)
            publisher.setText(mBook.getPublisher().getName());
        return  rootView;
    }
}
