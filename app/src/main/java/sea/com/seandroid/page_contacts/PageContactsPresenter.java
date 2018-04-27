package sea.com.seandroid.page_contacts;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.OnUserLoaded;
import sea.com.seandroid.data.source.UserDataSource;

public class PageContactsPresenter implements PageContactsContract.Presenter,
        OnUserLoaded.OnFindAllContactsByUserId, OnUserLoaded.OnFindById {

    private PageContactsContract.View mContactView;
    private UserDataSource mDataSource;
    private List<User> contacts;
    private int counter;

    public PageContactsPresenter(PageContactsContract.View mContactView, UserDataSource mDataSource) {
        this.mContactView = mContactView;
        this.mDataSource = mDataSource;
        this.mContactView.setPresenter(this);
        contacts = new ArrayList<>();
    }

    @Override
    public void start() {
    }


    @Override
    public void findAllContactsByUserId(boolean hasNetwork, String id) {
        if (hasNetwork) {
            mDataSource.findAllContactsByUserId(true, id, this);
        } else {
            mDataSource.findAllContactsByUserId(false, id, this);
        }
    }

    @Override
    public void onItemSelected(View view, int position) {
        mContactView.showItemDetail(view, position);
    }


    @Override
    public void onFindAllContactsByUserId(boolean fromNetwork, List<User> users) {
        contacts = users;
        counter = 0;

        if (fromNetwork) {
            for (User u : users) {
                mDataSource.findById(false, u.getId(), this);
                counter++;
            }
        }

        mContactView.showList(users);
    }

    @Override
    public void onFindById(User u) {
        if (u == null) {
            mDataSource.insert(false, contacts.get(counter));
        } else {
            mDataSource.update(false, contacts.get(counter));
        }
    }
}
