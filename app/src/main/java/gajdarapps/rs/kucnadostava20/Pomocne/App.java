package gajdarapps.rs.kucnadostava20.Pomocne;

import android.app.Application;

import gajdarapps.rs.kucnadostava20.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by micko on 04/16/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/myriad_pro.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }
}
