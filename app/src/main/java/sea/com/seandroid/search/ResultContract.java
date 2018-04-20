package sea.com.seandroid.search;

import java.util.List;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;
import sea.com.seandroid.data.model.User;

public interface ResultContract {

    interface View extends BaseView<Presenter> {

        void loadList(List<User> list);

        void showItemDetail(android.view.View view, int position);

    }

    interface Presenter extends BasePresenter {

        void start();

        void onItemSelected(android.view.View view, int position);

//        List<User> loadFromLocalSource();
    }
}
