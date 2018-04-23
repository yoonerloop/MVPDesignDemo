package com.demo.mvp.mvpdesigndemo.mvp.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.mvp.mvpdesigndemo.R;
import com.demo.mvp.mvpdesigndemo.mvp.modle.NewsBean;

import java.util.List;

/**
 * date：2018/4/18 on 17:09
 * description:
 */

class NewsAdapter extends BaseAdapter {

    private List<NewsBean> mNewsList;
    private Context mContext;

    public NewsAdapter(Context ctx,List<NewsBean> newsList) {
        this.mContext = ctx;
        this.mNewsList = newsList;
    }

    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.list_item_news, null);
            holder = new ViewHolder();
            holder.time = convertView.findViewById(R.id.tv_time);
            holder.title = convertView.findViewById(R.id.tv_title);
            holder.news = convertView.findViewById(R.id.tv_news);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        NewsBean news = mNewsList.get(position);
        holder.title.setText(news.title);
        holder.time.setText(news.time);
        holder.news.setText(news.news);

        return convertView;
    }

    static class ViewHolder{
        public TextView time;
        public TextView title;
        public TextView news;
    }
}
