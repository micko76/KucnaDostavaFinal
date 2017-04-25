package gajdarapps.rs.kucnadostava20.Pomocne;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by micko on 04/25/2017.
 */

public class Konektor {


    public JSONArray GetKonobar(String server){

        JSONArray rezultat=null;
        try {
            //Povezivanje na skriptu na serveru
            URL url=new URL("http://"+server+"/KucnaDostava/getkonobar.php");
            HttpURLConnection veza=(HttpURLConnection) url.openConnection();
            veza.connect();

            InputStream inputStream=veza.getInputStream();
            BufferedReader streamReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr=streamReader.readLine())!=null)
                responseStrBuilder.append(inputStr);
            rezultat=new JSONArray(responseStrBuilder.toString());
        }
        catch (JSONException|IOException e){
            e.printStackTrace();
        }
        return rezultat;
    }
    public JSONArray GetMeniStavkaJelo(int id,String server){
        JSONArray rezultat=null;
        try {
            //Povezivanje na skriptu na serveru
            URL url=new URL("http://"+server+"/KucnaDostava/popunistavku_jelo.php?Id="+id);
            HttpURLConnection veza=(HttpURLConnection) url.openConnection();
            veza.connect();

            InputStream inputStream=veza.getInputStream();
            BufferedReader streamReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr=streamReader.readLine())!=null)
                responseStrBuilder.append(inputStr);
            rezultat=new JSONArray(responseStrBuilder.toString());
        }
        catch (JSONException |IOException e){
            e.printStackTrace();
        }
        return rezultat;
    }
    public JSONArray GetMeniStavkaPice(int id, String server){
        JSONArray rezultat=null;
        try {
            //Povezivanje na skriptu na serveru
            URL url=new URL("http://"+server+"/KucnaDostava/popunistavku_pice.php?Id="+id);
            HttpURLConnection veza=(HttpURLConnection) url.openConnection();
            veza.connect();

            InputStream inputStream=veza.getInputStream();
            BufferedReader streamReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr=streamReader.readLine())!=null)
                responseStrBuilder.append(inputStr);
            rezultat=new JSONArray(responseStrBuilder.toString());
        }
        catch (JSONException|IOException e){
            e.printStackTrace();
        }
        return rezultat;
    }
    public JSONArray GetBrojac(String server){
        JSONArray rezultat=null;
        try {
            //Povezivanje na skriptu na serveru
            URL url=new URL("http://"+server+"/KucnaDostava/brojac_racuna.php");
            HttpURLConnection veza=(HttpURLConnection) url.openConnection();
            veza.connect();

            InputStream inputStream=veza.getInputStream();
            BufferedReader streamReader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr=streamReader.readLine())!=null)
                responseStrBuilder.append(inputStr);
            rezultat=new JSONArray(responseStrBuilder.toString());
        }
        catch (JSONException|IOException e){
            e.printStackTrace();
        }
        return rezultat;
    }
}
