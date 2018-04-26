package sea.com.seandroid.login;

import android.util.Log;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserLoaded;

public class LoginPresenter implements LoginContract.Presenter, OnUserLoaded.OnFindByEmail {

    private LoginContract.View mLoginView;
    private UserDataSource userDataSource;

    public LoginPresenter(LoginContract.View mLoginView, UserDataSource userDataSource) {
        this.mLoginView = mLoginView;
        this.mLoginView.setPresenter(this);
        this.userDataSource = userDataSource;
    }

    @Override
    public void start() {

    }

    @Override
    public void attemptLogin(boolean hasNetwork, String email) {
        userDataSource.findByEmail(hasNetwork, email, this);
    }

    @Override
    public void onFindByEmail(User u) {
        if (u != null) {
            UserSession.user = u;
            mLoginView.showLoginAccepted();
        } else {
            mLoginView.showLoginRejected();
        }
    }
}
