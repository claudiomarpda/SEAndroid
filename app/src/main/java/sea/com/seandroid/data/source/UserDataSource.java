package sea.com.seandroid.data.source;

import sea.com.seandroid.data.model.User;

public interface UserDataSource {

    void findAll(boolean network, OnUserLoaded.OnFindAll data);

    void insert(boolean network, User u);

    void findByEmail(boolean network, String email, OnUserLoaded.OnFindByEmail data);

    void findById(boolean network, String id, OnUserLoaded.OnFindById data);

    void update(boolean network, User u);

    void findAllContactsByUserId(boolean network, String id,
                                 OnUserLoaded.OnFindAllContactsByUserId data);

}
