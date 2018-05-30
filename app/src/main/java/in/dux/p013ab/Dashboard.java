package in.dux.p013ab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import in.dux.p013ab.more_websites.Websites;
import in.dux.p013ab.news_and_events.NewsAndEvent;
import in.dux.p013ab.notices.Notices;
import in.dux.p013ab.placement.Placements;
import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView abesit,moodle,aktu,oneview,more;
    private Slider slider;
    private Button notice,newsandevent,placement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        slider = findViewById(R.id.slider);
        abesit = findViewById(R.id.abesitImage);
        moodle = findViewById(R.id.moodleImage);
        aktu = findViewById(R.id.aktuImage);
        oneview = findViewById(R.id.oneviewImage);
        more = findViewById(R.id.moreImage);
        notice = findViewById(R.id.notices);
        newsandevent = findViewById(R.id.newsAndEvent);
        placement = findViewById(R.id.placement);

        clickListenersOnNewThread();
        loadSlider();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clickListenersOnNewThread() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Dashboard.this,Notices.class));
                        finish();
                    }
                });
                newsandevent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Dashboard.this,NewsAndEvent.class));
                        finish();
                    }
                });
                placement.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Dashboard.this,Placements.class));
                        finish();
                    }
                });

                abesit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("https://abesit.in/"));
                        startActivity(i);
                    }
                });
                moodle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("http://117.55.242.132/moodle/"));
                        startActivity(i);
                    }
                });
                aktu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("https://aktu.ac.in/"));
                        startActivity(i);
                    }
                });
                oneview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("https://erp.aktu.ac.in/WebPages/OneView/OneView.aspx"));
                        startActivity(i);
                    }
                });
                more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Dashboard.this, Websites.class));
                        finish();
                    }
                });

            }
        });



    }

    private void loadSlider() {
        //create list of slides
        List<Slide> slideList = new ArrayList<>();
        slideList.add(new Slide(0,"https://abesit.in/wp-content/uploads/2017/05/1-ABESIT-best-engineering-college-in-delhi-ncr.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(1,"https://abesit.in/wp-content/uploads/2018/04/ABESIT-Centers-of-Excellene.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(2,"https://abesit.in/wp-content/uploads/2018/03/Extraordinary-Performance-of-B.-Tech-1st-Year-Students-8.3.2018.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(3,"https://abesit.in/wp-content/uploads/2018/04/abesit-achievements.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

//handle slider click listener
        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //do what you want
            }
        });

//add slides to slider
        slider.addSlides(slideList);
    }
}
