package sea.com.seandroid.data.source.remote;

import java.util.List;

import sea.com.seandroid.data.model.User;

public interface OnUserDataLoaded {

    void onReadAll(List<User> users);
}
