package com.fenixu.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.fenixu.R;
import com.fenixu.logica_negocio.AdaptadorAgregarNotas;
import com.fenixu.logica_negocio.AdaptadorMateriasNotas;
import com.fenixu.logica_negocio.DialogoAgregarNota;
import com.fenixu.recursos_datos.AdminSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CrearNotasMaterias extends AppCompatActivity implements DialogoAgregarNota.DialogoCrearNotasListener {

    private Toolbar toolbar;
    private ListView lista;

    int cont;

    List<List<String>> itemNotas = new ArrayList<List<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_notas_materias);

        toolbar = (Toolbar)findViewById(R.id.toolbarAgregarNotas);
        setSupportActionBar(toolbar);

        lista = (ListView)findViewById(R.id.listViewAgregarNotas);

        //creamos la cantidad de sublistas necesarios segun las variables.
        if(itemNotas.size()==0){
            for(int i = 0; i < 2; i++) {
                itemNotas.add(new ArrayList<String>());
            }}

        //Abrimos la base de datos para agregar todos los datos de la db a la lista multidimensional.
        /*AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminNotas", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor limiteFor = db.rawQuery("select count(idMateria) from notas", null);

        if(limiteFor.moveToFirst()){
            int limite = limiteFor.getInt(0);
            cont=limite;
            for(int i = 0; i < limite; i++){
                Cursor materia = db.rawQuery("select * from notas where idMateria="+i, null);
                if(materia.moveToFirst()){
                    String temp_nota = notas.getString(0;
                    String temp_porcentaje = materia.getString(1);
                    String temp_idMateria = materia.getString(2);

                    itemMateria.get(0).add(temp_titulo);
                    itemMateria.get(1).add(temp_porcentaje);
                    itemMateria.get(2).add(temp_actual);
                    itemMateria.get(3).add(temp_necesaria);
                    itemMateria.get(4).add(temp_creditos);
                }else{
                    break;
                }
            }
        }else{
            db.close();
        }*/
    }

    //Items del menu superior(agregar, eliminar)
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Metodo que se ejecuta al dar click a los items del menu superior
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.agregar){
            openDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(String nota, String porcentaje) {
        itemNotas.get(0).add(nota);
        itemNotas.get(1).add(porcentaje);

        /*Intent intent = getIntent();
        Bundle b = intent.getExtras();*/

        /*if(b!=null){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminNotas", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            String notaBD = itemNotas.get(0).get(cont);
            String porcentajeBD = itemNotas.get(1).get(cont);

            int idMateria = b.getInt("posicion");

            ContentValues registro = new ContentValues();
            registro.put("nota", notaBD);
            registro.put("porcentaje", porcentajeBD);
            registro.put("idMateria", idMateria);

            db.insert("notas",null,registro);
            db.close();

        cont++;
        }*/
        lista.setAdapter(new AdaptadorAgregarNotas(this, itemNotas));

    }

    //Metodo para abrir la ventana donde se agrega la materia
    public void openDialog(){
        DialogoAgregarNota dcm =  new DialogoAgregarNota();
        dcm.show(getSupportFragmentManager(),"Agregar Nota");
    }
}