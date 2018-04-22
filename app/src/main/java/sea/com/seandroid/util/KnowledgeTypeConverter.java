package sea.com.seandroid.util;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import sea.com.seandroid.data.model.Knowledge;

public class KnowledgeTypeConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Knowledge> stringToKnowledgeList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Knowledge>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String knowledgeListToString(List<Knowledge> knowledgeList) {
        return gson.toJson(knowledgeList);
    }
}
