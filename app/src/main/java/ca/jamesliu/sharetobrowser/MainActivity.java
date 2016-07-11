package ca.jamesliu.sharetobrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent launchIntent = getIntent();
        String action = launchIntent.getAction();
        String type = launchIntent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText = launchIntent.getStringExtra(Intent.EXTRA_TEXT);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(sharedText));
                this.startActivity(i);
            } else {
                Toast.makeText(this, "Data not supported.", Toast.LENGTH_SHORT);
            }
        }
    }

}
