package com.demo.mvp.mvpdesigndemo.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.demo.mvp.mvpdesigndemo.R;
import com.demo.mvp.mvpdesigndemo.mvp.persenter.NewsPersenter;

/**
 * View层实现类
 */
public class MainActivity extends AppCompatActivity implements INewsView{

    private ProgressBar mProgressBar;
    private TextView mEmptyText;
    private ListView mListView;
    private NewsPersenter mNewsPersenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.pb_progress);
        mEmptyText = findViewById(R.id.tv_empty);
        mListView = findViewById(R.id.lv_list);
        mNewsPersenter = new NewsPersenter(this);
        mNewsPersenter.requestNesInfo();
    }

    /**
     * 显示进度
     */
    @Override
    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * 隐藏进度
     */
    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * 显示错误消息
     */
    @Override
    public void showLoadFailMsg() {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               mEmptyText.setText("加载数据为空……………………");
               mEmptyText.setVisibility(View.VISIBLE);
               mListView.setVisibility(View.GONE);
           }
       });
    }

    @Override
    public void setAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mListView.setAdapter(new NewsAdapter(MainActivity.this,mNewsPersenter.addNews()));
            }
        });
    }
}
