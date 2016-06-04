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
        


    }


}
