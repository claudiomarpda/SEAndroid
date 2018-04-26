package sea.com.seandroid.data.model;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "contact")
public class Contact {

    public enum Status {NONE, FRIEND, BLOCKED}

    @NonNull
    private String contactId;
    @Nullable
    private Status status;

    public Contact(@NonNull String contactId, @Nullable Status status) {
        this.contactId = contactId;
        this.status = status;
    }

    /**
     * Use this constructor for existent instances from remote or local data source
     */
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
