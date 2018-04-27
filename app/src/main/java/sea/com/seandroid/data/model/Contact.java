package sea.com.seandroid.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sea.com.seandroid.util.converter.ContactStatusTypeConverter;
import sea.com.seandroid.util.converter.ContactTypeConverter;

@Entity(tableName = "contact")
public class Contact {

    public enum Status {
        NONE(0), FRIEND(1), BLOCKED(2);

        private int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    @PrimaryKey
    @NonNull
    private String contactId;

    @Nullable
    @TypeConverters(ContactStatusTypeConverter.class)
    private Status status;

    public Contact(@NonNull String contactId, @Nullable Status status) {
        this.contactId = contactId;
        this.status = status;
    }

    /**
     * Use this constructor for existent instances from remote or local data source
     */
    @Ignore
    public Contact(@NonNull String contactId) {
        this.contactId = contactId;
        this.status = Status.NONE;
    }

    @NonNull
    public String getContactId() {
        return contactId;
    }

    public void setContactId(@NonNull String contactId) {
        this.contactId = contactId;
    }

    @Nullable
    @TypeConverter
    public Status getStatus() {
        return status;
    }

    public void setStatus(@Nullable Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", status=" + status +
                '}';
    }
}
