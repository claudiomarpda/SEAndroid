package sea.com.seandroid.data.source.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.data.source.OnUserLoaded;
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
    public void findAll(boolean network, final OnUserLoaded.OnFindAll data) {
        userClient.readAll().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        data.onFindAll(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public void insert(boolean network, User u) {

    }

    @Override
    public void findByEmail(boolean network, final String email, final OnUserLoaded.OnFindByEmail data) {
        userClient.findByEmail(email).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        data.onFindByEmail(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public void findById(final boolean network, String id, final OnUserLoaded.OnFindById data) {
        userClient.findById(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        data.onFindById(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public void update(boolean network, User u) {
        userClient.update(u);
    }

    @Override
    public void findAllContactsByUserId(final boolean network, String id,
                                        final OnUserLoaded.OnFindAllContactsByUserId data) {

        userClient.findAllContactsByUserId(id).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        data.onFindAllContactsByUserId(network, response.body());
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
