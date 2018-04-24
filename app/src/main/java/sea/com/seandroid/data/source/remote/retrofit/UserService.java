package sea.com.seandroid.data.source.remote.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sea.com.seandroid.data.model.User;

public interface UserService {

    @GET("all")
    Call<List<User>> readAll();

    @GET("{userEmail}")
    Call<User> findByEmail(@Path("userEmail") String email);

}
