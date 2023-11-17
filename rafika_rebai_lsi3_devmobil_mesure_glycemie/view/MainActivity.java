package com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.Controller.Controller;
import com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.R;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur ;
    private Button btnConsulter;
    private SeekBar sbAge;
    private RadioButton rbIsFasting ,rbIsNotFasting;
    private TextView tvAge,tvResultat;
    private RadioGroup group;

    private Controller controller = new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener seekbar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                Log.i("INFORMATION","onProgressChanged"+progress);
                tvAge.setText("Votre age="+progress);}


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age;
                float valeurMesure;
                boolean verifAge = false;
                boolean verifValeur = false;
                if (sbAge.getProgress() != 0) {
                    verifAge = true;
                } else {
                    //length_show le temps de message
                    Toast.makeText(MainActivity.this, "Veuillez Verifier votre Age", Toast.LENGTH_SHORT).show();
                }
                if (!etValeur.getText().toString().isEmpty()) {
                    verifValeur = true;
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez Verifier le valeur Mesure ", Toast.LENGTH_LONG).show();
                }
                if (verifAge && verifValeur) {
                    age = sbAge.getProgress();
                    valeurMesure = Float.valueOf(etValeur.getText().toString());
                    boolean IsFasting = rbIsFasting.isChecked();
                    //useraction:view to controller
                    controller.create_patient(age,valeurMesure,IsFasting);
                    //update cntroller to view
                    tvResultat.setText(controller.getResult());
                }
            }
        });

    }




    public void init()
    {
        etValeur =(EditText) findViewById(R.id.sbValeur);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        rbIsFasting =(RadioButton) findViewById(R.id.rbtOui);
        rbIsNotFasting =(RadioButton) findViewById(R.id.rbtNon);
        tvAge =(TextView) findViewById(R.id.tvAge);
        tvResultat =(TextView) findViewById(R.id.tvResultat);

    }


}