package sea.com.seandroid.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sea.com.seandroid.R;
import sea.com.seandroid.UserSession;
import sea.com.seandroid.page.PageActivity;
import sea.com.seandroid.util.ActivityUtils;

public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginContract.Presenter mLoginPresenter;

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        mEmailView = view.findViewById(R.id.login_email);
        mPasswordView = view.findViewById(R.id.login_password);
        mLoginFormView = view.findViewById(R.id.login_form);

        Button mEmailSignInButton = view.findViewById(R.id.login_sign_in);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(UserSession.user != null) {
                    showLoginAccepted();
                }

                mLoginPresenter.attemptLogin(
                        ActivityUtils.hasNetwork(getContext()),
                        "example1@email.com");

            }
        });

        if(UserSession.user != null) {
            showLoginAccepted();
        }

        return view;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mLoginPresenter = presenter;
    }

    @Override
    public void showLoginAccepted() {
        Intent i = new Intent(getActivity(), PageActivity.class);
        startActivity(i);
    }

    @Override
    public void showLoginRejected() {
        Toast.makeText(getContext(), "Login fail", Toast.LENGTH_SHORT).show();
    }

}
