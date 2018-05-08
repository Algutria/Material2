package com.holamundo.materialpersonas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersonas extends AppCompatActivity {

    private EditText txtCedula;
    private EditText txtNombre;
    private EditText txtApellido;
    private Spinner cmbSexo;

    private ArrayAdapter<String> adapterSexo;
    private String opcionesSexo[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);

        txtCedula = findViewById(R.id.txtCedula);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        cmbSexo = findViewById(R.id.cmbSexo);

        opcionesSexo = this.getResources().getStringArray(R.array.sexo);
        adapterSexo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesSexo);
        cmbSexo.setAdapter(adapterSexo);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String cedula, nombre, apellido;
        Integer sexo, foto;

        foto = Datos.fotoAleatoria(fotos);
        cedula = txtCedula.getText().toString();
        nombre = txtNombre.getText().toString();
        apellido = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();

        Persona persona = new Persona(foto, cedula, nombre, apellido, sexo);
        persona.guardar();

        Snackbar.make(v, getResources().getString(R.string.guardado_exitoso), Snackbar.LENGTH_SHORT)
              .setAction("Action", null).show();
    }
}
