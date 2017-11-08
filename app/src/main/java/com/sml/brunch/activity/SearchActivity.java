package com.sml.brunch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.sml.brunch.R;

public class SearchActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etSearch;
    private ListView lvSearchHistory;
    private FrameLayout flSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        lvSearchHistory = findViewById(R.id.lv_search_history);
        flSearchResult = findViewById(R.id.fl_search_result);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etSearch = findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etSearch.getText().length() > 0) {
                    flSearchResult.setVisibility(View.VISIBLE);
                    lvSearchHistory.setVisibility(View.GONE);
                } else {
                    flSearchResult.setVisibility(View.GONE);
                    lvSearchHistory.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
