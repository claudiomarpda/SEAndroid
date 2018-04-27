package sea.com.seandroid.page_contacts;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.OnUserLoaded;
import sea.com.seandroid.data.source.UserDataSource;

public class PageContactsPresenter implements PageContactsContract.Presenter,
        OnUserLoaded.OnFindAllContactsByUserId {

    private PageContactsContract.View mContactView;
    private UserDataSource mDataSource;
    private List<Contact> contacts;
    private List<User> users;

    public PageContactsPresenter(PageContactsContract.View mContactView, UserDataSource mDataSource) {
        this.mContactView = mContactView;
        this.mDataSource = mDataSource;
        this.mContactView.setPresenter(this);
        contacts = UserSession.user.getContacts();
        users = new ArrayList<>();
    }

    @Override
    public void start() {
    }


    @Override
    public void findAllContactsByUserId(boolean hasNetwork, String id) {
        mDataSource.findAllContactsByUserId(hasNetwork, id, this);
    }

    @Override
    public void onItemSelected(View view, int position) {
        mContactView.showItemDetail(view, position);
    }


    @Override
    public void onFindAllContactsByUserId(List<User> users) {
        mContactView.showList(users);
    }
}
