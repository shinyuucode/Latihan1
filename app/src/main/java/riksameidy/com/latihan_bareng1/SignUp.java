package riksameidy.com.latihan_bareng1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private boolean asDosen=false,asMhs = false;

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
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
        return;
    }
}
