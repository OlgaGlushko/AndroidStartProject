package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {


         private static final String LogcatTaq = "CALCULATOR_ACTIVITY";
         private static final String LifecycleTaq = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTaq, "I'm onCreate(), and i'm started");
        setContentView(R.layout.activity_calculator);

        final Button calculate =(Button) findViewById(R.id.calc);
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
              calculateAnswe();

                Intent i = new Intent( Calculator.this, MainActivity.class); // написать письмо
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

    private void calculateAnswe(){
        EditText numOne =(EditText) findViewById(R.id.editTextNumberDecimal3);
        EditText numTwo =(EditText) findViewById(R.id.editTextNumberDecimal4);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtrackt);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton devide = (RadioButton) findViewById(R.id.devide);

        TextView answer = (TextView) findViewById(R.id.result);

        float numone  = Integer.parseInt(numOne.getText().toString());
        float numtwo  = Integer.parseInt(numTwo.getText().toString());

        float solution = 0;
        if(add.isChecked()) {
            solution = numone + numtwo;
        }

        if(sub.isChecked()) {
            solution = numone - numtwo;
        }

        if(multiply.isChecked()) {
            solution = numone * numtwo;
        }

        if(devide.isChecked()) {
            if(numtwo == 0){
                Toast.makeText( this,"Number two Cannot be zero",Toast.LENGTH_SHORT).show();
                return;
        }
       solution = numone / numtwo;
        }

        answer.setText("The answer is" + solution);

    }
}