package com.vodafone.com.myapplication.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 8/4/2016.
 */

public class NewsObject {
    private String imageUrl;
    private String title;
    private String desc;
    private String time;
    private String detailsUrl;

    public NewsObject(String imageUrl,String title,String desc,String time,String detailsUrl)
    {
        this.imageUrl=imageUrl;
        this.time=time;
        this.desc=desc;
        this.detailsUrl=detailsUrl;
        this.title=title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }

    private static List<NewsObject> newsItems=new ArrayList<NewsObject>();

    public static List<NewsObject> getNewsItems() {
        return newsItems;
    }



    static
    {
      newsItems.add(new NewsObject("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
              "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
              "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
              "2016-08-04T04:20:46Z","http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));
        newsItems.add(new NewsObject("https://img.vidible.tv/prod/2016-08/03/57a274e1134aa15a39f04209_1280x720_U_v1_764_400.jpg",
                "Crunch Report | First private company to go to the Moon","Moon Express is the first private company to get permission from the U.S. government to go to the moon, Facebook shows us its \"Area 404\" hardware lab, Tesla",
                "2016-08-04T03:00:38Z","http://social.techcrunch.com/2016/08/03/crunch-report-first-private-company-to-go-to-the-moon/"));
        newsItems.add(new NewsObject("https://tctechcrunch2011.files.wordpress.com/2016/07/gettyimages-589718629.jpg?w=764&amp;h=400&amp;crop=1",
                "AirHelp raises $12 million to deal with airline customer service for you",
                "Few things are more dreadful than dealing with airline customer service. Fortunately, there’s a startup that wants to make those calls for you. For..",
                "2016-08-04T02:46:45Z",
                "http://social.techcrunch.com/2016/08/03/airhelp-raises-12-million-to-deal-with-airline-customer-service-for-you/"));
        newsItems.add(new NewsObject("https://tctechcrunch2011.files.wordpress.com/2016/08/gettyimages-584268466.jpg?w=764&amp;h=400&amp;crop=1",
                "New York Governor signs daily fantasy sports bill, DraftKings and FanDuel can operate again",
                "Back in June on the last day of the New York Assembly's legislative session, the state passed a bill legalizing daily fantasy sports, paving the road for the",
                "2016-08-04T04:20:46Z","http://social.techcrunch.com/2016/08/03/new-york-governor-signs-daily-fantasy-sports-bill-draftkings-and-fanduel-can-operate-again/"));
        newsItems.add(new NewsObject("https://img.vidible.tv/prod/2016-08/03/57a274e1134aa15a39f04209_1280x720_U_v1_764_400.jpg",
                "Crunch Report | First private company to go to the Moon","Moon Express is the first private company to get permission from the U.S. government to go to the moon, Facebook shows us its \"Area 404\" hardware lab, Tesla",
                "2016-08-04T03:00:38Z","http://social.techcrunch.com/2016/08/03/crunch-report-first-private-company-to-go-to-the-moon/"));
        newsItems.add(new NewsObject("https://tctechcrunch2011.files.wordpress.com/2016/07/gettyimages-589718629.jpg?w=764&amp;h=400&amp;crop=1",
                "AirHelp raises $12 million to deal with airline customer service for you",
                "Few things are more dreadful than dealing with airline customer service. Fortunately, there’s a startup that wants to make those calls for you. For..",
                "2016-08-04T02:46:45Z",
                "http://social.techcrunch.com/2016/08/03/airhelp-raises-12-million-to-deal-with-airline-customer-service-for-you/"));
    };
}
