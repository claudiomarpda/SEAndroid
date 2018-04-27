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
        void onFindById(User u);
    }

    interface OnFindAllContactsByUserId {
        void onFindAllContactsByUserId(boolean fromNetwork, List<User> users);
    }

}
