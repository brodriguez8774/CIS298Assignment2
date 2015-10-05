package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by brodriguez8774 on 10/1/2015.
 */
public class Conversion {

    //region Variables

    private double initialValueDouble;        // Temperature user wants to convert.
    private double convertedValueDouble;      // Temperature after conversion.
    private double baseDouble;                // Temperature at default value, arbitrarily specified as
                                        // Celsius in this program. Used to help modularize program.
    private int initialGroupInt;        // Holds temperature type of initial value.
    private int convertGroupInt;        // Holds temperature type of converted value.

    //endregion



    //region Constructor

    public Conversion(double initialValue, int initialGroup, int convertGroup)
    {
        setInitialValueDouble(initialValueDouble);
        setInitialGroupInt(initialGroupInt);
        setConvertGroupInt(convertGroupInt);

        CalculateTemperature();
    }

    //endregion



    //region Properties

    public double getInitialValueDouble() {
        return initialValueDouble;
    }

    public void setInitialValueDouble(double initialValueDouble) {
        this.initialValueDouble = initialValueDouble;
    }

    public double getConvertedValueDouble() {
        return convertedValueDouble;
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
            baseDouble = initialValueDouble;
        }
        else {
            // If initial is Fahrenheit, convert to Celsius then set as base.
            if (initialGroupInt == 2) {
                baseDouble = ((initialValueDouble - 32) * 5 / 9);
            }
            else {
                // If initial is Kelvin, convert to Celsius then set as base.
                if (initialGroupInt == 3) {
                    baseDouble = (initialValueDouble - 273.15);
                }
                // If initial is Rankin, convert to Celsius then set as base.
                else {
                    baseDouble = ((initialValueDouble - 491.67) * 5 / 9);
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
            convertedValueDouble = baseDouble;
        }
        else {
            // If desired is Fahrenheit, convert from base.
            if (convertGroupInt == 2) {
                convertedValueDouble = (baseDouble * 9 / 5 + 32);
            }
            else {
                // If desired is Kelvin, convert from base.
                if (convertGroupInt == 3) {
                    convertedValueDouble = (baseDouble + 273.15);
                }
                // If desired is Rankin, convert from base.
                else {
                    convertedValueDouble = ((baseDouble + 273.15) * 9 / 5);
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
