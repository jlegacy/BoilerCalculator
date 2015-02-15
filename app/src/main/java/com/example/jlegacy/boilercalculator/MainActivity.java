package com.example.jlegacy.boilercalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import java.util.ArrayList;

import java.math.BigDecimal;



public class MainActivity extends ActionBarActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.calcButton);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                FireTubeObject myObject;

                InputObject myInputs = new InputObject();

                EditText edit_text = (EditText) findViewById(R.id.Diameter_of_Boiler_Inches);
                myInputs.diameterOfBoiler = Double.parseDouble(edit_text.getText().toString());

                edit_text = (EditText) findViewById(R.id.Diameter_of_FireTube_Inches);
                myInputs.diameterOfFiretube = Double.parseDouble(edit_text.getText().toString());

                edit_text = (EditText) findViewById(R.id.Height_of_FireTube_Inches);
                myInputs.heightOfFiretube = Double.parseDouble(edit_text.getText().toString());

                IFireTubeObject myFireTubeObject  = new GraphicDecorator(new BaseFireTube());

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int x = metrics.widthPixels;


                FireTubeObject myFireTubes = myFireTubeObject.createFireTubeObject(myInputs);


                DisplayFireTubes(myFireTubes);

            }

        });

    }

    public void DisplayFireTubes(FireTubeObject obj)
    {

        EditText edit_text;

        edit_text = (EditText) findViewById(R.id.Clearance_Between_Firetubes_Inches);
        edit_text.setText(String.valueOf((obj.clearanceDimension)));

        edit_text = (EditText) findViewById(R.id.Distance_Between_Firetube_Centers_Inches);
        edit_text.setText(String.valueOf(obj.fireTubeDistanceBetweenCenters));

        edit_text = (EditText) findViewById(R.id.Working_Surface_Square_Inches_per_of_Total);
        edit_text.setText(String.valueOf(obj.workingHeatSquareInches));

        edit_text = (EditText) findViewById(R.id.Total_Heating_Surface_Square_Inches);
        edit_text.setText(String.valueOf(obj.totalHeatSquareInches));

        edit_text = (EditText) findViewById(R.id.Length_of_Tube);
        edit_text.setText(String.valueOf(obj.totalLengthTubeFeet));

        edit_text = (EditText) findViewById(R.id.Number_of_Firetubes);
        edit_text.setText(String.valueOf(obj.numberOfFireTubes));

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
