package com.example.ejemplocomunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private final String TAG = MainActivity2.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i(TAG, "Nueva actividad");


        Intent i = getIntent();
        Log.i(TAG, "recogido intent");

        Bundle extras = i.getExtras();
        Log.i(TAG, "recogido extras");

        // Este bloque comprueba todos los extras del intent (si no es null)
        /*
        if (extras != null) {
            for (String key : extras.keySet()) {
                Log.e(TAG, key + " : " + (extras.get(key) != null ? extras.get(key) : "NULL"));
            }
        }
        */

        String mensaje = extras.get("MENSAJE").toString();
        Log.i(TAG, "El mensaje recibido es... " + mensaje);

    }

    public void responder(View view) {
        Intent i_respuesta = new Intent();
        EditText et = findViewById(R.id.et_respuesta);
        i_respuesta.putExtra("RESPUESTA",et.getText());
        setResult(RESULT_OK,i_respuesta);
        finish();
    }
}