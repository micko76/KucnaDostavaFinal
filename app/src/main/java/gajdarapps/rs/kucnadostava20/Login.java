package gajdarapps.rs.kucnadostava20;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
    private Dialog dialog;
    final Context c=this;
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
        mKonobari.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog=new Dialog(c);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.model_dialog);
                final EditText lozinka=(EditText) dialog.findViewById(R.id.pass);
                Button button=(Button) dialog.findViewById(R.id.prijava);
                dialog.getWindow().setLayout(500,500);
                dialog.show();

            }
        });

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
