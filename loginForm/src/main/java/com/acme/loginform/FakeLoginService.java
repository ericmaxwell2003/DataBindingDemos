package com.acme.loginform;

import java.util.UUID;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FakeLoginService {

    public class User {

        public final String username;
        public final String token;

        public User(String username, String token) {
            this.username = username;
            this.token = token;
        }
    }

    public interface LoginCallback {
        void onSuccess(User user);
        void onFailure(Throwable e);
    }

    public void attemptLogin(final String username, final String password, final LoginCallback callback) {

        Flowable.fromCallable(new Callable<User>() {
            @Override
            public User call() throws Exception {
                Thread.sleep(1000);
                if (password.equals("good")) {
                    return new User(username, UUID.randomUUID().toString());
                } else {
                    throw new Exception("Bad password");
                }
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(Schedulers.single())
          .subscribe(new Consumer<User>() {
              @Override
              public void accept(User user) throws Exception {
                  callback.onSuccess(user);
              }
          }, new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Exception {
                  callback.onFailure(throwable);
              }
          });

    }

}
