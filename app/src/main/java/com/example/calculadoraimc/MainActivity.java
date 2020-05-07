package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtAltura;
    private EditText edtPeso;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edtAltura    = findViewById(R.id.txtAltura);
        this.edtPeso      = findViewById(R.id.txtPeso);
        this.txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcularImc(View view) {

        float altura     = Float.parseFloat(this.edtAltura.getText().toString());
        float peso       = Float.parseFloat(this.edtPeso.getText().toString());
        float valorFinal = peso/(altura*altura);

        this.txtResultado.setText("Seu IMC é de: "+String.valueOf(valorFinal));
    }
}
