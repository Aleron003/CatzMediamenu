package menu.catz.aaron.catzmenu;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

//Navigation menu template
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MediaPlayer mPlayer = new MediaPlayer();
        MediaPlayer sharkPlayer = new MediaPlayer();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_video) {

            try {
                playvideo();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (id == R.id.nav_splosion) {

            try {
                playexplosion();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (id == R.id.nav_stop) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public static void playvideo() throws IOException {

        //Should play video if it works right.

        String sUrl = "https://www.dropbox.com/s/kg4c1nrwbwxybro/Tankgif3.mp4?dl=1"; //URL for a video file

        MediaPlayer mPlayer = new MediaPlayer();

        mPlayer.reset();
        System.out.println("Resetting");
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        System.out.println("Setting stream type");
        mPlayer.setDataSource(sUrl);
        System.out.println("Grabbing from URL");
        mPlayer.prepare();
        System.out.println("Preparing");
        mPlayer.start();
        System.out.println("Playing");
    }

    public static void playexplosion() throws IOException {

        //hacking together a music playing function below

        String sUrl = "http://soundbible.com/grab.php?id=1986&type=mp3"; //URL for a generic explosion sound

        MediaPlayer mPlayer = new MediaPlayer();

        mPlayer.reset();
        System.out.println("Resetting");
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        System.out.println("Setting stream type");
        mPlayer.setDataSource(sUrl);
        System.out.println("Grabbing from URL");
        mPlayer.prepare();
        System.out.println("Preparing");
        mPlayer.start();
        System.out.println("Playing");
    }

}
