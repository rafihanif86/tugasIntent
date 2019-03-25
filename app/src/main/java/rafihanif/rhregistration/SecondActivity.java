package rafihanif.rhregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String[] message = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
        TextView namatextView = (TextView) findViewById(R.id.text_nama);
        TextView alamattextView = (TextView) findViewById(R.id.text_alamat);
        TextView noHPtextView = (TextView) findViewById(R.id.text_noHP);
        namatextView.setText("Nama : " + message[0]);
        alamattextView.setText("Alamat : " + message[1]);
        noHPtextView.setText("No. HP : " + message[2]);
    }

    public void launchShare(View view) {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        TextView namatextView = (TextView) findViewById(R.id.text_nama);
        TextView alamattextView = (TextView) findViewById(R.id.text_alamat);
        TextView noHPtextView = (TextView) findViewById(R.id.text_noHP);
        String messageNama = namatextView.getText().toString();
        String messageAlamat = alamattextView.getText().toString();
        String messageNoHP = noHPtextView.getText().toString();
        String message = messageNama + "\n" + messageAlamat + "\n" + messageNoHP;
        i.putExtra(Intent.EXTRA_SUBJECT, "Biodata");
        i.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(i,"Send to:"));


    }
}
