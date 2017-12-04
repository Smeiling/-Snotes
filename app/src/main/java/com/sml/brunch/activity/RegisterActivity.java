package com.sml.brunch.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.sml.brunch.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivRegister;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etRepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initTitle();
        initView();
    }

    private void initTitle() {
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("注册账号");
    }

    private void initView() {
        findViewById(R.id.ensure_password).setVisibility(View.VISIBLE);
        ivRegister = findViewById(R.id.iv_check);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        ivRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && password.length() > 4) {
                    doRegister(username, password);
                }

            }
        });
    }

    private void doRegister(String username, String password) {
        AVUser user = new AVUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    RegisterActivity.this.finish();
                } else {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
