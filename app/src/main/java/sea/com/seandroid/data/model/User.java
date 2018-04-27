package sea.com.seandroid.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import sea.com.seandroid.util.converter.ContactRequestTypeConverter;
import sea.com.seandroid.util.converter.ContactTypeConverter;
import sea.com.seandroid.util.converter.KnowledgeTypeConverter;
import sea.com.seandroid.util.converter.StringTypeConverter;

@Entity(tableName = "user")
public class User extends Person {

    @Nullable
    @TypeConverters(KnowledgeTypeConverter.class)
    private List<Knowledge> knowledgeList = new ArrayList<>();

    @Nullable
    @TypeConverters(StringTypeConverter.class)
    private List<String> frequentLocalList;

    @NonNull
    private String email;

    @Nullable
    @TypeConverters(ContactTypeConverter.class)
    private List<Contact> contacts = new ArrayList<>();

    @Nullable
    @TypeConverters(ContactRequestTypeConverter.class)
    private List<ContactRequest> contactRequests = new ArrayList<>();


    /**
     * Use this constructor for existent instances from remote or local data source
     */
    public User(@NonNull String id, String firstName, String lastName, @NonNull String email) {
        super(id, firstName, lastName);
        this.email = email;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @Nullable
    @TypeConverter
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(@Nullable List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Nullable
    @TypeConverter
    public List<ContactRequest> getContactRequests() {
        return contactRequests;
    }

    public void setContactRequests(@Nullable List<ContactRequest> contactRequests) {
        this.contactRequests = contactRequests;
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
                ", email='" + email + '\'' +
                ", contacts=" + contacts +
                ", contactRequests=" + contactRequests +
                '}';
    }
}
