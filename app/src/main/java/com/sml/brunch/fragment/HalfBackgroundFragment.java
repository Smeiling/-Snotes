package com.sml.brunch.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sml.brunch.R;
import com.sml.brunch.model.Article;
import com.sml.brunch.util.AndroidUtils;

import java.util.List;

/**
 * Created by songmeiling on 2017/8/7.
 */

public class HalfBackgroundFragment extends Fragment {

    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvAuthor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.editors_pick_view, null);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        requestData();
    }

    private void requestData() {
        String data = AndroidUtils.getFromAssets(getActivity(), "datas.json");
        Gson gson = new Gson();
        List<Article> articles = gson.fromJson(data, new TypeToken<List<Article>>() {
        }.getType());
        if (articles != null && articles.size() > 0) {
            refreshViewWithData(articles.get(0));
        }
    }

    private void refreshViewWithData(Article article) {
        tvTitle.setText(article.getTitle());
        tvContent.setText(article.getContent());
        tvAuthor.setText(article.getAuthor());
    }

    private void initView() {
        tvTitle = getView().findViewById(R.id.tv_title);
        tvContent = getView().findViewById(R.id.tv_content);
        tvAuthor = getView().findViewById(R.id.tv_author);
    }

}
