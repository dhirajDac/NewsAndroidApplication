package com.vodafone.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vodafone.com.myapplication.network.NewsApiServiceHandler;
import com.vodafone.com.myapplication.objects.NewsApiArticleReference;
import com.vodafone.com.myapplication.objects.NewsObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final Call<NewsApiArticleReference> newsApiArticleReferenceCall= NewsApiServiceHandler.getNewsAPI().getArticle("bbcnews","top");
        newsApiArticleReferenceCall.enqueue(new Callback<NewsApiArticleReference>() {
            @Override
            public void onResponse(Call<NewsApiArticleReference> call, Response<NewsApiArticleReference> response)
            {
                NewsApiArticleReference body=response.body();
                Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<NewsApiArticleReference> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter=new NewsAdapter(NewsObject.getNewsItems());
        recyclerView.setAdapter(newsAdapter);

    }

}
