
package com.example.worldnews.viewModelConnector;
/**
 * SwitchActionsFragment
 */
import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import androidx.recyclerview.widget.RecyclerView;
import com.example.worldnews.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.worldnews.data.retrofitApi.ApiInterface;
import com.example.worldnews.data.retrofitApi.GetRetro;
import com.example.worldnews.data.retrofitApi.NewsObject;
import com.example.worldnews.data.retrofitApi.KeyApi;
public class SwitchActionsFragment {
    
    public static void swithFragment(int id, Fragment fragment, FragmentManager support){
        FragmentTransaction fragmentTransaction = support.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
    // this function for getting data from the api and set adapter to the recycleview.
    public static void getNews(RecyclerView recycle, Context context, String newsType){
        ApiInterface retro = null ;
        retro = GetRetro.getRetrofit().create(ApiInterface.class);
        Call<NewsObject> data = retro.getArticles();
        switch (newsType){
            case "all":
                data = retro.getArticles();
                break;
            case "sports":
                data = retro.getSportArticle();
                break;
            case "technology":
                data = retro.getTechnologyArticle();
                break;
            case "science":
                data = retro.getScinceArticle();
                break;
            case "entertainment":
                data = retro.getEntertainmentArticle();
                break;
            case "health":
                data = retro.getHealthArticle();
                break;
            default:
                data = retro.getArticles();
                break;
        }

        data.enqueue(new Callback<NewsObject>(){
            @Override
            public void onResponse(Call<NewsObject> call, Response<NewsObject> response){
                recycle.setAdapter(new NewsAdapter(response.body().getArticles(), context, newsType));
            }
            @Override
            public void onFailure(Call<NewsObject> call, Throwable t){
                Log.i("newsFail", t.getMessage());
            }
        });
        
    }
}
