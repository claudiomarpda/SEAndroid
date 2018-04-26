package sea.com.seandroid.login;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showLoginAccepted();

        void showLoginRejected();

    }

    interface Presenter extends BasePresenter {

        void attemptLogin(boolean hasNetwork, String email);

    }
}
