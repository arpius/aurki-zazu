package biz.arpius.aurkizazu.categorias;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import biz.arpius.aurkizazu.R;

public class Granja extends ActionBarActivity {

    Context ctx = this;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_granja);

        String[] elementosGranja = getResources().getStringArray(R.array.elementos_granja);

        Collator idioma = Collator.getInstance(Locale.getDefault());
        idioma.setStrength(Collator.PRIMARY);

        List<String> listaGranja = new ArrayList<String>(Arrays.asList(elementosGranja));

        Collections.sort(listaGranja, idioma);

        ArrayAdapter<String> adaptadorGranja = new ArrayAdapter<String>(
                this,
                R.layout.item_granja,
                R.id.txtElementoGranja,
                listaGranja
        );

        final ListView listado = (ListView) findViewById(R.id.lv_granja);
        listado.setAdapter(adaptadorGranja);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int totalElementos = listado.getCount();
                contador++;
                view.setVisibility(View.INVISIBLE);

                if(contador == totalElementos) {
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(ctx);

                    dialogo.setTitle(R.string.title_activity_granja)
                            .setMessage(R.string.encontrado)
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Granja.this.finish();
                                }
                            });

                    dialogo.show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.granja, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
