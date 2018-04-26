package sea.com.seandroid.page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import sea.com.seandroid.R;
import sea.com.seandroid.search.SearchActivity;
import sea.com.seandroid.util.ActivityUtils;

public class PageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_activity);

        PageTabFragment pageTabFragment = (PageTabFragment)
                getSupportFragmentManager().findFragmentById(R.id.pages_content_frame);

        if(pageTabFragment == null) {
            pageTabFragment = PageTabFragment.newInstance();

            ActivityUtils.setFragmentToActivity(getSupportFragmentManager(),
                    pageTabFragment, R.id.pages_content_frame, false);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_search:
                Intent i = new Intent(this, SearchActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tab_action, menu);
        return true;
    }
}
