package sea.com.seandroid.util.converter;

import android.arch.persistence.room.TypeConverter;

import sea.com.seandroid.data.model.Contact;

public class ContactStatusTypeConverter {

    @TypeConverter
    public static Contact.Status toStatus(int code) {
        if(code == Contact.Status.NONE.getCode()) {
            return Contact.Status.NONE;
        }
        else if(code == Contact.Status.FRIEND.getCode()) {
            return Contact.Status.FRIEND;
        }
        else if(code == Contact.Status.BLOCKED.getCode()) {
            return Contact.Status.BLOCKED;
        }
        else {
            throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static int toCode(Contact.Status status) {
        return status.getCode();
    }

}
