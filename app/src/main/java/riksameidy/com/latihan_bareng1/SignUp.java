package riksameidy.com.latihan_bareng1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void userDosen(View view) {
    }

    public void userMhs(View view) {
    }

    public void SignUp(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
        return;
    }
}
