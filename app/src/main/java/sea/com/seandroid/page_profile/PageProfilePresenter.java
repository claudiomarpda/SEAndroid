package sea.com.seandroid.page_profile;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.source.UserDataSource;

public class PageProfilePresenter implements PageProfileContract.Presenter {

    private PageProfileContract.View mProfileView;
    private UserDataSource mUserDataSource;

    public PageProfilePresenter(PageProfileContract.View mProfileView, UserDataSource mUserDataSource) {
        this.mProfileView = mProfileView;
        this.mUserDataSource = mUserDataSource;
        mProfileView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void findKnowledge() {
        mProfileView.showKnowledge(UserSession.user.getKnowledgeList());
    }


}
