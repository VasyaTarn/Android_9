package com.example.android_9;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class NameListFragment extends Fragment {

    private OnNameClickListener callback;

    public interface OnNameClickListener {
        void onNameClick(String name);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNameClickListener)
        {
            callback = (OnNameClickListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnNameClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_list, container, false);
        GridView gridView = view.findViewById(R.id.gridView);

        String[] names = {"Name1", "Name2", "Name3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, names);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedName = (String) parent.getItemAtPosition(position);
                callback.onNameClick(selectedName);
            }
        });

        return view;
    }
}