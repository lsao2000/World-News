package com.example.worldnews.viewModelConnector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.worldnews.R;
import com.example.worldnews.data.retrofitApi.GetArticles;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import java.util.zip.Inflater;
import com.example.worldnews.data.roomDb.LocalDb;
import com.example.worldnews.data.roomDb.FavouritModel;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<GetArticles> list;
    private Context context;
    private String typeNews;
    public NewsAdapter(List<GetArticles> list, Context context, String typeNews){
        this.list = list;
        this.context = context;
        this.typeNews = typeNews;
    }
    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.source.setText("Source : "+list.get(position).getSource().getName());
        holder.title.setText(list.get(position).getTitle());
        holder.date.setText(list.get(position).getDateNews().split("T")[0]);
        holder.details.setText(list.get(position).getDescription());
        holder.author.setText("Author : "+list.get(position).getAuthor());
        if (list.get(position).getUrlImage().equals(null)){
            holder.img.setVisibility(View.INVISIBLE);
        }
        Glide.with(context).load(list.get(position).getUrlImage()).into(holder.img);
        holder.share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LocalDb db = LocalDb.getInstance(context);
                try {
                    //FavouritModel favor = new FavouritModel(list.get(position).getSource().getName());

                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, author, source, details, date;
        private ImageView img;
        private View favourite, share;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            source = itemView.findViewById(R.id.source);
            details = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.dateNews);
            img = itemView.findViewById(R.id.imgNews);
            favourite = itemView.findViewById(R.id.favorBtn);
            share = itemView.findViewById(R.id.shareBtn);
        }
    }
}
