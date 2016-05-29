package riksameidy.com.latihan_bareng1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DosenAwalMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_awal_menu);
    }

    public void editprofil(View view) {

    }

    public void logout(View view) {

        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
        return;
    }

    public void addkelas(View view) {

    }

    public void pilihkelas(View view) {

    }


}
