package sea.com.seandroid.data.source;

import java.util.List;

import sea.com.seandroid.data.model.User;

public interface OnUserLoaded {

    interface OnFindAll {
        void onFindAll(List<User> users);
    }

    interface OnFindByEmail {
        void onFindByEmail(User u);
    }

    interface OnFindById {
        void onFindById(boolean hasNetwork, User u);
    }

    interface OnFindContactById {
        void onFindContactById(User u);
    }
}
