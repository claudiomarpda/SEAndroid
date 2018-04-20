package sea.com.seandroid.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import sea.com.seandroid.R;
import sea.com.seandroid.data.model.User;

/**
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment implements ResultContract.View {

    private ResultContract.Presenter mResultPresenter;
    private RecyclerView mRecyclerView;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void setPresenter(ResultContract.Presenter presenter) {
        if (presenter == null) {
            throw new NullPointerException("Presenter null in " + this.getClass());
        }
        mResultPresenter = presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.search_result_fragment, container, false);
        mRecyclerView = root.findViewById(R.id.search_result_recycler_list);

        if (mResultPresenter != null) {
            mResultPresenter.start();
        } else {
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }
        return root;
    }

    @Override
    public void loadList(List<User> list) {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);
        ResultListAdapter resultListAdapter = new ResultListAdapter(mResultPresenter, list);
        mRecyclerView.setAdapter(resultListAdapter);
    }

    @Override
    public void showItemDetail(View view, int position) {
        Toast.makeText(getContext(), "show item detail " + position, Toast.LENGTH_LONG).show();
    }
}
