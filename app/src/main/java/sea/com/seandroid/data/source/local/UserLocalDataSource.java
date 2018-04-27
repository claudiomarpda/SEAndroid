package sea.com.seandroid.data.source.local;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.OnUserLoaded;

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
    public void findAll(boolean hasNetworking, OnUserLoaded.OnFindAll data) {
        try {
            data.onFindAll(new FindAllUsersAsync().executeOnExecutor(executor).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("TAG", "findById all finished");
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

    @Override
    public void findById(boolean hasNetworking, String id, OnUserLoaded.OnFindById data) {
        try {
            data.onFindById(
                    new FindUserByIdAsync().executeOnExecutor(executor, id).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(boolean hasNetwork, User u) {
        new UpdateUserAsync().executeOnExecutor(executor, u);
    }

    @Override
    public void findAllContactsByUserId(boolean hasNetwork, String id, OnUserLoaded.OnFindAllContactsByUserId data) {

    }

    private static class FindAllUsersAsync extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {
            Log.d("TAG", "in background local");
            return userDao.findAll();
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

    private static class FindUserByIdAsync extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... strings) {
            return userDao.findById(strings[0]);
        }
    }

    private static class UpdateUserAsync extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class FindAllContactsByUserIdAsync extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
    }
}
