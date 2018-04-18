package sea.com.seandroid.search;

import android.support.annotation.NonNull;

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View mSearchView;

    public SearchPresenter(@NonNull SearchContract.View mSearchView) {
        this.mSearchView = mSearchView;
        mSearchView.setPresenter(this);
    }

    @Override
    public void searchUsers() {

    }

    @Override
    public void start() {
        mSearchView.showSearchWidgets();
    }
}
