package sea.com.seandroid.data.source.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.UserDataSource;
import sea.com.seandroid.data.source.remote.retrofit.APIClient;
import sea.com.seandroid.data.source.remote.retrofit.UserService;

public class UserRemoteDataSource implements UserDataSource {

    private static UserRemoteDataSource instance;

    private UserService userClient;

    private UserRemoteDataSource() {
        userClient = APIClient.getUserService();
    }

    public static UserRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new UserRemoteDataSource();
        }
        return instance;
    }

    @Override
    public void readAll(boolean hasNetworking, final OnUserDataLoaded data) {
        userClient.readAll().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        data.onReadAll(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
