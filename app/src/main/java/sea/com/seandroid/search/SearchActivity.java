package sea.com.seandroid.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sea.com.seandroid.R;
import sea.com.seandroid.util.ActivityUtils;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        SearchFragment searchFragment = (SearchFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if(searchFragment == null) {
            searchFragment = SearchFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), searchFragment, R.id.content_frame);
        }

        new SearchPresenter(searchFragment);
    }
}
