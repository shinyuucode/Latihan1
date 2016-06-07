package riksameidy.com.latihan_bareng1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

public class DosenBuatKelas extends AppCompatActivity {

    private String nip;
    private EditText kodekelasE,jumlahKelasE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_buat_kelas);
        nip = getIntent().getExtras().getString("NIP");

    }

    public void submitAddKelas(View view) {

        kodekelasE = (EditText) findViewById(R.id.kodekelasDiDosenBuatKelas);
        jumlahKelasE = (EditText) findViewById(R.id.jumlahMhsDiDosenBuatKelas);
        String kodekelas,jumlahKelas;

        kodekelas = kodekelasE.getText().toString();
        jumlahKelas = jumlahKelasE.getText().toString();

        BuatKelasTask buatKelasTask = new BuatKelasTask(this);

        buatKelasTask.execute(nip,kodekelas,jumlahKelas);

    }

    class BuatKelasTask extends AsyncTask<String,Void,String>{

        Context context;
        String url, kodekelasD,jumlahMhsD, nips;

        public BuatKelasTask(Context context){
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {

            url = "http://shinyuucode.honor.es/addKelas.php";
            nips = params[0]; kodekelasD=params[1];jumlahMhsD=params[2];
            try{
                URL addKelasURL = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) addKelasURL.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data =
                        URLEncoder.encode("nip","UTF-8")+ "=" + URLEncoder.encode(nips,"UTF-8") +
                                "&" +
                                URLEncoder.encode("kodekelas","UTF-8") + "=" + URLEncoder.encode(kodekelasD,"UTF-8")+
                                "&" +
                                URLEncoder.encode("jumlahMhs","UTF-8") + "=" + URLEncoder.encode(jumlahMhsD,"UTF-8");
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
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "error 1";
            } catch (IOException e) {
                e.printStackTrace();
                return "error 2";
            }

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context,Login.class);
            context.startActivity(intent);
        }

    }


}
