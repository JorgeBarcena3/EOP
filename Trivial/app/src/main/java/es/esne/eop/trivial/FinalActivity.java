package es.esne.eop.trivial;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends Activity {

    //Boton reiniciar
    Button reiniciar;

    //Texto de ganandor
    TextView winlbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = this.getIntent();

        int contadorPreguntas = intent.getIntExtra("CONTADORPREGUNTAS", 0);
        winlbl = findViewById(R.id.winlbl);
        winlbl.setText("¡Has ganado!" + "\n Con " + contadorPreguntas + " preguntas hechas.");

        reiniciar = findViewById(R.id.play_again);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
