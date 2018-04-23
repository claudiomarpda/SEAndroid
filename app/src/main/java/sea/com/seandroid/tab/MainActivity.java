package sea.com.seandroid.tab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import sea.com.seandroid.R;
import sea.com.seandroid.search.SearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar.
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("Principal");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

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
        inflater.inflate(R.menu.action_tab, menu);
        return true;
    }
}
