package sea.com.seandroid.page_profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Knowledge;
import sea.com.seandroid.util.ActivityUtils;

public class PageProfileFragment extends Fragment implements PageProfileContract.View {

    private PageProfileContract.Presenter mProfilePresenter;

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
        if (UserSession.user != null) {
            textView.setText(UserSession.user.getFirstName() + " " + UserSession.user.getLastName());
        }

        LinearLayout ll = view.findViewById(R.id.page_profile_knowledge_option);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mProfilePresenter != null) {
                    mProfilePresenter.findProfileKnowledge(ActivityUtils.hasNetwork(getContext()));
                }
                Toast.makeText(getContext(), "conhecimentoooos", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void setPresenter(PageProfileContract.Presenter presenter) {
        mProfilePresenter = presenter;
    }

    @Override
    public void showProfileKnowledge(List<Knowledge> knowledgeList) {
        // TODO: Start knowledge activity
    }
}
