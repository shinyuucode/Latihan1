package riksameidy.com.latihan_bareng1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    final

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void klikLogin(View view) {

        Intent intent = new Intent(this,MenuDosen.class);
        startActivity(intent);
        finish();
        return;


    }

    public void klikSignUp(View view) {

        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
        finish();
        return;

    }
}
