package gajdarapps.rs.kucnadostava20.Adapteri;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gajdarapps.rs.kucnadostava20.R;

/**
 * Created by micko on 04/25/2017.
 */

public class KonobariAdapter extends BaseAdapter {
    private JSONArray mData;
    private Activity mActivity;
    private static LayoutInflater mInflater=null;
    private String mServer;
    @Override
    public int getCount() {
        return mData.length();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListKonobar celija;
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.konobar_celija,null);
            celija=new ListKonobar();
            celija.mIme=(TextView) convertView.findViewById(R.id.ime_konobar);
            celija.mSlika=(ImageView) convertView.findViewById(R.id.slika_konobar);
            convertView.setTag(celija);
        }
        else
            celija=(ListKonobar) convertView.getTag();
        try{
            JSONObject obj=mData.getJSONObject(position);
            celija.mIme.setText(obj.getString("ime"));
            String s= obj.getString("slika");
            String putanja="http://"+mServer+"/KucnaDostava/Konobari/"+ s.substring(s.lastIndexOf("\\")+1);
            Picasso.with(this.mActivity).load(putanja).into(celija.mSlika);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return convertView;
    }

    public KonobariAdapter(JSONArray jsonArray, Activity a,String server){
        this.mData=jsonArray;
        this.mActivity=a;
        this.mServer=server;
        mInflater=(LayoutInflater) this.mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private class ListKonobar
    {
        private ImageView mSlika;
        private TextView mIme;
    }
}
