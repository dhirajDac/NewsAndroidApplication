package com.vodafone.com.myapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vodafone.com.myapplication.objects.Article;
import com.vodafone.com.myapplication.objects.Source;

import java.util.List;

/**
 * Created by admin on 8/5/2016.
 */

public class NewsSourceAdapter extends RecyclerView.Adapter<NewsSourceAdapter.NewsSourceViewHolder> {

List<Source> newsSources;

    public NewsSourceAdapter(List<Source> newsSources) {
        this.newsSources = newsSources;
    }

    @Override
    public NewsSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_source,parent,false);
        NewsSourceAdapter.NewsSourceViewHolder newsViewHolder=new NewsSourceAdapter.NewsSourceViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsSourceViewHolder holder,final int position) {
        if (newsSources==null)
            return;
        Source currentNewsObject=newsSources.get(position);
        holder.title.setText(currentNewsObject.getName());

        holder.newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.start(view.getContext(),position);
            }
        });
        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"Click Position"+position,Toast.LENGTH_SHORT).show();
                NewsDetailActivity.start(view.getContext(),position);

            }
        });*/
        Glide.with(holder.newsImage.getContext()).load((currentNewsObject.getUrlsToLogos().getMedium())).into(holder.newsImage);

    }

    @Override
    public int getItemCount() {
        return (null == newsSources) ? 0 : newsSources.size();
    }

    public static class NewsSourceViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImage;
        public TextView title;


        public NewsSourceViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.item_news_source_image);
            title = (TextView) itemView.findViewById(R.id.item_news_source_title);

        }
    }
}
