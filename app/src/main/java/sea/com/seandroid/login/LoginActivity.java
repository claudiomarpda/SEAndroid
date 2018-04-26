package sea.com.seandroid.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sea.com.seandroid.Injection;
import sea.com.seandroid.R;
import sea.com.seandroid.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        LoginFragment loginFragment = (LoginFragment)
                getSupportFragmentManager().findFragmentById(R.id.login_content_frame);

        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

            ActivityUtils.setFragmentToActivity(
                    getSupportFragmentManager(), loginFragment, R.id.login_content_frame,
                    false);
        }

        new LoginPresenter(loginFragment,
                Injection.provideUserRepository(getApplicationContext()));
    }

}

