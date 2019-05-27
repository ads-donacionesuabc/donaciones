package com.example.donaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class CalificaDonante extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar_donante);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar2);
        Button calificarButton = (Button) findViewById(R.id.calificar);

        calificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double cal = ratingBar.getRating(); /*esto es para leer la calificacion*/
                finish();
            }
        });
    }


}
