package sea.com.seandroid.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import sea.com.seandroid.data.model.User;

@Dao
public interface KnowledgeDao {

    /**
     * Read all users
     */
    @Query("SELECT * FROM knowledge")
    List<User> readTasks();
}
