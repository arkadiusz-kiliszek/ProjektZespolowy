package com.example.mm2.browary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class DodajPiwo extends ActionBarActivity {

    Button buttonDodajOpis;
    Button buttonDodajZdjecie;
    Button buttonOcen;
    Button buttonZeskanuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_piwo);

        buttonDodajZdjecie = (Button)findViewById(R.id.button4);
        buttonDodajOpis = (Button)findViewById(R.id.button5);
        buttonOcen = (Button)findViewById(R.id.button6);
        buttonZeskanuj = (Button)findViewById(R.id.button7);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dodaj_piwo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void dodajOpis(View v) {
        Intent i;

        i = new Intent(this, DodajOpis.class);
        startActivity(i);
    }

    public void dodajZdjecie(View v) {
        Intent i;

        i = new Intent(this, DodajZdjecie.class);
        startActivity(i);
    }

    public void ocenPiwo(View v) {
        Intent i;

        i = new Intent(this, OcenPiwo.class);
        startActivity(i);
    }

    public void zeskanujKod(View v) {
        Intent i;

        i = new Intent(this, ZeskanujKod.class);
        startActivity(i);
    }
}
