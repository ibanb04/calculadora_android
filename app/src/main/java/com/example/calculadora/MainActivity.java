package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView resultado;
    private Spinner combo;
    private  String opciones[];
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.txtNumeroUno);
        num2 = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
        combo = findViewById(R.id.spnOpciones);

        opciones = getResources().getStringArray(R.array.operaciones);
        adapter = new ArrayAdapter<>(  this, android.R.layout.simple_spinner_item,opciones);
        combo.setAdapter(adapter);
    }

    public void calcular(View v){
        double n1,n2, res = 0;
        int op;
       if(validar()){
        n1 = Double.parseDouble(num1.getText().toString());
        n2 = Double.parseDouble(num2.getText().toString());
        op = combo.getSelectedItemPosition();
        switch (op){
            case 0:
                res = n1 + n2;
                break;
            case 1:
                res = n1 - n2;
                break;
            case 2:
                res = n1 * n2;
            case 3:
                res = n1 / n2;
                break;

        }

       // res = n1 + n2;
        resultado.setText(String.format("%.2f", res));
        //resultado.setText(String.value0f(suma));
       }
    }

    public boolean validar(){
        int op = combo.getSelectedItemPosition();
        if(num1.getText().toString().isEmpty()){
            num1.setError(getString(R.string.mensaje_error_1));
            num1.requestFocus();
            return false;
        }
        if(num2.getText().toString().isEmpty()){
            num2.setError(getString(R.string.mensaje_error_2));
            num2.requestFocus();
            return false;
        }
        double n2 = Double.parseDouble(num2.getText().toString());
        if (n2 == 0 && op == 3){
            num2.setError(getString(R.string.error_division_cero));
            num2.requestFocus();
            return  false;
        }

        return  true;
    }

    public void limpiar (View v){
        num1.setText("");
        num2.setText("");
        resultado.setText("");
        num1.requestFocus();
        combo.setSelection(0);
    }
}
