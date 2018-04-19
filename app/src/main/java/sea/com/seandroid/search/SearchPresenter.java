package sea.com.seandroid.search;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public class SearchPresenter implements SearchContract.Presenter, OnUserDataLoaded {

    private final SearchContract.View mSearchView;
    private UserDataSource userDataSource;

    public SearchPresenter(@NonNull SearchContract.View mSearchView, UserDataSource userDataSource) {
        this.mSearchView = mSearchView;
        mSearchView.setPresenter(this);
        this.userDataSource = userDataSource;
    }

    @Override
    public void searchUsers() {
        userDataSource.readAll(this);
    }

    @Override
    public void start() {
        mSearchView.showSearchWidgets();
    }

    @Override
    public void onReadAll(List<User> users) {
        String result = "";
        for (User u : users) {
            result += u.getFirstName();
            Log.d("TAG", "User " + u.getFirstName());
        }
        mSearchView.showNetworkingResult(result);
    }
}
