package rafihanif.rhregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "rafihanif.rhregistration.extra.MESSAGE";
    private EditText mMessageNama;
    private EditText mMessageAlamat;
    private EditText mMessageNoHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageNama = (EditText) findViewById(R.id.editNama);
        mMessageAlamat = (EditText) findViewById(R.id.editAlamat);
        mMessageNoHP = (EditText) findViewById(R.id.editNoHP);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String messageNama = mMessageNama.getText().toString();
        String messageAlamat = mMessageAlamat.getText().toString();
        String messageNoHP = mMessageNoHP.getText().toString();
        String[] messages = new String[] {messageNama, messageAlamat, messageNoHP};
        intent.putExtra(EXTRA_MESSAGE, messages);
        startActivity(intent);

    }
}
