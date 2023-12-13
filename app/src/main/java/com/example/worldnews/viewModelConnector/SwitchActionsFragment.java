
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
public class SwitchActionsFragment {
    
    public static void swithFragment(int id, Fragment fragment, FragmentManager support){
        FragmentTransaction fragmentTransaction = support.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
    // this function for getting data from the api and set adapter to the recycleview.
    public static void getNews(RecyclerView recycle, Context context, String newsType){
        ApiInterface retro = null ;
        switch (newsType){
            case "all":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            case "sports":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            case "technology":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            case "science":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            case "entertainment":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            case "health":
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
            default:
                retro = GetRetro.getRetrofit().create(ApiInterface.class);
                break;
        }

        Call<NewsObject> data = retro.getArticles();
        data.enqueue(new Callback<NewsObject>(){
            @Override
            public void onResponse(Call<NewsObject> call, Response<NewsObject> response){
                recycle.setAdapter(new NewsAdapter(response.body().getArticles(), context));
            }
            @Override
            public void onFailure(Call<NewsObject> call, Throwable t){
                Log.i("newsFail", t.getMessage());
            }
        });
        
    }
}
