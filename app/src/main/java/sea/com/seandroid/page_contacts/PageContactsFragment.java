package sea.com.seandroid.page_contacts;


import android.media.MediaCas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.data.model.User;
import sea.com.seandroid.util.ActivityUtils;

public class PageContactsFragment extends Fragment implements PageContactsContract.View {

    private PageContactsContract.Presenter mContactPresenter;
    private RecyclerView mRecyclerView;

    public PageContactsFragment() {
        // Required empty public constructor
    }

    public static PageContactsFragment newInstance() {
        return new PageContactsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_contacts_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.page_contacts_recycler_list);

        if (mContactPresenter != null) {
//            mContactPresenter.start();

            mContactPresenter.findUserById(
                    ActivityUtils.hasNetwork(getContext()), UserSession.user.getId());

        } else {
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }

        return view;
    }

    @Override
    public void setPresenter(PageContactsContract.Presenter presenter) {
        this.mContactPresenter = presenter;
    }

    @Override
    public void showList(List<Contact> contacts) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);

        PageContactsAdapter adapter;
        if (contacts != null) {
            adapter = new PageContactsAdapter(mContactPresenter, contacts);
        } else {
            Log.d("TAG", "contact list null | " + getClass().getSimpleName());
            adapter = new PageContactsAdapter(mContactPresenter, Collections.<Contact>emptyList());
        }
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showItemDetail(View view, int position) {
        Toast.makeText(getContext(), "show item detail " + position, Toast.LENGTH_LONG).show();
    }
}
