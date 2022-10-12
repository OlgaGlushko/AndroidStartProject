package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Calculator extends AppCompatActivity {


    private static final String LogcatTaq = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTaq = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTaq, "I'm onCreate(), and i'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        // context training
        //      TextView textView = new TextView(this);
        //      ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext());

        // доступ из класса активити- наследник контекст
        //    getSystemService(LAYOUT_INFLATER_SERVICE);

        //Shared prefs доступ с использованием  контекста приложения
        //  SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        ////


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTaq, "Button have been pushed");
                try {
                    calculateAnswe();
                } catch (Exception e) {

                    //прерывание
              // e.printStrackTrace();
             //       Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
              //      finish();


                //восстановление
                e.printStackTrace();
                Toast.makeText(Calculator.this, e.getMessage(), Toast.LENGTH_LONG).show();
                dropFields();
            }
                Intent i = new Intent(Calculator.this, MainActivity.class); // написать письмо
                startActivity(i);// отправить его


            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTaq, "I'm onStart(), and i'm started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTaq, "I'm onStop(), and i'm started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTaq, "I'm onDestroy(), and i'm started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTaq, "I'm onPause(), and i'm started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTaq, "I'm onResume(), and i'm started");
    }
private void dropFields(){

}


    private void calculateAnswe() throws ArithmeticException, IOException {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal3);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal4);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtrackt);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.devide);

        numOne.setText("0");
        numTwo.setText("0");
        add.setChecked(true);

        TextView answer = (TextView) findViewById(R.id.result);

        answer.setText("Now we have problems, try again later");
    }

        private void calculateAnswe() throws ArithmeticException, IOException {
            EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal3);
            EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal4);

            RadioButton add = (RadioButton) findViewById(R.id.add);
            RadioButton sub = (RadioButton) findViewById(R.id.subtrackt);
            RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
            RadioButton divide = (RadioButton) findViewById(R.id.devide);

            numOne.setText("0");
            numTwo.setText("0");
            add.setChecked(true);

            TextView answer = (TextView) findViewById(R.id.result);


        Log.d(LogcatTaq, "All views have been founded");


        float numtwo = 0;
        float numone = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();
        if (!num1.equals("") && num1 != null) {
            numone = Integer.parseInt(numOne.getText().toString());
        }
        if (!num2.equals("") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }
        Log.d(LogcatTaq, "Successfully grabbed data from input fields");
        Log.d(LogcatTaq, "numone is: " + numone + " ; " + " numtwo is :" + numtwo);

        float solution = 0;

        if (add.isChecked()) {
            Log.d(LogcatTaq, "Operation is add");
            solution = numone + numtwo;
        }

        if (sub.isChecked()) {
            Log.d(LogcatTaq, "Operation is sub");
            solution = numone - numtwo;
        }

        if (multiply.isChecked()) {
            Log.d(LogcatTaq, "Operation is multiply");
            solution = numone * numtwo;
        }

        if (divide.isChecked()) {
            Log.d(LogcatTaq, "Operation is divide");
            if (numtwo == 0) {
                Toast.makeText(this, "Number two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }
        Log.d(LogcatTaq, "The result of operations is:" + solution);

        answer.setText("The answer is" + solution);

        switch ((int) (Math.random() * 3)) {
            case 0:
                throw new ArithmeticException("I am generated arithmetical exception");
            case 1:
                throw new IOException("i am generated ioexception exception");

        }
    }
}