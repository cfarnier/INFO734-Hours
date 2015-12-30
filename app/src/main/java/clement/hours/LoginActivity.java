package clement.hours;

import android.app.Application;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private App app;
    private Intent point;
    private TextView tv_name;
    private TextView tv_pass;
    private EditText et_name;
    private EditText et_pass;
    private Button b_connect;
    private ColorStateList oldColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
         * Instanciations
         */
        app = (App) getApplication();
        point = new Intent(this, PointActivity.class);

        tv_name = (TextView) findViewById(R.id.name);
        tv_pass = (TextView) findViewById(R.id.pass);
        et_name = (EditText) findViewById(R.id.editName);
        et_pass = (EditText) findViewById(R.id.editPass);
        b_connect = (Button) findViewById(R.id.buttonConnect);

        oldColor = tv_name.getTextColors();

        /*
         * Action du bouton de connexion
         */
        b_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString().equals("") && et_pass.getText().equals("")) {
                    tv_name.setTextColor(Color.RED);
                    tv_pass.setTextColor(Color.RED);
                }

                else if (et_name.getText().toString().equals("")) {
                    tv_name.setTextColor(Color.RED);
                    tv_pass.setTextColor(oldColor);
                }
                else if (et_pass.getText().toString().equals("")) {
                    tv_name.setTextColor(oldColor);
                    tv_pass.setTextColor(Color.RED);
                }
                else {
                    tv_name.setTextColor(oldColor);
                    tv_pass.setTextColor(oldColor);
                    app.addUser(et_name.getText().toString(), et_pass.getText().toString());
                    startActivity(point);
                }
            }
        });
    }
}
