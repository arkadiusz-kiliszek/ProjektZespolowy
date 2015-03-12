package com.example.mm2.browary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;


public class DodajPiwo extends ActionBarActivity {

    Button buttonDodajZdjecie;
    Button buttonZeskanuj;
    Button buttonDodaj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_piwo);


        buttonDodajZdjecie = (Button)findViewById(R.id.button4);
        buttonZeskanuj = (Button)findViewById(R.id.button10);
        buttonDodaj = (Button)findViewById(R.id.button7);
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


    public void dodajZdjecie(View v) {
        Intent i;

        i = new Intent(this, DodajZdjecie.class);
        startActivity(i);
    }
    public void dodaj(View v) {
        DatabaseHandler db=new DatabaseHandler(this);
        EditText nazwaTxt = (EditText)findViewById(R.id.editText3);
        EditText cenaTxt = (EditText)findViewById(R.id.editText7);
        EditText ekstraktTxt = (EditText)findViewById(R.id.editText4);
        EditText woltarzTxt = (EditText)findViewById(R.id.editText5);
        EditText krajTxt = (EditText)findViewById(R.id.editText6);
        RatingBar ocenaTxt = (RatingBar)findViewById(R.id.ratingBar);
        EditText kodTxt = (EditText)findViewById(R.id.editText2);

        Browarek bro=new Browarek();
        bro.set_nazwa(nazwaTxt.getText().toString());
        bro.set_cena(Float.parseFloat(cenaTxt.getText().toString()));
        bro.set_ekstrakt(ekstraktTxt.getText().toString());
        bro.set_woltarz(woltarzTxt.getText().toString());
        bro.set_kraj(krajTxt.getText().toString());
        bro.set_ocena(ocenaTxt.getRating());
        bro.set_kod(kodTxt.getText().toString());


        db.addBrowarek(bro);

  //      long id = db.insertRecord(nazwaTxt.getText().toString(),
  //              dateTxt.getText().toString(), courseTxt.getText().toString(),
  //              notesTxt.getText().toString());


        nazwaTxt.setText("");
        cenaTxt.setText("");
        ekstraktTxt.setText("");
        woltarzTxt.setText("");
        krajTxt.setText("");
        kodTxt.setText("");
        Toast.makeText(DodajPiwo.this, "Dodano do bazy",
                Toast.LENGTH_LONG).show();

        Intent i;

        i = new Intent(this, ListaBrowarkow.class);
        startActivity(i);


    }

    public void zeskanujKod(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String barcode;

            barcode = scanResult.getContents();

            EditText etBarcode = (EditText) findViewById(R.id.editText2);

            etBarcode.setText(barcode);

        }

    }

}
