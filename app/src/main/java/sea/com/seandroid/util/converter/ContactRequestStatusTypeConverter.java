package sea.com.seandroid.util.converter;

import android.arch.persistence.room.TypeConverter;

import sea.com.seandroid.data.model.ContactRequest;

public class ContactRequestStatusTypeConverter {

    @TypeConverter
    public static ContactRequest.Status toStatus(int code) {
        if (code == ContactRequest.Status.PENDING.getCode()) {
            return ContactRequest.Status.PENDING;
        } else if (code == ContactRequest.Status.ACCEPTED.getCode()) {
            return ContactRequest.Status.ACCEPTED;
        } else if (code == ContactRequest.Status.REJECTED.getCode()) {
            return ContactRequest.Status.REJECTED;
        } else {
            throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static int toCode(ContactRequest.Status status) {
        return status.getCode();
    }
}
