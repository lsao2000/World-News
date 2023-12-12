package com.example.worldnews.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.worldnews.R;
import com.example.worldnews.data.retrofitApi.ApiInterface;
import com.example.worldnews.data.retrofitApi.GetRetro;
import com.example.worldnews.data.retrofitApi.NewsObject;
import com.example.worldnews.viewModelConnector.NewsAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recycle;
   public HomeFragment() {
        // Required empty public constructor
    }
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recycle = view.findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        recycle.setHasFixedSize(true);
       ApiInterface retro = GetRetro.getRetrofit().create(ApiInterface.class);
        Call<NewsObject> data = retro.getArticles();
        data.enqueue(new Callback<NewsObject>() {
            @Override
            public void onResponse(Call<NewsObject> call, Response<NewsObject> response) {
                recycle.setAdapter(new NewsAdapter(response.body().getArticles(), getContext()));
//                Toast.makeText(getContext(),"The results is : "+ response.body().getArticles(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<NewsObject> call, Throwable t) {
//                https://newsapi.org/v2/
                Log.i("newsFail", t.getMessage());
//                Toast.makeText(getContext(),"The results is : "+ t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
