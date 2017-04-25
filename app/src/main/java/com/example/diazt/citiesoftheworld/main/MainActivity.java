package com.example.diazt.citiesoftheworld.main;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diazt.citiesoftheworld.R;
import com.example.diazt.citiesoftheworld.asyncTask.AsyncCities;
import com.example.diazt.citiesoftheworld.models.IndicatorsPlaces;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CityCallback {

    private Dialog dialog;
    private Map<String, String> queryMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(com.example.diazt.citiesoftheworld.R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.fragment_dialog);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                ImageButton saveBtn = (ImageButton) dialog.findViewById(R.id.saveBtn);
                               saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText input = (EditText) dialog.findViewById(R.id.editT);
                        String name = input.getText().toString();
                        CityValidation cityValidation = new CityValidation(MainActivity.this);
                        cityValidation.validation(name);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public void created(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("query", name);
        new Background().execute(map);
    }

    @Override
    public void noName() {
        Toast.makeText(this, "Escribe una ciudad por favor", Toast.LENGTH_SHORT).show();

    }

    private class Background extends AsyncCities {

        private ProgressDialog progressDialog;


        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(IndicatorsPlaces indicatorsPlaces) {
            progressDialog.dismiss();



            TextView textView = (TextView) findViewById(R.id.king);
            textView.setText(indicatorsPlaces.getKind());
            TextView textView1 = (TextView) findViewById(R.id.countryCode);
            textView1.setText(indicatorsPlaces.getCountryCode());
            TextView textView2 = (TextView) findViewById(R.id.regionName);
            textView2.setText(indicatorsPlaces.getRegionName());
            TextView textView3 = (TextView) findViewById(R.id.countryName);
            textView3.setText(indicatorsPlaces.getCountryName());
            TextView textView4 = (TextView) findViewById(R.id.regionCode);
            textView4.setText(indicatorsPlaces.getRegionCode());
            TextView textView5 = (TextView) findViewById(R.id.canonicalName);
            textView5.setText(indicatorsPlaces.getCanonicalName());

            TextView textView6 = (TextView) findViewById(R.id.lng);
            textView6.setText(String.valueOf(indicatorsPlaces.getLng()));
            TextView textView7 = (TextView) findViewById(R.id.rad);
            textView7.setText(String.valueOf(indicatorsPlaces.getRad()));
            TextView textView8 = (TextView) findViewById(R.id.lat);
            textView8.setText(String.valueOf(indicatorsPlaces.getLat()));







        }
    }


}
