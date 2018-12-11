package com.example.user.imagenes_galeria;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton radioh,radiov, radioa;
    private ImageButton btnalante, btnatras;
    private ImageView imgcaja;
    private int i=0;
    private int totalImagen;
    private int []galeriaId={
            R.drawable.funko,
            R.drawable.funko1,
            R.drawable.funko2,
            R.drawable.funko3,
            R.drawable.funko4,
            R.drawable.funko5,
            R.drawable.funko6,
            R.drawable.funko7,
            R.drawable.funko8,
            R.drawable.funko9,
            R.drawable.funko10,
            R.drawable.funko11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioh = (RadioButton)findViewById(R.id.radioh);
        radiov = (RadioButton)findViewById(R.id.radiov);
        radioa = (RadioButton)findViewById(R.id.radioa);
        imgcaja = (ImageView)findViewById(R.id.imgcaja);
        btnalante = (ImageButton)findViewById(R.id.btnalante);
        btnatras = (ImageButton)findViewById(R.id.btnatras);

        radioh.setOnClickListener(this);
        radiov.setOnClickListener(this);
        radioa.setOnClickListener(this);
        btnalante.setOnClickListener(this);
        btnatras.setOnClickListener(this);

//variable del total de imagenes y la longitud del array
        totalImagen = galeriaId.length;
    }
//evitar reseteo entre horizontal y vertical
    protected void onSaveInstanceState(Bundle bundle) {

        super.onSaveInstanceState(bundle);
        bundle.putInt("key",i);
    }

    protected void onRestoreInstanceState(Bundle bundle){
        super.onRestoreInstanceState(bundle);
        i=bundle.getInt("key");
        imgcaja.setImageResource(galeriaId[i]);
    }

    @Override
    public void onClick(View v) {

        //cambiar imagen dando a los botones
        int id=v.getId();

        if (id==R.id.btnalante){
            i++;
            if(i==totalImagen)
                i=0;
        }
        if (id==R.id.btnatras){
            i--;
            if(i==-1)
                i=totalImagen-1;
        }
        imgcaja.setImageResource(galeriaId[i]);


//switch para cambiar de orientacion

        switch(v.getId()) {

            case R.id.radioh:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                Toast.makeText(getApplicationContext(), "Horizontal", Toast.LENGTH_LONG).show();
                break;
            case R.id.radiov:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                Toast.makeText(getApplicationContext(), "Vertical", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioa:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                Toast.makeText(getApplicationContext(), "Automatico", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
