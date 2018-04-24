package sea.com.seandroid.search_result;

import android.view.View;

import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.remote.OnUserLoaded;

public class ResultPresenter implements ResultContract.Presenter, OnUserLoaded.OnReadAll {

    private ResultContract.View mResultView;
    private List<User> userList;

    public ResultPresenter(ResultContract.View mResultView, List<User> userList) {
        this.mResultView = mResultView;
        this.userList = userList;
        mResultView.setPresenter(this);
    }

    @Override
    public void start() {
        mResultView.loadList(userList);
    }

    @Override
    public void onItemSelected(View view, int position) {
        mResultView.showItemDetail(view, position);
    }

    @Override
    public void onReadAll(List<User> users) {
        mResultView.loadList(users);
    }

}
