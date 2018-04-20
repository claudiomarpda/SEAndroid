package sea.com.seandroid.search;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.util.ActivityUtils;
import sea.com.seandroid.util.JsonUtils;

/**
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements SearchContract.View {

    private SearchContract.Presenter mPresenter;

    private TextInputEditText mSearchSubject;
    private TextInputEditText mSearchLocation;
    private Button mSearchButton;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        if (presenter == null) {
            throw new NullPointerException("Presenter null in " + this.getClass());
        }
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.search_fragment, container, false);
        mSearchSubject = root.findViewById(R.id.search_subject_text);
        mSearchLocation = root.findViewById(R.id.search_location_text);
        mSearchButton = root.findViewById(R.id.search_users_button);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.searchUsers();
            }
        });
        return root;
    }

    @Override
    public void replaceWithResultFragment(List<User> list) {
        String jsonString = JsonUtils.listToJsonString(list);
        SearchResultFragment frag = SearchResultFragment.newInstance(jsonString);
        ActivityUtils.addFragmentToActivity(getFragmentManager(), frag, R.id.search_result_container, true);
    }

}
