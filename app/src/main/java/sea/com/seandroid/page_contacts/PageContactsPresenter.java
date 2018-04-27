package sea.com.seandroid.page_contacts;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.OnUserLoaded;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.local.UserLocalDataSource;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;

public class PageContactsPresenter implements PageContactsContract.Presenter,
        OnUserLoaded.OnFindById {

    private PageContactsContract.View mContactView;
    private UserDataSource mDataSource;

    public PageContactsPresenter(PageContactsContract.View mContactView, UserDataSource mDataSource) {
        this.mContactView = mContactView;
        this.mDataSource = mDataSource;
        this.mContactView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void findUserById(boolean hasNetwork, String id) {
        Log.d("TAG", "find user" + getClass().getSimpleName());
        if(UserSession.user != null) {
            Log.d("TAG", "not null" + getClass().getSimpleName());
            mDataSource.findById(hasNetwork, UserSession.user.getId(), this);
        }
    }

    @Override
    public void onItemSelected(View view, int position) {
        mContactView.showItemDetail(view, position);
    }

    @Override
    public void onFindById(boolean hasNetwork, User u) {
/*
        if(u != null) {
            try {
                mDataSource.update(hasNetwork, u);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            assert u.getContacts() != null;
            for(Contact c : u.getContacts()) {
                mDataSource.update(false, c);
            }
        }
*/
        mContactView.showList(u.getContacts());
    }

}
