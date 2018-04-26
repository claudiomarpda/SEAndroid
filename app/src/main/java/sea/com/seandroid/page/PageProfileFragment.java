package sea.com.seandroid.page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sea.com.seandroid.R;
import sea.com.seandroid.UserSession;

public class PageProfileFragment extends Fragment {

    public PageProfileFragment() {
        // Required empty public constructor
    }

    public static PageProfileFragment newInstance() {
        return new PageProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_profile_fragment, container, false);

        TextView textView = view.findViewById(R.id.page_profile_name);
        if(UserSession.user != null) {
            textView.setText(UserSession.user.getFirstName() + " " + UserSession.user.getLastName());
        }

        return view;
    }

}
