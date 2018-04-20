package sea.com.seandroid.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import sea.com.seandroid.R;
import sea.com.seandroid.data.source.remote.UserRemoteDataSource;
import sea.com.seandroid.util.ActivityUtils;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        SearchFragment searchFragment = (SearchFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), searchFragment, R.id.content_frame, false);
        }

        new SearchPresenter(searchFragment, UserRemoteDataSource.getInstance());
    }

}
