package sea.com.seandroid;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sea.com.seandroid.data.model.Knowledge;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.local.SEADatabase;
import sea.com.seandroid.data.source.local.UserDao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class UserDaoTest {

    private SEADatabase mDb;
    private UserDao mUserDao;

    private User user = new User("id01", "Name", "LastName");

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        mDb = Room.inMemoryDatabaseBuilder(context, SEADatabase.class)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build();
        mUserDao = mDb.userDao();
    }

    @After
    public void closeDb() {
        mDb.close();
    }

    @Test
    public void createAndReadUserShouldSucceed() {
        mUserDao.create(user);
        User u = mUserDao.read("id01");
        assertEquals(u.getFirstName(), user.getFirstName());
    }

    @Test
    public void updateShouldSucceed() {
        mUserDao.create(user);
        assertEquals(mUserDao.read("id01").getFirstName(), user.getFirstName());
        user.setFirstName("updated name");
        mUserDao.update(user);

        User u = mUserDao.read("id01");
        assertEquals(u.getFirstName(), user.getFirstName());
        assertEquals(u.getFirstName(), "updated name");
    }

    @Test
    public void deleteShouldSucceed() {
        mUserDao.create(user);
        User u = mUserDao.read("id01");
        assertEquals(u.getFirstName(), user.getFirstName());
        mUserDao.delete(user);
        assertNull(mUserDao.read("id01"));
    }

    @Test
    public void createAndReadUserWithKnowledgeShouldSucceed() {
        Knowledge k1 = new Knowledge("k01", "Knowledge Title", "Knowledge description");
        Knowledge k2 = new Knowledge("k02", "Knowledge Title", "Knowledge description");
        user.setKnowledgeList(Arrays.asList(k1, k2));
        mUserDao.create(user);

        User u = mUserDao.read("id01");
        assertNotNull(u.getKnowledgeList());

        assertEquals(user.getKnowledgeList().get(0).getId(), "k01");
        assertEquals(user.getKnowledgeList().get(1).getId(), "k02");
    }
}
