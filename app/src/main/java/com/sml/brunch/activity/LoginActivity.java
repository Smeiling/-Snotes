package com.sml.brunch.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sml.brunch.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivBack;
    private ImageView ivConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ivBack = findViewById(R.id.iv_back);
        ivConfirm = findViewById(R.id.iv_check);
        ivBack.setOnClickListener(this);
        ivConfirm.setOnClickListener(this);
        findViewById(R.id.go_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_check:
                break;
        }
    }
}
