package ilo.ilo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.Exception;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

public class HttpGETRequest extends AsyncTask<String, Void, String>{

    @Override
    protected String doInBackground(String... params){

        String stringUrl = params[0];
        String inputLine;
        String result;
        try {
            URL url = new URL(stringUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }
            reader.close();
            streamReader.close();
            result = stringBuilder.toString();
            con.disconnect();
            return result;
        } catch(Exception e) {
          return  "Error "+ e.getMessage();
        }

    }
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }


}
