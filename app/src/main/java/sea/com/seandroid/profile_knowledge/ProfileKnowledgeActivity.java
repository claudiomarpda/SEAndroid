package sea.com.seandroid.profile_knowledge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import sea.com.seandroid.R;
import sea.com.seandroid.UserSession;
import sea.com.seandroid.data.model.Knowledge;

public class ProfileKnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_knowledge_activity);
        Toolbar toolbar = findViewById(R.id.profile_knowledge_toolbar);
        toolbar.setTitle(R.string.page_knowledge);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView text = findViewById(R.id.profile_knowledge_text);
        Knowledge k = UserSession.user.getKnowledgeList().get(0);
        if(k != null) {
            text.setText(k.getTitle() + "\n" + k.getDescription());
        }
    }

}
