package riksameidy.com.latihan_bareng1;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DosenPilihKelas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_pilih_kelas);
        ShowTask showTask = new ShowTask(this);
        showTask.execute();

    }

    class ShowTask extends AsyncTask<String,Void,String>{

        String url;
        Context context;

        public ShowTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            url = "http://shinyuucode.honor.es/pilihKelas.php";
            try {
                URL urlPilih = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlPilih.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line = "";
                while((line=bufferedReader.readLine())!=null){
                    sb.append(line).append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return sb.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                JSONArray jsonArray = new JSONArray(result);
                ArrayList<String> listKelas = new ArrayList<String>();

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject kodeKelas = jsonArray.getJSONObject(i);
                    String kk = kodeKelas.getString("kodekelas");
                    String jumlahMhs = kodeKelas.getString("jumlahMahasiswa");
                    String nip = kodeKelas.getString("nip");
                    if(nip.equals("12345")){
                    listKelas.add(kk + " - " + jumlahMhs + " orang ");
                    }

                }

                Toast.makeText(context.getApplicationContext(),"success" ,Toast.LENGTH_SHORT).show();
                ListView listView = (ListView) findViewById(R.id.listViewKelasDosen);
                ArrayAdapter arrayAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,listKelas);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),"You clicked number "+( position+1) ,Toast.LENGTH_SHORT).show();
                    }
                });



            } catch (JSONException e) {
                e.printStackTrace();
            }



        }
    }
}
