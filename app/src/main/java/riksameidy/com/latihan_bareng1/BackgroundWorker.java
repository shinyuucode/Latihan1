package riksameidy.com.latihan_bareng1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ASUS on 29/05/2016.
 */
public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    DialogInterface.OnClickListener listener;
    String usernametoPass;

    public BackgroundWorker(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String type  = params[0];

        String loginURL = "http://shinyuucode.honor.es/login.php";
        String signupURL = "";

        if(type.equals("login")){
            try {
                String nip = params[1];
                String password = params[2];

                URL url = new URL(loginURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data =
                        URLEncoder.encode("nip","UTF-8") +"=" + URLEncoder.encode(nip,"UTF-8")
                                +"&"+
                                URLEncoder.encode("password","UTF-8") +"=" + URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!= null){
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                usernametoPass = nip;
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onPostExecute(String result) {

        if(result.equals("true")){
            Intent intent = new Intent(context,DosenAwalMenu.class);
            intent.putExtra("NIP",usernametoPass);
            context.startActivity(intent);
        }
        else{
        alertDialog.setMessage("Login Failed , Try Again!");
        alertDialog.show();

        }
    }

}
