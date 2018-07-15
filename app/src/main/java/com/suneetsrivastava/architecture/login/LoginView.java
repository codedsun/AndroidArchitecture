package com.suneetsrivastava.architecture.login;

/**
 * @author : codedsun
 * Created on 15/07/18
 */
public interface LoginView {
    void showProgress();
    void hideProgess();
    void setError();
    void navigateToHome();
}
