package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by brodriguez8774 on 10/1/2015.
 */
public class Conversion {

    //region Variables

    private int initialValueInt;        // Temperature user wants to convert.
    private int convertedValueInt;      // Temperature after conversion.
    private int baseInt;                // Temperature at default value, arbitrarily specified as
                                        // Celsius in this program. Used to help modularize program.
    private int initialGroupInt;        // Holds temperature type of initial value.
    private int convertGroupInt;        // Holds temperature type of converted value.

    //endregion



    //region Constructor

    public Conversion(int initialValue, int initialGroup, int convertGroup)
    {
        setInitialValueInt(initialValueInt);
        setInitialGroupInt(initialGroupInt);
        setConvertGroupInt(convertGroupInt);

        CalculateTemperature();
    }

    //endregion



    //region Properties

    public int getInitialValueInt() {
        return initialValueInt;
    }

    public void setInitialValueInt(int initialValueInt) {
        this.initialValueInt = initialValueInt;
    }

    public int getConvertedValueInt() {
        return convertedValueInt;
    }

    public int getInitialGroupInt() {
        return initialGroupInt;
    }

    public void setInitialGroupInt(int initialGroupInt) {
        this.initialGroupInt = initialGroupInt;
    }

    public int getConvertGroupInt() {
        return convertGroupInt;
    }

    public void setConvertGroupInt(int convertGroupInt) {
        this.convertGroupInt = convertGroupInt;
    }

    //endregion



    //region Private Methods

    /**
     * Converts user's int to base int.
     */
    private void CalculateBase() {
        // If initial is Celsius, set base equal to user input.
        if (initialGroupInt == 1) {
            baseInt = initialValueInt;
        }
        else {
            // If initial is Fahrenheit, convert to Celsius then set as base.
            if (initialGroupInt == 2) {
                baseInt = ((initialValueInt - 32) * 5 / 9);
            }
            else {
                // If initial is Kelvin, convert to Celsius then set as base.
                if (initialGroupInt == 3) {
                    baseInt = (initialValueInt - 273);  // Should be 273.15
                }
                // If initial is Rankin, convert to Celsius then set as base.
                else {
                    baseInt = ((initialValueInt - 491) * 5 / 9);  // Should be 491.67
                }
            }
        }

    }

    /**
     * Converts base int to desired convert to int.
     */
    private void CalculateConvertTo()
    {
        // If desired is Celsius, set convert equal to base.
        if (convertGroupInt == 1) {
            convertedValueInt = baseInt;
        }
        else {
            // If desired is Fahrenheit, convert from base.
            if (convertGroupInt == 2) {
                convertedValueInt = (baseInt * 9 / 5 + 32);
            }
            else {
                // If desired is Kelvin, convert from base.
                if (convertGroupInt == 3) {
                    convertedValueInt = (baseInt + 273);     // Should be 273.15
                }
                // If desired is Rankin, convert from base.
                else {
                    convertedValueInt = ((baseInt + 273) * 9 / 5);   // Should be 273.15
                }
            }
        }

    }

    //endregion



    //region Public Methods

    public void CalculateTemperature()
    {
        CalculateBase();
        CalculateConvertTo();
    }

    //endregion

}
