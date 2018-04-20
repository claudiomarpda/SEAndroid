package sea.com.seandroid.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.local.UserLocalDataSource;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;

public class UserRepository implements UserDataSource {

    private static UserRepository instance;

    private final UserRemoteDataSource mUserRemoteDataSource;

    private final UserLocalDataSource mUserLocalDataSource;

    public UserRepository(@NonNull UserRemoteDataSource remote,
                          @NonNull UserLocalDataSource local) {
        this.mUserRemoteDataSource = remote;
        this.mUserLocalDataSource = local;
    }

    public static UserRepository getInstance(UserRemoteDataSource remote,
                                             UserLocalDataSource local) {
        if (instance == null) {
            instance = new UserRepository(remote, local);
        }
        return instance;
    }

    @Override
    public void readAll(OnUserDataLoaded data) {
        mUserRemoteDataSource.readAll(data);
    }

    @Override
    public List<User> readAll() {
        return mUserLocalDataSource.readAll();
    }

}
