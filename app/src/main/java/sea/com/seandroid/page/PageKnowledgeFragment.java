package sea.com.seandroid.page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sea.com.seandroid.R;

public class PageKnowledgeFragment extends Fragment {

    public PageKnowledgeFragment() {
        // Required empty public constructor
    }

    public static PageKnowledgeFragment newInstance() {
        return new PageKnowledgeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.page_knowledge_fragment, container, false);
    }

}
