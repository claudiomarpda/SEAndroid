package sea.com.seandroid.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.ContactRequest;
import sea.com.seandroid.data.model.Knowledge;
import sea.com.seandroid.data.model.Person;
import sea.com.seandroid.data.model.User;

@Database(entities = {
        Person.class,
        User.class,
        Knowledge.class,
        Contact.class,
        ContactRequest.class},
        version = 1)
public abstract class SEADatabase extends RoomDatabase {

    private static SEADatabase instance;

    public abstract UserDao userDao();

    private static final Object sLock = new Object();

    public static SEADatabase getInstance(Context context) {
        synchronized (sLock) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        SEADatabase.class, "Users.db")
                        .build();
            }
            return instance;
        }
    }
}
