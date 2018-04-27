package sea.com.seandroid.data.source;

import android.support.annotation.NonNull;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.local.UserLocalDataSource;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;

public class UserRepository implements UserDataSource {

    private static UserRepository instance;

    private final UserDataSource mUserRemoteDataSource;
    private final UserDataSource mUserLocalDataSource;

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
    public void findAll(boolean hasNetworking, OnUserLoaded.OnFindAll data) {
        if(hasNetworking) {
            mUserRemoteDataSource.findAll(hasNetworking, data);
        }
        else {
            mUserLocalDataSource.findAll(hasNetworking, data);
        }
    }

    @Override
    public void insert(User u) {
        mUserLocalDataSource.insert(u);
    }

    @Override
    public void findByEmail(boolean hasNetworking, String email, OnUserLoaded.OnFindByEmail data) {
        if(hasNetworking) {
            mUserRemoteDataSource.findByEmail(hasNetworking, email, data);
        }
        else {
            mUserLocalDataSource.findByEmail(hasNetworking, email, data);
        }
    }

    @Override
    public void findById(boolean hasNetworking, String id, OnUserLoaded.OnFindById data) {
        if(hasNetworking) {
            mUserRemoteDataSource.findById(hasNetworking, id, data);
        }
        else {
            mUserLocalDataSource.findById(hasNetworking, id, data);
        }
    }

    @Override
    public void update(boolean hasNetwork, User u) {
        if(hasNetwork) {
            mUserRemoteDataSource.update(true, u);
        }
        mUserLocalDataSource.update(hasNetwork, u);
    }

}
