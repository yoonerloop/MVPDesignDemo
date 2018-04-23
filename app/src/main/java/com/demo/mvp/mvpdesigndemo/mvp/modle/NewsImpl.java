package com.demo.mvp.mvpdesigndemo.mvp.modle;

import java.util.ArrayList;
import java.util.List;

/**
 * date：2018/4/18 on 16:35
 * description: Modle层实现类
 */

public class NewsImpl implements INews{

    @Override
    public List<NewsBean> addNews() {
        List<NewsBean>  mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsBean news = new NewsBean();
            news.time = "18:0" + i;
            news.title = "第" + i + "个标题";
            news.news = "新闻中心_腾讯网_腾讯新闻";
            mList.add(news);
        }
        return mList;
    }
}
