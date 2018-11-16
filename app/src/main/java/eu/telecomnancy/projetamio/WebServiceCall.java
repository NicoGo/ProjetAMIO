package eu.telecomnancy.projetamio;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WebServiceCall extends AsyncTask<Void, Integer, Void>
{

    int code = 200;
    private Context context;
    private ArrayList<Mote> capteurs = new ArrayList<Mote>();

    public WebServiceCall(Context c)
    {
        this.context=c;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        HttpURLConnection urlConnection;

        try {
            URL url = new URL("http://iotlab.telecomnancy.eu/rest/data/1/light1/last/");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            String finalText = "";

            while ((line = br.readLine()) != null) {
                finalText += line;
            }
            System.out.println(finalText);
            JSONObject obj = new JSONObject(finalText);
            JSONArray arr = obj.getJSONArray("data");

            for(int i=0; i<arr.length();i++)
            {
                JSONObject tempObject = arr.getJSONObject(i);
                String mote = tempObject.getString("mote");
                Double value = tempObject.getDouble("value");
                capteurs.add(new Mote(mote,value));
            }

            int httpCode = urlConnection.getResponseCode();
            urlConnection.disconnect();
        }
            catch(Exception e)
            {

            }

    return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        ViewHandler.updateView(capteurs);
        Log.d("WebServiceCall","Le code HTTP est le suivant : "+this.code);
        if(this.code!=200)
            Toast.makeText(this.context, "Une erreur HTTP est survenue, code : "+this.code, Toast.LENGTH_LONG).show();
    }


}