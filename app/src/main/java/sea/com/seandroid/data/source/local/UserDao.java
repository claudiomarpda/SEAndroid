package sea.com.seandroid.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sea.com.seandroid.data.model.User;

@Dao
public interface UserDao extends PersonDao {

    @Insert
    void insert(User u);

    @Query("SELECT * FROM user WHERE id IN (:id)")
    User findById(String id);

    @Update
    void update(User u);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> findAll();

    @Query("SELECT * FROM user WHERE id in (:email)")
    User findByEmail(String email);
}
