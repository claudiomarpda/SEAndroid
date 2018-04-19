package sea.com.seandroid.search;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void showSearchWidgets();

        void hideSearchWidgets();

        void showNetworkingResult(String result);
    }

    interface Presenter extends BasePresenter {

        void searchUsers();
    }
}
