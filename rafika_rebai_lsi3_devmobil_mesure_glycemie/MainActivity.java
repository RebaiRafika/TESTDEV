package com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText sbValeur ;
    private Button btnConsulter;
    private SeekBar sbAge;
    private RadioButton rbIsFasting ,rbIsNotFasting;
    private TextView tvAge,tvResultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listener seekbar
        btnConsulter.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                calculer(v);
            }
        });
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
    }
    public void init()
    {
        sbValeur =(EditText) findViewById(R.id.sbValeur);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        rbIsFasting =(RadioButton) findViewById(R.id.rbtOui);
        rbIsNotFasting =(RadioButton) findViewById(R.id.rbtNon);
        tvAge =(TextView) findViewById(R.id.tvAge);
        tvResultat =(TextView) findViewById(R.id.tvResultat);
    }
    public void calculer(View v) {

        }
    }

