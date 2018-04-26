package sea.com.seandroid.search;

import android.support.annotation.NonNull;

import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserLoaded;

public class SearchPresenter implements SearchContract.Presenter, OnUserLoaded.OnReadAll {

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
    public void onFindAll(List<User> users) {
        mSearchView.replaceWithResultFragment(users);
    }


    @Override
    public void searchUsers(boolean hasNetworking) {
        userDataSource.findAll(hasNetworking, this);
    }

}
