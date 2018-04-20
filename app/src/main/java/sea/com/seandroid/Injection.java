package sea.com.seandroid;

import android.content.Context;
import android.support.annotation.NonNull;

import sea.com.seandroid.data.source.UserRepository;
import sea.com.seandroid.data.source.local.SEADatabase;
import sea.com.seandroid.data.source.local.UserLocalDataSource;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;

public class Injection {

    public static UserRepository provideUserRepository(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("Context null in Injection class");
        }
        SEADatabase database = SEADatabase.getInstance(context);
        return UserRepository.getInstance(UserRemoteDataSource.getInstance(),
                UserLocalDataSource.getInstance(database.userDao()));
    }
}
