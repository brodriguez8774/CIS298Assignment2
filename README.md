# Assignment 2 - Temperature Converter

## Author

Brandon Rodriguez

## Description

Create a temperature converter application.
The application should look like the screen shots I have provided.
The application should do the calculation and display the formula that was used to do the calculation.
The calculation of the conversion should take place in a seperate class
The application should handle errors gracefully.
The application should have a different layout for landscape form that looks like the one pictured here.
The application must retain it's information on the screen when rotated to lanscape.

Solution Requirements:

* Seperate class for calculation
* Handle errors gracefully
* Seperate Layout for landscape
* Retain information across rotation

![alt text](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment2a.jpg "Application Portrait Layout")
![alt text](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment2b.jpg "Application Landscape Layout")

### Notes

The book does not cover how to do work with Radio Buttons. I will talk about it as needed in class. If you are stuck or have questions about it, ask.

## Outside Resources Used

http://javatechig.com/android/android-radio-button-example
* Determined the equivalent of OnClickListener for radio buttons.

http://stackoverflow.com/questions/7543835/configure-android-edittext-to-allow-decimals-and-negatives
* Accepting both negative numbers and decimals in user text input.

https://en.wikipedia.org/wiki/Conversion_of_units_of_temperature
* Found all the proper temperature convertions.

http://floating-point-gui.de/languages/java/
http://stackoverflow.com/questions/4885254/string-format-to-format-double-in-java
* Rounding numbers in java.

## Known Problems, Issues, And/Or Errors in the Program

* I can't seem to figure out how to properly use savedInstanceState to keep program status through rotations. I'm pretty sure it's because I'm trying to pass an array of booleans.

* To elaborate, my initial problem is this: the only thing (seemingly) not saved on rotate are the conversion display strings, which are only generated if all booleans come back true true and a button is pressed. I COULD potentially just force the string to display on rotate, but that just delays the issue. IE: to display another, seperate equation, the user will have to click every single group again to trigger the 3 booleans anyways (...at least I think they will? This savedInstanceState logic is confusing). Therefore it's best to either 1) carry over all three booleans or 2) reset the entire program (including button selections) on rotate.

* In an attempt to carry over these three booleans, an array seemed like the only solution. Via debugging, it appears that the array does infact seem to save all appropriate values just before rotate, as intended. However, the problem seems to be in calling them back up in the onCreate method. Getting a saved instance state requires passing the Key_Index string (which points to the value you want to use), and then the "default to if no value" parameter, right? So then to call a specific index of the savedBooleanStateArray, I would need to somehow modify Key_Index to point at a particular index? I think? I don't know...this was confusing enough when passing a single variable, but I can't think of a reasonable way to make this program work with only passing 1.