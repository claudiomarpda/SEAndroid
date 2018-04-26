package sea.com.seandroid.util;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import sea.com.seandroid.data.model.Contact;

public class ContactTypeConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Contact> stringToObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Contact>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String objectListToString(List<Contact> list) {
        return gson.toJson(list);
    }
}
