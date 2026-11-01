package com.example.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Favorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ImageView imageViewPoza = findViewById(R.id.poza_zilnica);
        LinearLayout butonAdauga = findViewById(R.id.buton_adauga);
        LinearLayout butonZilnice = findViewById(R.id.buton_zilnice);

        int[] pozeleMele = {
                R.drawable.poza_1,
                R.drawable.poza_2,
                R.drawable.poza_3,
                R.drawable.poza_4
        };

        int ziuaDinAn = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        int indexPozaZilnica = ziuaDinAn % pozeleMele.length;
        imageViewPoza.setImageResource(pozeleMele[indexPozaZilnica]);

        butonZilnice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorite.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        butonAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorite.this, AdaugaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}