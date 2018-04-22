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

    SearchPresenter(@NonNull SearchContract.View mSearchView, UserDataSource userDataSource) {
        this.mSearchView = mSearchView;
        mSearchView.setPresenter(this);
        this.userDataSource = userDataSource;
    }

    @Override
    public void start() {

    }

    @Override
    public void onReadAll(List<User> users) {
        mSearchView.replaceWithResultFragment(users);
    }

    @Override
    public void searchUsers(boolean hasNetworking) {
        userDataSource.readAll(hasNetworking, this);
    }

}
