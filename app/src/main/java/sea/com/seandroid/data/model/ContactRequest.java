package sea.com.seandroid.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import sea.com.seandroid.util.converter.ContactRequestStatusTypeConverter;

@Entity(tableName = "contact_request")
public class ContactRequest {

    public enum Status {
        PENDING(0), ACCEPTED(1), REJECTED(2);

        private int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    @NonNull
    @PrimaryKey
    private String id;
    @NonNull
    private String fromUserId;
    @NonNull
    private String toUserId;

    @Nullable
    @TypeConverters(ContactRequestStatusTypeConverter.class)
    private Status status;


    /**
     * Use this constructor for existent instances from remote or local data source
     */
    public ContactRequest(String id, @NonNull String fromUserId, @NonNull String toUserId) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = Status.PENDING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(@NonNull String fromUserId) {
        this.fromUserId = fromUserId;
    }

    @NonNull
    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(@NonNull String toUserId) {
        this.toUserId = toUserId;
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
        return "ContactRequest{" +
                "id='" + id + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", status=" + status +
                '}';
    }
}
