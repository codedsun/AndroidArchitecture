package com.suneetsrivastava.architecture.login;

/**
 * @author : codedsun
 * Created on 15/07/18
 */
public class LoginPresenter implements LoginModel.onLoginFinishedListener {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null)
            loginView.showProgress();
        loginModel.login(username, password, this);

    }

    @Override
    public void onError() {
        if (loginView != null) {
            loginView.setError();
            loginView.hideProgess();
        }

    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgess();
            loginView.navigateToHome();
        }

    }

    public void onDestroy() {
        loginView = null;
    }
}
