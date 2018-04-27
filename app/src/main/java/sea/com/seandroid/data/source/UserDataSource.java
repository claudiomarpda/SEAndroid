package sea.com.seandroid.data.source;

import sea.com.seandroid.data.model.User;

public interface UserDataSource {

    void findAll(boolean hasNetworking, OnUserLoaded.OnFindAll data);

    void insert(User u);

    void findByEmail(boolean hasNetworking, String email, OnUserLoaded.OnFindByEmail data);

    void findById(boolean hasNetworking, String id, OnUserLoaded.OnFindById data);

    void update(boolean hasNetwork, User u);

    void findAllContactsByUserId(boolean hasNetwork, String id,
                                 OnUserLoaded.OnFindAllContactsByUserId data);
}
