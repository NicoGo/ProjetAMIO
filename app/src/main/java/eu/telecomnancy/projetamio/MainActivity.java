package eu.telecomnancy.projetamio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton button1;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Création de l'activité");


        this.button1 = (ToggleButton) findViewById(R.id.button1);
        this.tv2 = (TextView) findViewById(R.id.TV2);
        this.checkBox = (CheckBox) findViewById(R.id.checkBox);
        final Intent intent = new Intent(getApplicationContext(), MainService.class);

        /*
            Checkbox shared preference
         */

        sharedPreferences = getBaseContext().getSharedPreferences("checkbox", MODE_PRIVATE);

        Boolean parameter =  sharedPreferences.getBoolean("checkbox", false);
        if (parameter != null) {
            if (parameter == true) {
                tv2.setText("démarré");
                checkBox.setChecked(true);
            }
        } else {};


        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    startService(intent);
                    tv2.setText("démarré");
                }

                else {
                    stopService(intent);
                    tv2.setText("arrêté");
                }
            }

        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.d("MainActivity","CheckBox activée");

                }
                else {
                    Log.d("MainActivity","CheckBox désactivée");
                };


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("checkbox", b);
                editor.apply();
            }
        });


    }



    protected void onDestroy() {
        super.onDestroy(); }
    protected void onPause() {
        super.onPause(); }
    protected void onResume() {
        super.onResume(); }
}
