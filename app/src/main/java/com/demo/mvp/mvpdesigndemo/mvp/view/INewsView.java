package com.demo.mvp.mvpdesigndemo.mvp.view;

/**
 * date：2018/4/18 on 16:34
 * description: View层接口
 */

public interface INewsView {
    //展示加载进度
    void showProgress();
    //隐藏加载进度
    void hideProgress();
    //展示加载失败消息
    void showLoadFailMsg();
    //设置Adapter，展示数据
    void setAdapter();
}
