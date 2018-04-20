package sea.com.seandroid.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import sea.com.seandroid.data.model.User;

public class JsonUtils {

    public static String listToJsonString(List objectsList) {
        Gson gsonBuilder = new GsonBuilder().create();
        return gsonBuilder.toJson(objectsList);
    }

    public static List<User> jsonStringToUserList(String jsonString) {
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        return new Gson().fromJson(jsonString, listType);
    }
}
