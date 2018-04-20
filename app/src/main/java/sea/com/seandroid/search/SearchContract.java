package sea.com.seandroid.search;

import android.content.Context;

import java.util.List;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;
import sea.com.seandroid.data.model.User;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void replaceWithResultFragment(List<User> list);

    }

    interface Presenter extends BasePresenter {

        void searchUsersRemote();

        void searchUsersLocal();

        void replaceFromLocal(List<User> list);
    }
}
