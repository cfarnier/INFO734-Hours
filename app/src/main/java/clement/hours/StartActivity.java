package clement.hours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Application;
import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    private App app;
    private Timer timer;
    private Intent log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();

        /*
         * Instanciations
         */
        app = (App) getApplication();
        log = new Intent(this, LoginActivity.class);
        timer = new Timer();

        /*
         * Méthode Chargement
         */
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(log);
                finish();
            }
        }, 2000);
    }
}
