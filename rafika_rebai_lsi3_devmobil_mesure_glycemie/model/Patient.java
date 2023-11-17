package com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.model;

import android.icu.util.IslamicCalendar;
import android.view.View;
import android.widget.Toast;

import com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.MainActivity;

public class Patient {
    private String tvResultat;
    private int age;
    private Float valeurMesuree;
    private boolean rbtOui;

    public Patient(int age, Float val, boolean rbtOui) {
        this.rbtOui = rbtOui;
        this.age = age;
        this.valeurMesuree = val;
        calculerNiveauGlycemie();
    }

    public String getResult() {
        return tvResultat;
    }

    public int getAge() {
        return age;
    }

    public float getVal() {
        return valeurMesuree;
    }

    private void calculerNiveauGlycemie() {
        if (rbtOui) {
            {
                if (age >= 13) {
                    if (valeurMesuree < 5)
                        tvResultat = "niveau de glycémie est bas";
                    else if (valeurMesuree >= 5 && valeurMesuree <= 7.2)
                        tvResultat = "niveau de glycémie est normale";
                    else
                        tvResultat = "niveau de glycémie est élevé";
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5)
                        tvResultat = "niveau de glycémie est bas";
                    else if (valeurMesuree >= 5 && valeurMesuree <= 10)
                        tvResultat = "niveau de glycémie est normale";
                    else
                        tvResultat = "niveau de glycémie est élevé";
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvResultat = "niveau de glycémie est bas";
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10)
                        tvResultat = "niveau de glycémie est normale";
                    else
                        tvResultat = "niveau de glycémie est élevé";
                }

                    else
            {
                if (valeurMesuree > 10.5)
                    tvResultat = "niveau de glycémie est élevé";
                else
                    tvResultat = "niveau de glycémie est normale";
            }
        }

    }}}