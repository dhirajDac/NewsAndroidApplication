package com.vodafone.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.vodafone.com.myapplication.objects.NewsObject;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //// TODO: 8/3/2016  Make change
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newsItem);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter=new NewsAdapter(NewsObject.getNewsItems());
        recyclerView.setAdapter(newsAdapter);

    }

}
