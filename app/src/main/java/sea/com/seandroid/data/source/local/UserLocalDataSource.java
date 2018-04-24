package sea.com.seandroid.data.source.local;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserLoaded;

public class UserLocalDataSource implements UserDataSource {

    private static volatile UserLocalDataSource instance;

    private static UserDao userDao;

    private Executor executor = Executors.newFixedThreadPool(1);

    private UserLocalDataSource(UserDao userDao) {
        UserLocalDataSource.userDao = userDao;

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
    public void findAll(boolean hasNetworking, OnUserLoaded.OnReadAll data) {
        try {
            data.onReadAll(new FindAllUsersAsync().executeOnExecutor(executor).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("TAG", "read all finished");
    }

    @Override
    public void insert(User u) {
        new InsertUserAsync().executeOnExecutor(executor, u);
    }

    @Override
    public void findByEmail(boolean hasNetworking, String email, OnUserLoaded.OnFindByEmail data) {
        try {
            data.onFindByEmail(
                    new FindUserByEmailAsync().executeOnExecutor(executor, email).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class FindAllUsersAsync extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {
            Log.d("TAG", "in background local");
            return userDao.readAll();
        }
    }

    private static class InsertUserAsync extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class FindUserByEmailAsync extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... strings) {
            return userDao.findByEmail(strings[0]);
        }
    }
}
