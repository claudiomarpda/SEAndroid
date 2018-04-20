package sea.com.seandroid.search;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import sea.com.seandroid.Injection;
import sea.com.seandroid.R;
import sea.com.seandroid.util.ActivityUtils;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        // Set up the toolbar.
        Toolbar toolbar = findViewById(R.id.search_toolbar);
        toolbar.setTitle(getResources().getString(R.string.search_users));
        setSupportActionBar(toolbar);
//        ActionBar ab = getSupportActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);
//        ab.setDisplayShowHomeEnabled(true);

        SearchFragment searchFragment = (SearchFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (searchFragment == null) {
            searchFragment = SearchFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), searchFragment, R.id.content_frame, false);
        }

        new SearchPresenter(searchFragment,
                Injection.provideUserRepository(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
