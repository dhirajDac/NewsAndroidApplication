package com.vodafone.com.myapplication.objects;

import java.util.List;

/**
 * Created by admin on 8/5/2016.
 */

public class CommonUsage {

    private static List<Article> AllNewsArticles;

    public static List<Article> getArticles() {
        return AllNewsArticles;
    }


    public static void setArticles(List<Article> articles) {
        AllNewsArticles = articles;
    }




}
