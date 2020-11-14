package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.txtNumeroUno);
        num1 = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
    }

    public void calcular(View v){
        double n1,n2, suma;
        suma =  m1 +´n2 
    }
}
