package com.example.clase_07_04_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtResultado;
    private Button btnMostrar, btnInvertir;
    private EditText etNombre, etCelular;

    private String nombre;
    private  int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innicializarVistas();
        /*configurar al boton para que este pendiente de un evento en pantalla, en este caso el evento de que un usuario haga click al boton
        * parametro de la funsion espera que le mandes tu logica desarrollada que quieres que se aplique cada que el usuario haga click*/
        btnMostrar.setOnClickListener(this);
        btnInvertir.setOnClickListener(this);
    }

    private void innicializarVistas()
    {
        /*inicializamos vistas y referenciamos nuestros componentes visuales diseñados con los atributos o variables que hemos creado*/
        txtResultado = findViewById(R.id.txtResultado);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnInvertir = findViewById(R.id.btnInvertir);
        etNombre = findViewById(R.id.etNombre);
        etCelular = findViewById(R.id.etCelular);
    }
    private void obtenerValores()
    {
        /*Como obtener los datos que el usuario
         * al componente de texto*/
        /*String() -> convierte la cadena de texto del campo referenciado*/
        nombre = etNombre.getText().toString();
        String celularTexto = etCelular.getText().toString();
        /*usar conocimiento de JAVA para parsar una variable*/
        celular = Integer.parseInt(celularTexto);
    }
    private  void mostrarTexto()
    {
        txtResultado.setText("Nombre: "+this.nombre+"\nCelular: "+this.celular);
    }

    private void invertirNumero()
    {
        /*invertir numero
        * 123 -> 321*/
        int resto =0, invertido =0;
        while (this.celular > 0)
        {
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado.setText("Invertido:"+ invertido);
    }

    @Override
    public void onClick(View view)
    {
        /*
        el parametro view es un objeto que recibe la informacion del componente visual que el usuario ha presionado en pantalla
        si presiona el boton invertir view es igual a ese boton y de ese boton u otra vsita pueden obtener informacion como por ejemplo
        el atributo q los identifica como algo unico
         */
        obtenerValores();
        switch (view.getId())
        {
            case R.id.btnMostrar:
                mostrarTexto();
                break;
            case R.id.btnInvertir:
                invertirNumero();
                break;
        }
    }
}