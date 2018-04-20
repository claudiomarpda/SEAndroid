package sea.com.seandroid.data.source;

import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public interface UserDataSource {

    void readAll(OnUserDataLoaded data);

    List<User> readAll();
}
