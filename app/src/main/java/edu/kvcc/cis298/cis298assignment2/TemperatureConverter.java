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

    // Values to check if user input is present.
    private boolean mInitialGroupChecked;
    private boolean mConvertGroupChecked;
    private boolean mInputTextPresent;

    private static final String TAG = "TemperatureConverter";
    private static final String KEY_INDEX = "index";

    //endregion



    //region Standard Methods

    /**
     * Gets the values of user's input and converts.
     * <p>
     * Only use if both groups have been checked and user has input a number to convert.
     */
    private void Convert()
    {
        // Query to determine which radio buttons have been selected. Stores value as int.
        int selectedInitialId = mInitialGroup.getCheckedRadioButtonId();
        int selectedConvertId = mConvertGroup.getCheckedRadioButtonId();

        Conversion conversion = new Conversion(0, selectedInitialId, selectedConvertId);

        DisplayConversion();
    }

    private void DisplayConversion()
    {
        String conversion1String;
        String conversion2String;
        String fullConversionString = conversion1String + " = " + conversion2String;
        mConversionTextView.setText(fullConversionString);

        String equation1String;
        String equation2String;
        String fullEquationString = equation1String + " = " + equation2String;
        mEquationTextView.setText(fullEquationString);
    }

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

        mInitialGroupChecked = false;
        mConvertGroupChecked = false;

        // Section which sets onClickListeners (watches for user action).
        // OnClickListener for Initial Radio Button Group.
        mInitialGroup.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view){
                // Checks to see if both groups have been checked.
                if (mInitialGroupChecked && mConvertGroupChecked) {
                    Convert();
                }
                else {
                    mInitialGroupChecked = true;
                }
            }
        });

        // OnClickListener for Convert To Radio Button Group.
        mConvertGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInitialGroupChecked && mConvertGroupChecked) {
                    Convert();
                }
                else {
                    mConvertGroupChecked = true;
                }
            }
        });

        // OnClickListener for Convert Button.
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInitialGroupChecked && mConvertGroupChecked) {
                    Convert();
                }
                else {

                }
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
