package gajdarapps.rs.kucnadostava20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Splash extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    public static final String MyPrefs="Prefs";
    private SharedPreferences.Editor editor;

    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences =getSharedPreferences(MyPrefs,MODE_PRIVATE);
        String server=sharedPreferences.getString("server","0.0.0.0");
        editor=sharedPreferences.edit();
        editor.putString("server","192.168.1.100");
        editor.commit();
        final Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(3000);
                        Intent i=new Intent(getBaseContext(),Login.class);
                        startActivity(i);
                    }
                }
                catch(InterruptedException ex){
                }

            }

        };
        thread.start();


    }
}
