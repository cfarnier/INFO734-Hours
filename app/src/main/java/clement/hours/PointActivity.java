package clement.hours;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PointActivity extends AppCompatActivity {

    private App app;
    private Intent form;
    private Calendar c;
    private Handler h;
    private SimpleDateFormat df;
    private String formattedDate;

    private FrameLayout fl_point;
    private TextView tv_currentTime;
    private TextView tv_helloUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        getSupportActionBar().hide();

        /*
         * Instanciations
         */
        app = (App) getApplication();
        form = new Intent(this, FormActivity.class);
        h = new Handler();

        fl_point = (FrameLayout) findViewById(R.id.pointLayout);
        tv_currentTime = (TextView) findViewById(R.id.currentTime);
        tv_helloUser = (TextView) findViewById(R.id.helloUser);

        tv_helloUser.setText("Bonjour "+app.getNameUser()+" !");

        /*
         * Méthode Horloge
         */
        h.post(new Runnable() {
            @Override
            public void run() {
                c = Calendar.getInstance();
                df = new SimpleDateFormat("HH:mm:ss");
                formattedDate = df.format(c.getTime());
                tv_currentTime.setText(formattedDate);
                h.postDelayed(this, 1000);
            }
        });

        /*
         * Action "Pointer"
         */
        fl_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
                formattedDate = df.format(c.getTime());
                app.setStartdateSession(formattedDate);
                startActivity(form);
            }
        });

    }
}
