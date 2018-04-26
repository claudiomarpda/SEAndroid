package sea.com.seandroid.data.source.remote;

import java.util.List;

import sea.com.seandroid.data.model.User;

public interface OnUserLoaded {

    interface OnReadAll {
        void onFindAll(List<User> users);
    }

    interface OnFindByEmail {
        void onFindByEmail(User u);
    }
}
