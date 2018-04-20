package sea.com.seandroid.data.source.local;

import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.OnUserDataLoaded;

public class UserLocalDataSource implements UserDataSource {

    private static volatile UserLocalDataSource instance;

    private UserDao userDao;
    private List<User> list;
    private Semaphore semaphore = new Semaphore(0);

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
    public void readAll(OnUserDataLoaded data) {

    }

    @Override
    public List<User> readAll() {
        new LocalDataSourceAsync().executeOnExecutor(executor);
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return list;
    }

    private class LocalDataSourceAsync extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... voids) {
            return userDao.readUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            list = users;
//            semaphore.release();
        }
    }
}
