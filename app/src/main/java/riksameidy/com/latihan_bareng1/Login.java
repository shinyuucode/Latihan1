package riksameidy.com.latihan_bareng1;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends AppCompatActivity {

    private EditText nimnipTV,passwordTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void klikLogin(View view) {

        nimnipTV = (EditText) findViewById(R.id.nipDiLogin);
        passwordTV = (EditText) findViewById(R.id.passwordDiLogin);

        String nip = nimnipTV.getText().toString();
        String password = passwordTV.getText().toString();
        String type = "login";

        BackgroundWorker b = new BackgroundWorker(this);
        b.execute(type,nip,password);



    }

    public void klikSignUp(View view) {

        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
        finish();
        return;

    }


}
