package com.example.aman_negi.androidglossary;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private ListView listView;
    BottomSheetBehavior bottomSheetBehavior;
    private TextView bottomSheetTxt, bottomSheetHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autocomplete);
        listView = findViewById(R.id.listView);

        bottomSheetTxt = findViewById(R.id.bottom_sheet_txt);
        bottomSheetHead = findViewById(R.id.bottom_sheet_heading);
        View bottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        //keyboard state hidden
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //data
        final String[] head = {"Access Modifier",
                "Activity.onCreate",
                "Android Studio",
                "Assignment Operator",
                "Attributes",
                "Black Box",
                "Boolean",
                "Breakpoint",
                "Button",
                "Call a Method",
                "Camel Case", "" +
                "Cast",
                "So on"};
        final String[] body = {"A computer is a machine that follows a list of instructions called a program. An Android device is a computer, and an app is a program. Inside the device are containers called variables that hold values such as numbers or pieces of text.\n" + "\n" + "An object is a variable that is special in two ways. First, it can contain smaller variables inside it, called the fields of the object. Second, attached to an an object we can have lists of instructions—in effect, little programs—called methods.\n" + "\n" + "There are many classes (types) of objects. Each object of a given class has the same set of fields and methods. For each class, we have to write a definition: a listing of the fields and methods that belong to each object of that class.\n" + "\n" + "The code sample is a definition for a class named Car. Each Car object contains a field named mModel, holding the model number of that particular Car object. Each Car object also has two constructor methods, exactly one of which must be called (executed) when the Car is created. Each constructor puts a value into the mModel field of its newborn Car object, and also calls a method named setup to finish setting up the object.\n" + "\n" + "The class definition specifies an access modifier for each field and method of its class. For example, the constructors of class Car are public: they can be called in the methods of another class of objects in the app. This makes it possible for objects of other classes to create objects of class Car. On the other hand, the mModel field is private: it can be mentioned only within the methods of the class to which it belongs. We say that a field has been encapsulated when its access modifier is private. The setup method is private too, because it is intended for use only by the other methods of this class.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program. Inside the device are containers called variables that hold values such as numbers or pieces of text.\n" + "\n" + "A big variable that can contain smaller variables is called an object. An object can also have lists of instructions attached to it — in effect, little programs — called methods. When we execute the instructions of a method, we say that we are calling the method.\n" + "\n" + "There are many classes of objects, and one class is named Activity. When an app is launched, an object of this class is automatically created, and then one of the object’s methods, named onCreate, is called. The instructions of this method tell the device to create and display a user interface for the app. This interface consists of areas on the screen that display information, and touch-sensitive areas such as buttons.\n" + "\n" + "Other methods of this Activity object are called automatically when the user interface of this app is covered by another app, for example when the phone starts ringing. A final method, onDestroy, is called when the app’s user interface is no longer needed and can be destroyed. onCreate is the first of these lifecycle methods of the Activity object.",
                "Even the simplest Android app comprises dozens of folders and files. Android Studio is a desktop application that lets us compose and edit these files. When we're done, Android Studio will translate them from the language Java into the internal language understood by the Android device (usually a phone or tablet), and will load the finished app onto the device. Android Studio runs on Macintosh, PC, and Linux.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer, and an app is a program.\n" + "\n" + "A variable is a container inside the Android device that holds a value such as a number or a piece of text. Each variable has a name, such as \"x\", \"y\", or \"greeting\".\n" + "\n" + "In the instructions of an app, we tell the device to copy a value into a variable by writing an expression such as the following.\n" + "\n" + "x = 10\n" + "x = y\n" + "greeting = \"Hello\"\n" + "\n" + "The equal sign is called the assignment operator. The expression to its right is the right operand of the assignment operator, and the variable to its left is the left operand. The assignment operator tells the device to copy the value of its right operand into its left operand.\n" + "\n" + "An assignment operator, together with its two operands, is called an assignment expression. Every statement in the language Java ends with a semicolon, so when writing a statement that consists of an assignment expression we would say\n" + "x = 10;",
                "The Extensible Markup Language (XML) is a notation for writing a file containing pieces of information called elements. For example, a file describing the layout of the screen might contain elements representing buttons and images. The start of each element is marked with a tag surrounded by the characters < and >. A small element might consist of nothing but this tag.\n" + "\n" + "An element can have smaller pieces of information called attributes written inside of its initial tag. Each attribute consists of a name and a value. For example, a TextView element might have an attribute whose name is “text” and whose value is “Hello”. We write the name of the attribute on the left, the value on the right, and join them with an equal sign. The value is always enclosed in double quotes.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program. The instructions of an app are divided into sections called methods. When we tell the device to execute a method, we say we are calling the method.\n" + "\n" + "If we know how to call a method, feed information into it, and receive its results, we can treat the method as a black box: something that we can safely use even though we don’t know how it works.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program.\n" + "\n" + "An app can tell a device to manipulate values such as numbers or pieces of text. There are many types of values. For example, numbers with fractions are of type float, and whole numbers (a.k.a. integers) are of type int. There are literally billions of possible values of type int, including the familiar numbers 1, 2, and 3, and an int value might result from many operations, including addition and subtraction.\n" + "\n" + "The boolean type is unusual because there are only two values of this type true: and false. A boolean value might result from the comparison of two numbers. For example, if we check to see if x is equal to y, the type of the result will be boolean and the value of the result will be either true or false. The type is named after the nineteenth century logician George Boole.\n" + "\n" + "A variable is a container inside the device that can contain a value. A boolean variable is a variable that can contain a boolean value. A variable of this type can record the result of a comparison for use later in the app. The name of a boolean variable is conventionally the word “is” followed by an adjective.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program.\n" + "\n" + "After completing each instruction in an app, the Android device goes onto the next one by default. Some instructions, however, direct the device to jump to a different instruction in the list. An instruction can also tell the device to change the contents of a variable, which is a little container that holds a value such as a number or a piece of text.\n" + "\n" + "So now we know two ways in which an app can tell the device to go wrong. The app can tell the device to go off course as the device executes its way through the list of instructions; or it can tell the device to put an incorrect value into a variable. These mistakes are called bugs in the app, and identifying and removing them is called debugging.\n" + "\n" + "One way to debug the app is to look over the device’s shoulder as it executes the app’s instructions one at a time. We would also like to see the contents of the variables and watch the device change these contents at each step. But there’s a problem: the device normally executes a million instructions per second.\n" + "\n" + "To slow the app down by a factor of a million, or even to pause it entirely while we think, we can subject it to the control of a tool called a debugger which is built into Android Studio. The debugger can also show us the contents of the variables, and even lets us change those contents to perform little tests and experiments to find out what has gone wrong.\n" + "\n" + "But it can be very tedious to watch the app execute its instructions, perhaps repeating them millions of times, until we get to the instruction suspected of harboring a bug. To get there faster, we can insert a breakpoint—something like a stop sign or roadblock—at the instruction where we want the device to pause. Then we can let the debugger run the app at full speed, starting at its first instruction, confident that the device will pause for our inspection when it reaches the breakpoint.",
                "A View is a rectangular area on the screen. One type of View is a Button, which displays a piece of text. When touched, a properly configured Button tells the Android device to execute a method — a list of instructions, like a little program.\n" + "\n" + "A Button on the screen is drawn by a Java object inside the Android device. In fact, the Java object is the real Button. But when talking about what the user sees, it’s convenient to refer to the rectangular area on the screen as the “Button”.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer, and an app is a program. Inside the device are containers called variables that hold values such as numbers or pieces of text.\n" + "\n" + "An object is a variable that is special in two ways. First, it can contain smaller variables inside it, called the fields of the object. For example, a MediaPlayer object might contain fields holding the name of the sound file it is playing, the volume level, the current position of the playback in the file, and an indication of whether the file should be played in an infinite loop.\n" + "\n" + "Second, attached to an an object we can have lists of instructions—in effect, little programs—called methods. For example, our MediaPlayer object might have methods named play, pause, and stop. The methods of an object can use the fields inside the object to which they are attached. For example, the play method would need to use all four of our fields.\n" + "\n" + "When we tell the computer to execute a method of an object, we say we are calling the method. For example, we can call the play method of the MediaPlayer to make it execute its instructions for playing a sound file.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program.\n" + "\n" + "We often name the things inside the device with a two-word phrase such as “linear layout” or “main activity”. But our language Java does not permit a space between the two words of a name. When eliminating the space, we capitalize the second word so we can see where one word ends and the next one begins. This typographic convention is called camel case, and it yields many of the words that give Android programming its distinctive flavor: LinearLayout, MainActivity, onClick.",
                "A computer is a machine that follows a list of instructions called a program. An Android device is a computer and an app is a program.\n" + "\n" + "We write expressions such as\n" + "10 + 20\n" + "or\n" + "\"cup\" + \"cake\"\n" + "\n" + "in a the instructions of an app to tell the device to compute values such as 30 or \"cupcake\". There are many types of values: 30 is an integer (a whole number) and \"cupcake\" is a string (a piece of text).\n" + "\n" + "Each expression has a value of a particular type. The value of 10 + 20, for example, is of type integer. In an instruction of an app, we sometimes have an expression of one type where we need to write an expression of a different type. When this happens, we write a cast in front of the expression. The cast is like the mask you wear at a costume ball. It makes the expression appear to be of a different type in the eyes of the surrounding parts of the program.\n" + "\n" + "The cast has no effect on the expression to which it is applied. Under its mask, the value of the expression remains of its original type.",
                "So on"};

        listView.setAdapter(new ArrayAdapter(this, R.layout.row_layout, head));
        autoCompleteTextView.setAdapter(new ArrayAdapter(this, R.layout.row_layout, head));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    bottomSheetHead.setText(head[position]);
                    bottomSheetTxt.setText(body[position]);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            super.onBackPressed();
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }
}
