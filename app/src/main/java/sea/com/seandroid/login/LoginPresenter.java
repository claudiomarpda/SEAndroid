package sea.com.seandroid.login;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.OnUserLoaded;

public class LoginPresenter implements LoginContract.Presenter, OnUserLoaded.OnFindByEmail,
        OnUserLoaded.OnFindById {

    private LoginContract.View mLoginView;
    private UserDataSource userDataSource;
    private User user;

    public LoginPresenter(LoginContract.View mLoginView, UserDataSource userDataSource) {
        this.mLoginView = mLoginView;
        this.mLoginView.setPresenter(this);
        this.userDataSource = userDataSource;
    }

    @Override
    public void start() {
        if (UserSession.user != null) {
            mLoginView.showLoginAccepted();
        }
    }

    @Override
    public void attemptLogin(boolean hasNetwork, String email) {
        userDataSource.findByEmail(hasNetwork, email, this);
    }

    @Override
    public void onFindByEmail(User u) {
        if (u != null) {
            user = u;
            // find local
            userDataSource.findById(false, u.getId(), this);

            UserSession.user = u;
            mLoginView.showLoginAccepted();
        } else {
            mLoginView.showLoginRejected();
        }
    }

    @Override
    public void onFindById(User u) {
        // result from local
        // save in database if it is the first login
        if(u == null) {
            userDataSource.insert(false, user);
        }
    }
}
