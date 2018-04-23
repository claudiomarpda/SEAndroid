package sea.com.seandroid.page;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sea.com.seandroid.R;

public class PageTabFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private PageAdapter mPagesAdapter;

    public PageTabFragment() {
        // Required empty public constructor
    }

    public static PageTabFragment newInstance() {
        return new PageTabFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.page_tab_fragment, container, false);

        mViewPager = root.findViewById(R.id.page_viewpager);
        mTabLayout = root.findViewById(R.id.page_tab_layout);

        mPagesAdapter = new PageAdapter(getChildFragmentManager());
        mPagesAdapter.addFragment(PageProfileFragment.newInstance(), getString(R.string.page_profile));
        mPagesAdapter.addFragment(PageKnowledgeFragment.newInstance(), getString(R.string.page_knowledge));

        mViewPager.setAdapter(mPagesAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return root;
    }

}
