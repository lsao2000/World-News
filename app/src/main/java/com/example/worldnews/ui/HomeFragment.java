package com.example.worldnews.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.worldnews.R;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.worldnews.viewModelConnector.SwitchActionsFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recycle;
    private TabLayout parentTabs;
    private TabItem allNews, healthNews, scienceNews, entertainmentNews, technologyNews, sportsNews;
   public HomeFragment() {
        // Required empty public constructor
    }
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recycle = view.findViewById(R.id.recycle);
        parentTabs = view.findViewById(R.id.tablayout);
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle.setHasFixedSize(true);
        SwitchActionsFragment.getNews(recycle, getContext(),"all");
        parentTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0:
                        SwitchActionsFragment.getNews(recycle, getContext(),"all");
                        break;
                    case 1:
                        SwitchActionsFragment.getNews(recycle, getContext(), "sports");
                        break;
                    case 2:
                        SwitchActionsFragment.getNews(recycle, getContext(), "health");
                        break;
                    case 3:
                        SwitchActionsFragment.getNews(recycle, getContext(), "science");
                        break;
                    case 4:
                        SwitchActionsFragment.getNews(recycle, getContext(), "entertainment");
                        break;
                    case 5:
                        SwitchActionsFragment.getNews(recycle, getContext(), "technology");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
