package sea.com.seandroid.data.source.local;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.OnKnowledgeLoaded;
import sea.com.seandroid.data.source.OnUserLoaded;
import sea.com.seandroid.data.source.UserDataSource;

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
    public void findAll(boolean network, OnUserLoaded.OnFindAll data) {
        try {
            data.onFindAll(new FindAllUsersAsync().executeOnExecutor(executor).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(boolean network, User u) {
        new InsertUserAsync().executeOnExecutor(executor, u);
    }

    @Override
    public void findByEmail(boolean network, String email, OnUserLoaded.OnFindByEmail data) {
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
    public void findById(boolean network, String id, OnUserLoaded.OnFindById data) {
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
    public void update(boolean network, User u) {
        new UpdateUserAsync().executeOnExecutor(executor, u);
    }

    @Override
    public void findAllContactsByUserId(boolean network, String id,
                                        OnUserLoaded.OnFindAllContactsByUserId data) {
        try {
            data.onFindAllContactsByUserId(network,
                    new FindAllContactsByUserIdAsync().executeOnExecutor(executor, id).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAllKnowledgeByUserId(boolean network, String id, OnKnowledgeLoaded data) {

    }


    private static class FindAllUsersAsync extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {
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

    private static class FindAllContactsByUserIdAsync extends AsyncTask<String, Void, List<User>> {

        private List<User> users = new ArrayList<>();

        @Override
        protected List<User> doInBackground(String... ids) {
            User u = userDao.findById(ids[0]);

            if (u == null) {
                return users;
            }

            List<Contact> contacts = u.getContacts();

            if (contacts == null) {
                return users;
            }

            for (Contact c : contacts) {
                User u1 = userDao.findById(c.getContactId());
                if (u1 == null) {
                    continue;
                }
                users.add(u1);
            }
            return users;
        }
    }
}
