package biz.arpius.aurkizazu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.widget.Button;

import biz.arpius.aurkizazu.R;
import biz.arpius.aurkizazu.categorias.Ciudad;
import biz.arpius.aurkizazu.categorias.Granja;
import biz.arpius.aurkizazu.categorias.Monte;
import biz.arpius.aurkizazu.categorias.Playa;

public class Categoria extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_categoria);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.categoria, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        Button btnCiudad, btnGranja, btnMonte, btnPlaya;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_categoria, container, false);

            btnCiudad = (Button) rootView.findViewById(R.id.btnCiudad);
            btnGranja = (Button) rootView.findViewById(R.id.btnGranja);
            btnMonte = (Button) rootView.findViewById(R.id.btnMonte);
            btnPlaya = (Button) rootView.findViewById(R.id.btnPlaya);

            Typeface fuente = Typeface.createFromAsset(getActivity().getAssets(), "ComicNoteSmooth.ttf");

            btnCiudad.setTypeface(fuente);
            btnGranja.setTypeface(fuente);
            btnMonte.setTypeface(fuente);
            btnPlaya.setTypeface(fuente);

            btnCiudad.setOnClickListener(this);
            btnGranja.setOnClickListener(this);
            btnMonte.setOnClickListener(this);
            btnPlaya.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnCiudad:
                    startActivity( new Intent(getActivity(), Ciudad.class) );
                    break;
                case R.id.btnGranja:
                    startActivity( new Intent(getActivity(), Granja.class) );
                    break;
                case R.id.btnMonte:
                    startActivity( new Intent(getActivity(), Monte.class) );
                    break;
                case R.id.btnPlaya:
                    startActivity( new Intent(getActivity(), Playa.class) );
                    break;
            }

        }
    }
}
