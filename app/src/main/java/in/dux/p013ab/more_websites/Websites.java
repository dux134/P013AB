package in.dux.p013ab.more_websites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import in.dux.p013ab.Dashboard;
import in.dux.p013ab.R;
import in.dux.p013ab.news_and_events.NewsAndEvent;

public class Websites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        Toolbar toolbar = findViewById(R.id.websitesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Websites.this, Dashboard.class));
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
