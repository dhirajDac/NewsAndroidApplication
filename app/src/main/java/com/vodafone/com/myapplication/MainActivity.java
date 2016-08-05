package com.vodafone.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vodafone.com.myapplication.network.NewsApiServiceHandler;
import com.vodafone.com.myapplication.objects.Article;
import com.vodafone.com.myapplication.objects.CommonUsage;
import com.vodafone.com.myapplication.objects.NewsApiArticleReference;
import com.vodafone.com.myapplication.objects.NewsApiSourceReference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;

    List<Article> allArticles=new ArrayList<Article>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //// TODO: 8/3/2016  Make change
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_newsItem);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<NewsApiArticleReference> newsApiArticleReferenceCall= NewsApiServiceHandler.getNewsAPI().getArticle("bbcnews","top");
        newsApiArticleReferenceCall.enqueue(new Callback<NewsApiArticleReference>() {
            @Override
            public void onResponse(Call<NewsApiArticleReference> call, Response<NewsApiArticleReference> response)
            {
                NewsApiArticleReference body=response.body();
                 allArticles=body.getArticles();
                CommonUsage.setArticles(allArticles);

                NewsAdapter newsAdapter=new NewsAdapter(allArticles);
                recyclerView.setAdapter(newsAdapter);
                //NewsAdapter newsAdapter=new NewsAdapter(NewsObject.getNewsItems());

                //Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onFailure(Call<NewsApiArticleReference> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

        Call<NewsApiSourceReference> newsApiSource=NewsApiServiceHandler.getNewsAPI().getSource();
        newsApiSource.enqueue(new Callback<NewsApiSourceReference>() {
            @Override
            public void onResponse(Call<NewsApiSourceReference> call, Response<NewsApiSourceReference> response)
            {
                NewsApiSourceReference body=response.body();

                Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<NewsApiSourceReference> call, Throwable t) {

            }
        });



    }

}
