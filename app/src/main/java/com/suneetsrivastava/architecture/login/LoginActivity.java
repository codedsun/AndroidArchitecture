package com.suneetsrivastava.architecture.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.suneetsrivastava.architecture.MainActivity;
import com.suneetsrivastava.architecture.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText username;
    private EditText password;
    private Button submit;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progessBar);
        loginPresenter = new LoginPresenter(this, new LoginModel());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgess() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setError() {
        username.setError("Username/Password is Wrong");
        password.setError("Username/Password is Wrong");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
