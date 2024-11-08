package com.example.android_9;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameListFragment.OnNameClickListener {
    private List<NameModel> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initializeNames();

        if (savedInstanceState == null)
        {
            NameListFragment nameListFragment = new NameListFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, nameListFragment).commit();
        }
    }

    private void initializeNames()
    {
        nameList = new ArrayList<>();
        nameList.add(new NameModel("Name1", "Date1", "Meaning1"));
        nameList.add(new NameModel("Name2", "Date2", "Meaning2"));
        nameList.add(new NameModel("Name3", "Date3", "Meaning3"));
    }

    public NameModel findNameByName(String name) {
        for (NameModel nameModel : nameList)
        {
            if (nameModel.getName().equals(name))
            {
                return nameModel;
            }
        }
        return null;
    }

    @Override
    public void onNameClick(String name)
    {
        NameDetailFragment detailFragment = NameDetailFragment.newInstance(name);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}