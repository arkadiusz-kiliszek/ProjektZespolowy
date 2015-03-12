package com.example.mm2.browary;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.example.mm2.browary.R.menu.menu_lista_browarkow;

/**
 * Created by Adrian on 2015-03-11.
 */

public class ListaBrowarkow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_browarkow
        );
        TableLayout tableLayout=(TableLayout)findViewById(R.id.tableLayout1);
        DatabaseHandler db = new DatabaseHandler(this);
        List<Browarek> lista = db.getAllBrowarek();
     /**   Iterator<Browarek> it = lista.iterator();
        Browarek pom = new Browarek();
        TextView tv = (TextView) findViewById(R.id.textView8);
        TextView tv2 = (TextView) findViewById(R.id.textView9);
        while (it.hasNext()) {

            pom = it.next();
            String nazwa = pom._nazwa;
      //      String kraj = pom._kraj;
       //     String woltarz = pom._woltarz;
        //    String ekstrakt = pom._ekstrakt;
            String ocena =Float.toString(pom._ocena);
            tv.setText(nazwa);
            tv2.setText(ocena);
        }
**/
        Iterator<Browarek> it = lista.iterator();
        Browarek pom = new Browarek();
        // outer for loop
        while(it.hasNext()) {
            pom=it.next();
            TableRow row = new TableRow(this);
  //          row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
    //                LayoutParams.WRAP_CONTENT));

                TextView tv0 = new TextView(this);
                tv0.setText(Integer.toString(pom._id));
                row.addView(tv0);
            TextView tv1 = new TextView(this);
            tv1.setText(pom._nazwa);
            row.addView(tv1);
            TextView tv2 = new TextView(this);
            tv2.setText(Float.toString(pom._cena));
            row.addView(tv2);
            TextView tv3 = new TextView(this);
            tv3.setText(pom._ekstrakt+"%");
            row.addView(tv3);
            TextView tv4 = new TextView(this);
            tv4.setText(pom._woltarz+"%");
            row.addView(tv4);
            TextView tv5 = new TextView(this);
            tv5.setText(pom._kraj);
            row.addView(tv5);
            TextView tv6 = new TextView(this);
            tv6.setText(Float.toString(pom._ocena)+"*");
            row.addView(tv6);
            TextView tv7 = new TextView(this);
            tv7.setText(pom._kod);
            row.addView(tv7);

            tableLayout.addView(row);

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(menu_lista_browarkow, menu);
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
}

/**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_szukaj_piwo, menu);
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
**/