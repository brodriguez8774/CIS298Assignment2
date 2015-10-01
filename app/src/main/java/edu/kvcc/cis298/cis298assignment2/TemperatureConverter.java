package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TemperatureConverter extends AppCompatActivity {

    //region Variables

    private RadioGroup mInitialGroup;
    private RadioButton mInitial1Radio;
    private RadioButton mInitial2Radio;
    private RadioButton mInitial3Radio;
    private RadioButton mInitial4Radio;

    private RadioGroup mConvertGroup;
    private RadioButton mConvert1Radio;
    private RadioButton mConvert2Radio;
    private RadioButton mConvert3Radio;
    private RadioButton mConvert4Radio;

    private Button mConvertButton;

    private TextView mConversionTextView;
    private TextView mEquationTextView;

    private static final String TAG = "TemperatureConverter";
    private static final String KEY_INDEX = "index";

    //endregion



    //region Standard Methods

    //endregion



    //region Override Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_temperature_converter);


        // Section which assigns (casts) variables to equivalent entity in xml file.

        // Assigns (casts) variable mConvertButton to an actual button in the xml file.
        mConvertButton = (Button) findViewById(R.id.convert_button);
        // Assigns (casts) 'initial' radio group to an equivalent entities in the xml file.
        mInitialGroup = (RadioGroup) findViewById(R.id.initial_value_group);
        mInitial1Radio = (RadioButton) findViewById(R.id.initial_1_radio);
        mInitial2Radio = (RadioButton) findViewById(R.id.initial_2_radio);
        mInitial3Radio = (RadioButton) findViewById(R.id.initial_3_radio);
        mInitial4Radio = (RadioButton) findViewById(R.id.initial_4_radio);
        // Assigns (casts) 'convert to' radio group to an equivalent entities in the xml file.
        mConvertGroup = (RadioGroup) findViewById(R.id.convert_to_group);
        mConvert1Radio = (RadioButton) findViewById(R.id.convert_1_radio);
        mConvert2Radio = (RadioButton) findViewById(R.id.convert_2_radio);
        mConvert3Radio = (RadioButton) findViewById(R.id.convert_3_radio);
        mConvert4Radio = (RadioButton) findViewById(R.id.convert_4_radio);
        // Assigns (casts) text views to an equivalent entities in the xml file.
        mConversionTextView = (TextView) findViewById(R.id.converstion_text_view);
        mEquationTextView = (TextView) findViewById(R.id.equation_text_view);


        //Section which sets onClickListeners (watches for user action).
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Query to determine which radio buttons have been selected. Stores value as int.
                int selectedInitialId = mInitialGroup.getCheckedRadioButtonId();
                int selectedConvertId = mConvertGroup.getCheckedRadioButtonId();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
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

    //endregion

}
