package com.example.worldnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.worldnews.R;
import com.example.worldnews.viewModelConnector.AnimateFunctionaliy;
import com.example.worldnews.viewModelConnector.SwitchActionsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Fragment homefragment, favoriteFragment, searchFragment, roomFragment;
    private TextView homeText, favoriteText, searchText, roomsText;
    private View home, favorite, search, rooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home = findViewById(R.id.home);
        favorite = findViewById(R.id.Favourite);
        search = findViewById(R.id.search);
        rooms = findViewById(R.id.Room);
        homeText = findViewById(R.id.homeText);
        favoriteText = findViewById(R.id.favorText);
        searchText = findViewById(R.id.searchText);
        roomsText = findViewById(R.id.roomText);
        // set default fragment.
        homefragment = new HomeFragment();
        SwitchActionsFragment.swithFragment(R.id.frame, homefragment, getSupportFragmentManager());
        AnimateFunctionaliy.animateButton(home, homeText, R.drawable.home_activated, "#FFFFFFFF");
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SwitchActionsFragment.swithFragment(R.id.frame, homefragment, getSupportFragmentManager());
                AnimateFunctionaliy.animateButton(home, homeText, R.drawable.home_activated, "#FFFFFFFF");
                AnimateFunctionaliy.animateButton(rooms, roomsText, R.drawable.rooms, "#C7777676");
                AnimateFunctionaliy.animateButton(favorite, favoriteText, R.drawable.favorite, "#C7777676");
                AnimateFunctionaliy.animateButton(search, searchText, R.drawable.search, "#C7777676");
 

            }
        });
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                searchFragment = new SearchFragment();
                SwitchActionsFragment.swithFragment(R.id.frame, searchFragment, getSupportFragmentManager());
                AnimateFunctionaliy.animateButton(home, homeText, R.drawable.home, "#C7777676");
                AnimateFunctionaliy.animateButton(rooms, roomsText, R.drawable.rooms, "#C7777676");
                AnimateFunctionaliy.animateButton(favorite, favoriteText, R.drawable.favorite, "#C7777676");
                AnimateFunctionaliy.animateButton(search, searchText, R.drawable.search_activated,  "#FFFFFFFF");
 


            }
        });
        rooms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                roomFragment = new RoomsFragment();
                SwitchActionsFragment.swithFragment(R.id.frame, roomFragment, getSupportFragmentManager());
                AnimateFunctionaliy.animateButton(home, homeText, R.drawable.home,"#C7777676");
                AnimateFunctionaliy.animateButton(rooms, roomsText, R.drawable.rooms_activated, "#FFFFFFFF");
                AnimateFunctionaliy.animateButton(favorite, favoriteText, R.drawable.favorite, "#C7777676");
                AnimateFunctionaliy.animateButton(search, searchText, R.drawable.search, "#C7777676");
            }
        });
        favorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                favoriteFragment = new FavoriteFragment();
                SwitchActionsFragment.swithFragment(R.id.frame, favoriteFragment, getSupportFragmentManager());
                AnimateFunctionaliy.animateButton(home, homeText, R.drawable.home,  "#C7777676");
                AnimateFunctionaliy.animateButton(rooms, roomsText, R.drawable.rooms, "#C7777676");
                AnimateFunctionaliy.animateButton(favorite, favoriteText, R.drawable.favorite_activated, "#FFFFFFFF");
                AnimateFunctionaliy.animateButton(search, searchText, R.drawable.search, "#C7777676");
 

            }
        });
    }
}
