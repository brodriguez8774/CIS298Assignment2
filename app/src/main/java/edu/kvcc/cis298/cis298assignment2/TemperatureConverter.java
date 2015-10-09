package edu.kvcc.cis298.cis298assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText mUserInputEditText;

    // Pointer for strings.xml.
    private int messageResId;
    private int mSelectedInitialId;
    private int mSelectedConvertId;

    // Values to check if user input is present.
    private boolean mInitialGroupChecked;
    private boolean mConvertGroupChecked;
    private boolean mConvertButtonIsClicked;

    // Java's version of static constants.
    private static final String TAG = "TemperatureConverter";
    private static final String KEY_INDEX = "index";

    private boolean[] mCurrentStatus = new boolean[3];

    Conversion conversion;

    //endregion



    //region Standard Methods

    /**
     * Gets the values of user's input and converts.
     * <p>
     * Only use if both groups have been checked and user has input a number to convert.
     */
    private void Convert()
    {
        // Sets user's input to a variable.
        String userInputString = mUserInputEditText.getText().toString().trim();
        Log.d(TAG, "Parsed: " + userInputString);
        double userDouble = Double.parseDouble(userInputString);
        Log.d(TAG, "Parsed: " + userDouble);

        // Query to determine which radio buttons have been selected. Stores value as int.
        mSelectedInitialId = mInitialGroup.getCheckedRadioButtonId();
        mSelectedConvertId = mConvertGroup.getCheckedRadioButtonId();

        int initialGroupSelection = 0;
        int convertGroupSelection = 0;

        if (mSelectedInitialId == mInitial1Radio.getId()) {
            initialGroupSelection = 1;
        }
        else {
            if (mSelectedInitialId == mInitial2Radio.getId()) {
                initialGroupSelection = 2;
            }
            else {
                if (mSelectedInitialId == mInitial3Radio.getId()) {
                    initialGroupSelection = 3;
                }
                else {
                    if (mSelectedInitialId == mInitial4Radio.getId()) {
                        initialGroupSelection = 4;
                    }
                }
            }
        }

        if (mSelectedConvertId == mConvert1Radio.getId()) {
            convertGroupSelection = 1;
        }
        else {
            if (mSelectedConvertId == mConvert2Radio.getId()) {
                convertGroupSelection = 2;
            }
            else {
                if (mSelectedConvertId == mConvert3Radio.getId()) {
                    convertGroupSelection = 3;
                }
                else {
                    if (mSelectedConvertId == mConvert4Radio.getId()) {
                        convertGroupSelection = 4;
                    }
                }
            }
        }

        conversion = new Conversion(userDouble, initialGroupSelection, convertGroupSelection);

        DisplayConversion();
    }

    private void DisplayConversion()
    {
        String initialTemp = String.format("%.2f", conversion.getInitialValueDouble());
        String convertTemp = String.format("%.2f", conversion.getConvertedValueDouble());


        String conversion1String;
        String conversion2String;
        String equation1String;
        String equation2String;

        // Determines what types of strings should display.
        // Combinations for FromCelsius selected.
        if (mSelectedInitialId == mInitial1Radio.getId()) {
            if (mSelectedConvertId == mConvert1Radio.getId()) {
                conversion1String = initialTemp + " C";
                conversion2String = convertTemp + " C";
                equation1String = "[C]";
                equation2String = "[C]";
            }
            else {
                if (mSelectedConvertId == mConvert2Radio.getId()) {
                    conversion1String = initialTemp + " C";
                    conversion2String = convertTemp + " F";
                    equation1String = "[F]";
                    equation2String = "([C] x 9/5) + 32";
                }
                else {
                    if (mSelectedConvertId == mConvert3Radio.getId()) {
                        conversion1String = initialTemp + " C";
                        conversion2String = convertTemp + " K";
                        equation1String = "[K]";
                        equation2String = "[C] + 273.15";
                    }
                    else {
                        conversion1String = initialTemp + " C";
                        conversion2String = convertTemp + " R";
                        equation1String = "[R]";
                        equation2String = "([C] + 273.15) * 9 / 5";
                    }
                }
            }
        }
        else {
            // Combinations for FromFahrenheit selected.
            if (mSelectedInitialId == mInitial2Radio.getId()) {
                if (mSelectedConvertId == mConvert1Radio.getId()) {
                    conversion1String = initialTemp + " F";
                    conversion2String = convertTemp + " C";
                    equation1String = "[C]";
                    equation2String = "([F] - 32) * 5 / 9";
                }
                else {
                    if (mSelectedConvertId == mConvert2Radio.getId()) {
                        conversion1String = initialTemp + " F";
                        conversion2String = convertTemp + " F";
                        equation1String = "[F]";
                        equation2String = "[F]";
                    }
                    else {
                        if (mSelectedConvertId == mConvert3Radio.getId()) {
                            conversion1String = initialTemp + " F";
                            conversion2String = convertTemp + " K";
                            equation1String = "[K]";
                            equation2String = "([F] + 459.67) * 5 / 9";
                        }
                        else {
                            conversion1String = initialTemp + " F";
                            conversion2String = convertTemp + " R";
                            equation1String = "[R]";
                            equation2String = "[F] + 459.67";
                        }
                    }
                }
            }
            else {
                // Combinations for FromKelvin selected.
                if (mSelectedInitialId == mInitial3Radio.getId()) {
                    if (mSelectedConvertId == mConvert1Radio.getId()) {
                        conversion1String = initialTemp + " K";
                        conversion2String = convertTemp + " C";
                        equation1String = "[C]";
                        equation2String = "[K] - 273.15";
                    }
                    else {
                        if (mSelectedConvertId == mConvert2Radio.getId()) {
                            conversion1String = initialTemp + " K";
                            conversion2String = convertTemp + " F";
                            equation1String = "[F]";
                            equation2String = "([K] * 9 / 5) - 459.67";
                        }
                        else {
                            if (mSelectedConvertId == mConvert3Radio.getId()) {
                                conversion1String = initialTemp + " K";
                                conversion2String = convertTemp + " K";
                                equation1String = "[K]";
                                equation2String = "[K]";
                            }
                            else {
                                conversion1String = initialTemp + " K";
                                conversion2String = convertTemp + " R";
                                equation1String = "[R]";
                                equation2String = "[K] * 9 / 5";
                            }
                        }
                    }
                }
                else {
                    // Combinations for FromRankine selected
                    if (mSelectedConvertId == mConvert1Radio.getId()) {
                        conversion1String = initialTemp + " R";
                        conversion2String = convertTemp + " C";
                        equation1String = "[C]";
                        equation2String = "([R] - 491.67) * 5 / 9";
                    }
                    else {
                        if (mSelectedConvertId == mConvert2Radio.getId()) {
                            conversion1String = initialTemp + " R";
                            conversion2String = convertTemp + " F";
                            equation1String = "[F]";
                            equation2String = "[R] - 459.67";
                        }
                        else {
                            if (mSelectedConvertId == mConvert3Radio.getId()) {
                                conversion1String = initialTemp + " R";
                                conversion2String = convertTemp + " K";
                                equation1String = "[K]";
                                equation2String = "[R] * 5 / 9";
                            }
                            else {
                                conversion1String = initialTemp + " R";
                                conversion2String = convertTemp + " R";
                                equation1String = "[R]";
                                equation2String = "[R]";
                            }
                        }
                    }
                }
            }
        }

        String fullConversionString = conversion1String + " = " + conversion2String;
        String fullEquationString = equation1String + " = " + equation2String;

        mConversionTextView.setText(fullConversionString);
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

        // Assigns (casts) 'initial' radio group to equivalent entities in the xml file.
        mInitialGroup = (RadioGroup) findViewById(R.id.initial_value_group);
        mInitial1Radio = (RadioButton) findViewById(R.id.initial_1_radio);
        mInitial2Radio = (RadioButton) findViewById(R.id.initial_2_radio);
        mInitial3Radio = (RadioButton) findViewById(R.id.initial_3_radio);
        mInitial4Radio = (RadioButton) findViewById(R.id.initial_4_radio);
        // Assigns (casts) 'convert to' radio group to equivalent entities in the xml file.
        mConvertGroup = (RadioGroup) findViewById(R.id.convert_to_group);
        mConvert1Radio = (RadioButton) findViewById(R.id.convert_1_radio);
        mConvert2Radio = (RadioButton) findViewById(R.id.convert_2_radio);
        mConvert3Radio = (RadioButton) findViewById(R.id.convert_3_radio);
        mConvert4Radio = (RadioButton) findViewById(R.id.convert_4_radio);

        // Assigns (casts) text views to equivalent entities in the xml file.
        mConversionTextView = (TextView) findViewById(R.id.converstion_text_view);
        mEquationTextView = (TextView) findViewById(R.id.equation_text_view);

        // Assigns (casts) edit text to equivalent entities in the xml file.
        mUserInputEditText = (EditText) findViewById(R.id.user_input_edit_text);

        // Gets saved state for booleans.
        if (savedInstanceState != null) {

            // Loads saved value of initial variables.
            // ...If KEY_INDEX is an index comprised of a string that points to the array, how the
            // heck do use it to point to an index in the array? I'm calling an index within an
            // index? wat.
            mConvertButtonIsClicked = savedInstanceState.getBoolean(KEY_INDEX, false);
            mInitialGroupChecked = savedInstanceState.getBoolean(KEY_INDEX, false);
            mConvertGroupChecked =savedInstanceState.getBoolean(KEY_INDEX, false);

            // Checks to see if user has input a number.
            if (mUserInputEditText.length() > 0) {
                // Checks to see if both groups have been checked, and if convert button has been
                // clicked at least once.
                if (mInitialGroupChecked && mConvertGroupChecked && mConvertButtonIsClicked) {
                    Convert();
                }
            }
        }
        else {
            // Initial variables to store user inputs.
            mConvertButtonIsClicked = false;
            mInitialGroupChecked = false;
            mConvertGroupChecked = false;
        }

        // Section which sets onClickListeners (watches for user action).
        // OnClickListener for Initial Radio Button Group.
        mInitialGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {

                // Debugging to figure out what values are actually given for checked buttons.
                int selectedInitialId = mInitialGroup.getCheckedRadioButtonId();
                int selectedConvertId = mConvertGroup.getCheckedRadioButtonId();
                Log.d(TAG, "Initial Checked ID: " + selectedInitialId);
                Log.d(TAG, "Convert Checked ID: " + selectedConvertId);

                // Checks to see if both groups have been checked, if convert button has been
                // clicked at least once, and user has input a number.
                if (mInitialGroupChecked && mConvertGroupChecked && mUserInputEditText.length() > 0) {
                    Convert();
                } else {
                    mInitialGroupChecked = true;
                }
            }
        });

        // OnCheckChangeListener for Convert To Radio Button Group.
        mConvertGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {

                // Debugging to figure out what values are actually given for checked buttons.
                int selectedInitialId = mInitialGroup.getCheckedRadioButtonId();
                int selectedConvertId = mConvertGroup.getCheckedRadioButtonId();
                Log.d(TAG, "Initial Checked ID: " + selectedInitialId);
                Log.d(TAG, "Convert Checked ID: " + selectedConvertId);


                // Checks to see if both groups have been checked, if convert button has been
                // clicked at least once, and user has input a number.
                if (mInitialGroupChecked && mConvertGroupChecked && mConvertButtonIsClicked
                        && mUserInputEditText.length() > 0) {
                    Convert();
                } else {
                    mConvertGroupChecked = true;
                }
            }
        });

        // OnClickListener for Convert Button.
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Debugging to figure out what values are actually given for checked buttons.
                int selectedInitialId = mInitialGroup.getCheckedRadioButtonId();
                int selectedConvertId = mConvertGroup.getCheckedRadioButtonId();
                Log.d(TAG, "Initial Checked ID: " + selectedInitialId);
                Log.d(TAG, "Convert Checked ID: " + selectedConvertId);

                // Checks to see if user has input a number.
                if (mUserInputEditText.length() > 0) {

                    // Checks to see if both groups have been checked.
                    if (mInitialGroupChecked && mConvertGroupChecked) {
                        mConvertButtonIsClicked = true;
                        Convert();
                    } else {
                        messageResId = R.string.convert_error_2_toast;
                        Toast.makeText(TemperatureConverter.this, messageResId, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    messageResId = R.string.convert_error_1_toast;
                    Toast.makeText(TemperatureConverter.this, messageResId, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");

        // Saves current state booleans.
        mCurrentStatus[0] = mConvertButtonIsClicked;
        mCurrentStatus[1] = mInitialGroupChecked;
        mCurrentStatus[2] = mConvertGroupChecked;

        outState.putBooleanArray(KEY_INDEX, mCurrentStatus);
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
