package sea.com.seandroid.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.local.UserLocalDataSource;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;

public class UserRepository implements UserDataSource {

    private static UserRepository instance;

    private final UserDataSource mUserRemoteDataSource;
    private final UserDataSource mUserLocalDataSource;

    private UserRepository(@NonNull UserRemoteDataSource remote,
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
    public void findAll(boolean network, OnUserLoaded.OnFindAll data) {
        if (network) {
            mUserRemoteDataSource.findAll(network, data);
        } else {
            mUserLocalDataSource.findAll(network, data);
        }
    }

    @Override
    public void insert(boolean network, User u) {
        if (network) {
            mUserRemoteDataSource.insert(true, u);
        } else {
            mUserLocalDataSource.insert(false, u);
        }
    }

    @Override
    public void findByEmail(boolean network, String email, OnUserLoaded.OnFindByEmail data) {
        if (network) {
            mUserRemoteDataSource.findByEmail(network, email, data);
        } else {
            mUserLocalDataSource.findByEmail(network, email, data);
        }
    }

    @Override
    public void findById(boolean network, String id, OnUserLoaded.OnFindById data) {
        if (network) {
            mUserRemoteDataSource.findById(network, id, data);
        } else {
            mUserLocalDataSource.findById(network, id, data);
        }
    }

    @Override
    public void update(boolean network, User u) {
        if (network) {
            mUserRemoteDataSource.update(true, u);
        }
        mUserLocalDataSource.update(network, u);
    }

    @Override
    public void findAllContactsByUserId(boolean network, String id,
                                        OnUserLoaded.OnFindAllContactsByUserId data) {

        if (network) {
            mUserRemoteDataSource.findAllContactsByUserId(true, id, data);
        } else {
            mUserLocalDataSource.findAllContactsByUserId(false, id, data);
        }
    }

    @Override
    public void findAllKnowledgeByUserId(boolean network, String id, OnKnowledgeLoaded data) {

        if(network) {
            mUserRemoteDataSource.findAllKnowledgeByUserId(true, id, data);
        }

    }
}
