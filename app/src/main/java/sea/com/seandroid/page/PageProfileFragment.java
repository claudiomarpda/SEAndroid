package sea.com.seandroid.page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sea.com.seandroid.R;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.page_profile_fragment, container, false);
    }

}
