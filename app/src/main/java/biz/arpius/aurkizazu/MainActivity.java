package biz.arpius.aurkizazu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView tituloApp;
    Button btnJugar, btnSalir, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        tituloApp = (TextView) findViewById(R.id.txtTitulo);
        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        Typeface fuente = Typeface.createFromAsset(getAssets(), "ComicNoteSmooth.ttf");

        tituloApp.setTypeface(fuente);
        btnJugar.setTypeface(fuente);
        btnSalir.setTypeface(fuente);
        btnInfo.setTypeface(fuente);

        btnJugar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnJugar:
                startActivity( new Intent(this, Categoria.class) );
                break;
            case R.id.btnInfo:
                startActivity( new Intent(this, Info.class) );
                break;
            case R.id.btnSalir:
                finish();
        }
    }
}
