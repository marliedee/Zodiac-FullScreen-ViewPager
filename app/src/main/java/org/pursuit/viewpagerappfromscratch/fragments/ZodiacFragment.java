package org.pursuit.viewpagerappfromscratch.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.viewpagerappfromscratch.R;

public class ZodiacFragment extends Fragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_NUM = "number";
    private static final String ARG_IMAGE = "image";

    private String mName;
    private String mNumber;
    private String mImage;
    private TextView textViewName;
    private TextView textViewNum;
    private ImageView imageView;


    public ZodiacFragment() {
    }
    public static ZodiacFragment newInstance(String name, String number, String image) {
        ZodiacFragment fragment = new ZodiacFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_NUM, number);
        args.putString(ARG_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
            mNumber = getArguments().getString(ARG_NUM);
            mImage= getArguments().getString(ARG_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zodiac, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewName = view.findViewById(R.id.textView_name);
        textViewNum = view.findViewById(R.id.textView_number);
        imageView = view.findViewById(R.id.zodiac_imageview);
        textViewName.setText(mName);
        textViewNum.setText(mNumber);
        Picasso.get().load(mImage).into(imageView);
    }
}
