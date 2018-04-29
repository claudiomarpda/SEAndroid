package sea.com.seandroid.page_profile;

import java.util.List;

import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Knowledge;
import sea.com.seandroid.data.source.OnKnowledgeLoaded;
import sea.com.seandroid.data.source.UserDataSource;

public class PageProfilePresenter implements PageProfileContract.Presenter, OnKnowledgeLoaded {

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
    public void findProfileKnowledge(boolean network) {
        mUserDataSource.findAllKnowledgeByUserId(network, UserSession.user.getId(), this);
    }

    @Override
    public void onFindAll(List<Knowledge> knowledgeList) {
        mProfileView.showProfileKnowledge(knowledgeList);
    }
}
