package com.demo.mvp.mvpdesigndemo.mvp.persenter;

import android.os.SystemClock;

import com.demo.mvp.mvpdesigndemo.mvp.modle.INews;
import com.demo.mvp.mvpdesigndemo.mvp.modle.NewsBean;
import com.demo.mvp.mvpdesigndemo.mvp.modle.NewsImpl;
import com.demo.mvp.mvpdesigndemo.mvp.view.INewsView;

import java.util.List;

/**
 * date：2018/4/18 on 16:42
 * description: Persenter层，需要实现Modle层和View层的接口
 */

public class NewsPersenter implements INewsView, INews {

    private NewsImpl mNews;
    private INewsView mINewsView;

    public NewsPersenter(INewsView iNewsView) {
        mNews = new NewsImpl();
        mINewsView = iNewsView;
    }


    /**
     * 供View层调用
     */
    public void requestNesInfo() {
        //为了模拟耗时，所有的操作都在子线程进行
        new Thread() {
            @Override
            public void run() {
                super.run();
                showProgress();
                SystemClock.sleep(3000);
                hideProgress();
                addNews();
                setAdapter();
                SystemClock.sleep(8000);
                showLoadFailMsg();
            }
        }.start();
    }


    @Override
    public void showProgress() {
        if (mINewsView != null) {
            mINewsView.showProgress();
        }
    }

    @Override
    public List<NewsBean> addNews() {
        if (mNews != null) {
            return mNews.addNews();
        } else {
            return null;
        }
    }

    @Override
    public void hideProgress() {
        if (mINewsView != null) {
            mINewsView.hideProgress();
        }
    }

    @Override
    public void showLoadFailMsg() {
        if (mINewsView != null) {
            mINewsView.showLoadFailMsg();
        }
    }

    @Override
    public void setAdapter() {
        if (mINewsView != null) {
            mINewsView.setAdapter();
        }
    }
}
