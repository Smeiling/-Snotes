package com.sml.brunch.model;

import java.util.List;

/**
 * Created by Smeiling on 2017/12/1.
 */

public class BrunchViewModel {

    private int viewType;
    private List<Article> articleList;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
