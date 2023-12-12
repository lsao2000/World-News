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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<GetArticles> list;
    private Context context;
    public NewsAdapter(List<GetArticles> list, Context context){
        this.list = list;
        this.context = context;
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

        Glide.with(context).load(list.get(position).getUrlImage()).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, author, source, details, date;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            source = itemView.findViewById(R.id.source);
            details = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.dateNews);
            img = itemView.findViewById(R.id.imgNews);
        }
    }
}
