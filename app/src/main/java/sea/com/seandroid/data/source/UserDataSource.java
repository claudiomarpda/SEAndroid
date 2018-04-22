package sea.com.seandroid.data.source;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public interface UserDataSource {

    void readAll(boolean hasNetworking, OnUserDataLoaded data);

    void create(User u);
}
