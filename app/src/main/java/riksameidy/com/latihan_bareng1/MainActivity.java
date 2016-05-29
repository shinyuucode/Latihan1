package riksameidy.com.latihan_bareng1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onclickBtnGetStarted(View view) {

        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
        return;
    }


}
