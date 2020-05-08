package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtAltura;
    private EditText edtPeso;
    private TextView txtResultado;
    private TextView txtCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edtAltura    = findViewById(R.id.txtAltura);
        this.edtPeso      = findViewById(R.id.txtPeso);
        this.txtResultado = findViewById(R.id.txtResultado);
        this.txtCategoria = findViewById(R.id.txtCategoria);
    }

    public void calcularImc(View view) {
        if(this.edtAltura.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por gentileza, informe a altura!", Toast.LENGTH_SHORT).show();
        }
        else if(this.edtPeso.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por gentileza, informe o peso!", Toast.LENGTH_SHORT).show();
        } else {

            float altura = Float.parseFloat(this.edtAltura.getText().toString());
            float peso = Float.parseFloat(this.edtPeso.getText().toString());
            float valorFinal = (float) (peso / Math.pow(altura, 2.f));
            DecimalFormat f = new DecimalFormat("##.00");

            if (valorFinal < 18) {
                this.txtCategoria.setText("Abaixo do peso");
            } else if (valorFinal >= 18.5 && valorFinal <= 24.9) {
                this.txtCategoria.setText("Peso normal");
            } else if (valorFinal >= 25 && valorFinal <= 29.9) {
                this.txtCategoria.setText("Excesso de peso");
            } else if (valorFinal >= 30 && valorFinal <= 34.9) {
                this.txtCategoria.setText("Obesidade class. 1");
            } else {
                this.txtCategoria.setText("Obesidade class. 2");
            }
            this.txtResultado.setText("IMC: " + String.valueOf(f.format(valorFinal)));

            this.hideKeyboy(view);
        }
    }

    private void hideKeyboy(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

