package sea.com.seandroid.page;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sea.com.seandroid.R;

public class PageTabFragment extends Fragment {

    private static final int[] PAGE_NAMES = {
            R.string.page_contacts,
            R.string.page_notifications,
            R.string.page_profile
    };

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

        final Toolbar toolbar = root.findViewById(R.id.page_toolbar);
        toolbar.setTitle(PAGE_NAMES[0]);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        mViewPager = root.findViewById(R.id.page_viewpager);
        mTabLayout = root.findViewById(R.id.page_tab_layout);

        mPagesAdapter = new PageAdapter(getChildFragmentManager());
        mPagesAdapter.addFragment(PageContactsFragment.newInstance());
        mPagesAdapter.addFragment(PageNotificationFragment.newInstance());
        mPagesAdapter.addFragment(PageProfileFragment.newInstance());

        mViewPager.setAdapter(mPagesAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_account_multiple);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_bell);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_account_circle);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbar.setTitle(PAGE_NAMES[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return root;
    }

}
