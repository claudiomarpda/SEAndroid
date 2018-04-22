package sea.com.seandroid.data.source.local;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public class UserLocalDataSource implements UserDataSource {

    private static volatile UserLocalDataSource instance;

    private UserDao userDao;

    private Executor executor = Executors.newFixedThreadPool(1);

    private UserLocalDataSource(UserDao userDao) {
        this.userDao = userDao;

    }

    public static UserLocalDataSource getInstance(UserDao userDao) {
        if (instance == null) {
            synchronized (UserLocalDataSource.class) {
                instance = new UserLocalDataSource(userDao);
            }
        }

        return instance;
    }

    @Override
    public void readAll(boolean hasNetworking, OnUserDataLoaded data) {
        try {
            data.onReadAll(new LocalDataSourceAsync().executeOnExecutor(executor).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("TAG", "read all finished");
    }

    private class LocalDataSourceAsync extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            Log.d("TAG", "in background local");
            return userDao.readAll();
        }

    }
}
