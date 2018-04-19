package sea.com.seandroid.data.source.remote.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String URL = "https://sea-restful.herokuapp.com/api/user/";

    private static UserService service = null;

    private static UserService createUserService() {
        Gson gson = new GsonBuilder().create();

        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(UserService.class);
    }

    public static UserService getUserService() {
        if (service == null) {
            service = APIClient.createUserService();
        }
        return service;
    }

}
