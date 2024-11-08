package com.example.android_9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NameDetailFragment extends Fragment {

    private static final String ARG_NAME = "name";

    public static NameDetailFragment newInstance(String name)
    {
        NameDetailFragment fragment = new NameDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_detail, container, false);

        TextView nameText = view.findViewById(R.id.nameText);
        TextView dateText = view.findViewById(R.id.dateText);
        TextView meaningText = view.findViewById(R.id.meaningText);

        if (getArguments() != null)
        {
            String name = getArguments().getString(ARG_NAME);
            MainActivity activity = (MainActivity) getActivity();
            NameModel nameModel = activity.findNameByName(name);

            if (nameModel != null)
            {
                nameText.setText("Name: " + nameModel.getName());
                dateText.setText("Date: " + nameModel.getDate());
                meaningText.setText("Meaning: " + nameModel.getMeaning());
            }
        }

        return view;
    }
}