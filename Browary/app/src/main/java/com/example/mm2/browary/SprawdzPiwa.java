package com.example.mm2.browary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SprawdzPiwa extends ActionBarActivity {

    Button buttonSzukaj;
    Button buttonZeskanuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprawdz_piwa);

        buttonSzukaj = (Button)findViewById(R.id.button8);
        buttonZeskanuj = (Button)findViewById(R.id.button9);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sprawdz_piwa, menu);
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

    public void szukajPiwo(View v) {
        Intent i;

        i = new Intent(this, SzukajPiwo.class);
        startActivity(i);
    }

    public void zeskanujKod(View v) {
        Intent i;

        i = new Intent(this, ZeskanujKod.class);
        startActivity(i);
    }
}
