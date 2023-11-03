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
    public void calculer(View v){
        int age;
        float valeurMesuree;
        boolean verifAge=false;
        boolean verifValeur=false;
        if(sbAge.getProgress()!=0)
            verifAge=true;
        else
            Toast.makeText(MainActivity.this,"saisir votre age",Toast.LENGTH_SHORT).show();
        if (sbValeur.getText().toString().isEmpty())
            verifValeur=true;
        else Toast.makeText(MainActivity.this,"veillez verifier  la valeur mesuree",Toast.LENGTH_LONG).show();
        if (verifAge && verifValeur){
            age=sbAge.getProgress();
            valeurMesuree=Float.valueOf(sbValeur.getText().toString());
            boolean rbtOui= rbIsFasting.isChecked();
            if (rbtOui){
                if (age>=13)
                    if (valeurMesuree<5)
                        tvResultat.setText("niveau de glycemie est bas");
                    else if (valeurMesuree>=5 && valeurMesuree<=7.2) {
                        tvResultat.setText("niveau de glycemie est normale");}
                        else
                            tvResultat.setText("niveau de glycemie est elevee");
                else if (age>6 && age<=12 ) {
                    if (valeurMesuree<5)
                        tvResultat.setText("niveau de glycemie est bas");
                    else if (valeurMesuree>=5 && valeurMesuree<=10) {
                        tvResultat.setText("niveau de glycemie est normale");}
                    else
                        tvResultat.setText("niveau de glycemie est elevee");


                } if (age<6)
                    if (valeurMesuree<5.5)
                        tvResultat.setText("niveau de glycemie est bas");
                    else if (valeurMesuree>=5.5 && valeurMesuree<=10.0)
                        tvResultat.setText("niveau de glycemie est normale");
                        else
                        tvResultat.setText("niveau de glycemie est elevee");


            } else if (valeurMesuree>10.51){
                tvResultat.setText("niveau de glycemie est elevee");}
                else
                tvResultat.setText("niveau de glycemie est normale");

            }
        }
        }

