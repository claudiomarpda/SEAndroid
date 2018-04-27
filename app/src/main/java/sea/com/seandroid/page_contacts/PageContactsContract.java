package sea.com.seandroid.page_contacts;

import java.util.List;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;
import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;

public interface PageContactsContract {

    interface View extends BaseView<Presenter> {

        void showList(List<Contact> contacts);

        void showItemDetail(android.view.View view, int position);

    }

    interface Presenter extends BasePresenter {

        void findUserById(boolean hasNetwork, String id);

        void onItemSelected(android.view.View view, int position);
    }
}
