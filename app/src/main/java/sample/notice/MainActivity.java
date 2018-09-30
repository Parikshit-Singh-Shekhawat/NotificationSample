package sample.notice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification(v);
            }
        });
    }

    public void createNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        //Intent intent = new Intent(this, NotificationReceiverActivity.class);
        Intent i = new Intent();
        File file=new File(Environment.getExternalStorageDirectory()+"/TxtMe/media/869971135.jpeg");
        Uri photoUri;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
        {
             photoUri =     FileProvider.getUriForFile(this,"sample.notice.file.provider", file);

            //i.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        }
        else
        {
            photoUri=Uri.fromFile(file);


        }
        i.setAction(android.content.Intent.ACTION_VIEW);
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        i.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        i.setDataAndType(photoUri, "image/*");

        NotificationHelper notificationHelper=new NotificationHelper(this);
        notificationHelper.createNotification(i ,"Noew report generated", "New mail from "+file.getAbsolutePath());
//        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), i, 0);
//
//        // Build notification
//        // Actions are just fake
//        Notification noti = new Notification.Builder(this)
//                .setContentTitle("New mail from " + "test@gmail.com")
//                .setContentText("Subject").setSmallIcon(R.mipmap.ic_launcher)
//                .setContentIntent(pIntent)
//                .addAction(R.mipmap.ic_launcher, "Call", pIntent)
//                 .build();
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        // hide the notification after its selected
//        noti.flags |= Notification.FLAG_AUTO_CANCEL;
//
//        notificationManager.notify(0, noti);

    }
    //https://xossip.com/showthread.php?t=1548230&page=23
}
