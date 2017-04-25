package gajdarapps.rs.kucnadostava20;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;

import gajdarapps.rs.kucnadostava20.Adapteri.KonobariAdapter;
import gajdarapps.rs.kucnadostava20.Pomocne.Konektor;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    public static final String MyPrefs="Prefs";
    public String server;
    public ListView mKonobari;
    private JSONArray elementi;
    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mKonobari=(ListView) findViewById(R.id.listKonobari);
        sharedPreferences = getSharedPreferences(MyPrefs,MODE_PRIVATE);
        server=sharedPreferences.getString("server","0.0.0.0");
        new PopuniKonobare().execute(new Konektor());

    }
    public void SetListAdapter(JSONArray niz){
        this.elementi=niz;
        mKonobari.setAdapter(new KonobariAdapter(elementi,this,server));
    }
    private class PopuniKonobare extends AsyncTask<Konektor,Long,JSONArray>{

        @Override
        protected JSONArray doInBackground(Konektor... params) {
            return params[0].GetKonobar(server);
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            Log.e("Sta je uhvaceno",jsonArray.toString());
            SetListAdapter(jsonArray);

        }


    }
}
