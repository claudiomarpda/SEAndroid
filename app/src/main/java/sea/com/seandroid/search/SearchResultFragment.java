package sea.com.seandroid.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.util.JsonUtils;

/**
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchResultFragment extends Fragment {

    private static final String SEARCH_RESULT = "search_result_as_json_key";

    private String usersJsonArrayAsString;

    public SearchResultFragment() {
        // Required empty public constructor
    }

    public static SearchResultFragment newInstance(String jsonArrayAsString) {
        SearchResultFragment fragment = new SearchResultFragment();
        Bundle args = new Bundle();
        args.putString(SEARCH_RESULT, jsonArrayAsString);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usersJsonArrayAsString = getArguments().getString(SEARCH_RESULT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.search_result_fragment, container, false);
        TextView textView = root.findViewById(R.id.search_result_text);

        List<User> userList = JsonUtils.jsonStringToUserList(usersJsonArrayAsString);
        for(User u: userList) {
            textView.setText("# " + u.toString());
        }

        return root;
    }

}
