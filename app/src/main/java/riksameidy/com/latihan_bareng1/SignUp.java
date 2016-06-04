package riksameidy.com.latihan_bareng1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class SignUp extends AppCompatActivity {

    private boolean asDosen=false,asMhs = false;

    private EditText nipnimE,namaE,emailE,passwordE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void userDosen(View view) {
        asMhs = false;
        asDosen = true;
        LinearLayout dos = (LinearLayout) findViewById(R.id.kotakDosen);
        LinearLayout mhs = (LinearLayout) findViewById(R.id.kotakMahasiswa);
        TextView dosenTv = (TextView) findViewById(R.id.pilihdosen);
        TextView mhsTv = (TextView) findViewById(R.id.pilihmhs);


        if (dos != null||mhs!=null) {
            dos.setBackgroundColor(getResources().getColor(R.color.backgroundClicked));
            mhs.setBackgroundColor(getResources().getColor(R.color.backgroundUnClicked));
            dosenTv.setTextColor(getResources().getColor(R.color.textClicked));
            mhsTv.setTextColor(getResources().getColor(R.color.textUnClicked));

        }

    }

    public void userMhs(View view) {
        asMhs = true;
        asDosen = false;

        LinearLayout dos = (LinearLayout) findViewById(R.id.kotakDosen);
        LinearLayout mhs = (LinearLayout) findViewById(R.id.kotakMahasiswa);
        TextView dosenTv = (TextView) findViewById(R.id.pilihdosen);
        TextView mhsTv = (TextView) findViewById(R.id.pilihmhs);


        if (dos != null||mhs!=null) {
            mhs.setBackgroundColor(getResources().getColor(R.color.backgroundClicked));
            dos.setBackgroundColor(getResources().getColor(R.color.backgroundUnClicked));
            mhsTv.setTextColor(getResources().getColor(R.color.textClicked));
            dosenTv.setTextColor(getResources().getColor(R.color.textUnClicked));

        }


    }

    public void SignUp(View view) {

        nipnimE = (EditText) findViewById(R.id.nipDiLogin);
        namaE= (EditText) findViewById(R.id.namaDiSignup);
        passwordE = (EditText) findViewById(R.id.passwordDiSignup);
        emailE = (EditText) findViewById(R.id.emailDiSignup);

        String nipnim,nama,password,email;
        nipnim = nipnimE.getText().toString();
        nama = namaE.getText().toString();
        password = passwordE.getText().toString();
        email = emailE.getText().toString();
        String type = "signup";
        BWorker b = new BWorker(this);

        b.execute(type,nipnim,nama,password,email);
    }


    class BWorker extends AsyncTask<String,Void,String> {

        Context context;

        public BWorker(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {

            String type,nipnim,nama,password,email,url;
            type = params[0];
            nipnim = params[1];
            nama = params[2];
            password = params[3];
            email = params[4];
            url = "";

            if(type.equals("DOSEN")){
                url = "";
            }
            else if(type.equals("MAHASISWA")){
                url = "";
            }

            try {
                URL urlSignup = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlSignup.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data =
                        URLEncoder.encode("nipnim","UTF-8")+ "=" + URLEncoder.encode(nipnim,"UTF-8")+
                                "&" +
                                URLEncoder.encode("nama","UTF-8")+ "=" + URLEncoder.encode(nama,"UTF-8")+
                                "&" +
                                URLEncoder.encode("password","UTF-8")+ "=" + URLEncoder.encode(password,"UTF-8")+
                                "&" +
                                URLEncoder.encode("email","UTF-8")+ "=" + URLEncoder.encode(nama,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                StringBuilder sb = new StringBuilder();
                String line = "";

                while((line = bufferedReader.readLine())!=null){
                    sb.append(line);
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
            if(result.equals("Failed")){
                Toast.makeText(context,"Sorry You are Ndut",Toast.LENGTH_LONG);
            }
            else{
                Intent intent = new Intent(context,Login.class);
                context.startActivity(intent);
            }
        }
    }

}
