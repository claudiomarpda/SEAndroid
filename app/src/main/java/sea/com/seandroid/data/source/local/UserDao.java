package sea.com.seandroid.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import sea.com.seandroid.data.model.User;

@Dao
public interface UserDao extends PersonDao {

    /**
     * Read all users
     */
    @Query("SELECT * FROM user")
    List<User> readUsers();
}
