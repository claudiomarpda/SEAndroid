package sea.com.seandroid.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import sea.com.seandroid.util.KnowledgeTypeConverters;
import sea.com.seandroid.util.StringTypeConverters;

@Entity(tableName = "user")
public class User extends Person {

    @Nullable
    @TypeConverters(KnowledgeTypeConverters.class)
    private List<Knowledge> knowledgeList = new ArrayList<>();
    @Nullable
    @TypeConverters(StringTypeConverters.class)
    private List<String> frequentLocalList;

    /**
     * Use this constructor to create a new Person with data from remote source
     */
    public User(@NonNull String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    @Nullable
    @TypeConverter
    public List<String> getFrequentLocalList() {
        return frequentLocalList;
    }

    public void setFrequentLocalList(List<String> frequentLocalList) {
        this.frequentLocalList = frequentLocalList;
    }

    @Nullable
    @TypeConverter
    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
    }

    @Override
    public String toString() {
        return "User{" +
                "knowledgeList=" + knowledgeList +
                ", frequentLocalList=" + frequentLocalList +
                '}';
    }
}
