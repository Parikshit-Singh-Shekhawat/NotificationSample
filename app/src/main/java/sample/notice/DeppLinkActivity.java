package sample.notice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by apple on 29/09/18.
 */

public class DeppLinkActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.test);
        Intent intent = getIntent();
        Uri data = intent.getData();

        if (data.getQueryParameter("matchId") != null) {
            textView.setText(data.getQueryParameter("matchId"));
//            finish();
        } else if (data.getQueryParameter("contestId") != null) {
//            Support.showFAQSection(this, data.getQueryParameter("sectionid"));
            textView.setText("Deep link received - " + data.getQueryParameter("contestId"));
//            finish();
        } else {
            textView.setText("Deep link received - " + data);
        }




    }
}
