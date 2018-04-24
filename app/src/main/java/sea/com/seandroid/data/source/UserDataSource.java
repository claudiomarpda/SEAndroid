package sea.com.seandroid.data.source;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.remote.OnUserLoaded;

public interface UserDataSource {

    void findAll(boolean hasNetworking, OnUserLoaded.OnReadAll data);

    void insert(User u);

    void findByEmail(boolean hasNetworking, String email, OnUserLoaded.OnFindByEmail data);
}
