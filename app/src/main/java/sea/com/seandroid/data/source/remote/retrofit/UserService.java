package sea.com.seandroid.data.source.remote.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import sea.com.seandroid.data.model.User;

public interface UserService {

    @GET("all")
    Call<List<User>> readAll();
}
