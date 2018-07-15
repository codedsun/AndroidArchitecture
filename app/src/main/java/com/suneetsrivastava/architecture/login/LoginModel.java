package com.suneetsrivastava.architecture.login;

import android.os.Handler;

/**
 * @author : codedsun
 * Created on 15/07/18
 */
public class LoginModel {
    interface onLoginFinishedListener{
        void onError();
        void onSuccess();

    }

    public void login(final String username, final String pass, final onLoginFinishedListener listener){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(username.isEmpty() || pass.isEmpty()){
                    listener.onError();
                }
                else
                {
                    listener.onSuccess();
                }
            }
        },2000);
    }
}
