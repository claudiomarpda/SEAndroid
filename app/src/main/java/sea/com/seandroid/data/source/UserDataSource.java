package sea.com.seandroid.data.source;

import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public interface UserDataSource {

    void readAll(OnUserDataLoaded data);
}
