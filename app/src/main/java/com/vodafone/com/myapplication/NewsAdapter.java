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

import java.util.List;


/**
 * Created by admin on 8/4/2016.
 * 1. Create Activity
 * 2. Override OnCreate
 * 3. Design Layout with WebView
 * 4. Mention in manifest
 * 5. use setContentView in Details Activity
 * 6. add id for cardview
 * 7. update adapter : view holder
 * 8. add onclicklisterner in onBindViewHolder
 * 9. show toast with position
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    //List<NewsObject> newsItems;
    List<Article> newsArtictes;

   /* public NewsAdapter(List<NewsObject> newsItems) {
        this.newsItems = newsItems;
    }*/

    public NewsAdapter(List<Article> allArticle)
    {
        this.newsArtictes=allArticle;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        NewsViewHolder newsViewHolder=new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, final int position) {
           /*if (newsItems==null)
               return;*/
        if (newsArtictes==null)
            return;
        Article currentNewsObject=newsArtictes.get(position);
        holder.title.setText(currentNewsObject.getTitle());
        holder.date.setText(currentNewsObject.getPublishedAt());
        holder.desc.setText(currentNewsObject.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(view.getContext(),"Click Position"+position,Toast.LENGTH_SHORT).show();
                     NewsDetailActivity.start(view.getContext(),position);

            }
        });
        Glide.with(holder.newsImage.getContext()).load((currentNewsObject.getUrlToImage())).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return (null == newsArtictes) ? 0 : newsArtictes.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImage;
        public TextView title;
        public TextView desc;
        public TextView date;
        public CardView cardView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.item_news_image);
            title = (TextView) itemView.findViewById(R.id.item_news_title);
            desc = (TextView) itemView.findViewById(R.id.item_news_description);
            date = (TextView) itemView.findViewById(R.id.item_news_time);
            cardView=(CardView) itemView.findViewById(R.id.item_news_cardView);
        }
    }
}
