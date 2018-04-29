package sea.com.seandroid.page_profile;

import java.util.List;

import sea.com.seandroid.BasePresenter;
import sea.com.seandroid.BaseView;
import sea.com.seandroid.data.model.Knowledge;

public interface PageProfileContract {

    interface View extends BaseView<Presenter> {

        void showProfileKnowledge(List<Knowledge> knowledgeList);

    }

    interface Presenter extends BasePresenter {

        void findProfileKnowledge(boolean network);

    }
}
