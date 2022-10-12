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
        RadioButton divide = (RadioButton) findViewById(R.id.devide);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTaq,msg: "All views have "been founded");

     //           try {
      //              int a= 25/0;

      //          } catch (ArithmeticException e){
     //               e.printStackTrace();
     //           }
        float numtwo = 0;
        float numone = 0;
        String num1  = numOne.getText().toString());
        String num2 = numTwo.getText().toString());
       if(!num1.equals("")&& num1 != null){
            numone = Integer.parseInt(numOne.getText().toString());
       }
        if(!num2.equals("")&& num2 != null){
            numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogcatTaq,msg:"Successfully grabbed data from input fields");
        Log,d(LogcatTaq,msg: "numone is: " + numone  +";"+" numtwo is :" + numtwo);

        float solution = 0;

        if(add.isChecked()) {
            Log.d(LogcatTaq.msg:"Operation is add");
            solution = numone + numtwo;
        }

        if(sub.isChecked()) {
            Log.d(LogcatTaq.msg:"Operation is sub");
             solution = numone - numtwo;
        }

        if(multiply.isChecked()) {
            Log.d(LogcatTaq.msg:"Operation is multiply");
            solution = numone * numtwo;
        }

        if(divide.isChecked()) {
            Log.d(LogcatTaq.msg:"Operation is divide");
            if(numtwo == 0){
                Toast.makeText( this,"Number two Cannot be zero",Toast.LENGTH_SHORT).show();
                return;
        }
       solution = numone / numtwo;
        }
            Log.d(LogcatTaq.msg:"The result of operations is:"+ solution);

        answer.setText("The answer is" + solution);

    }
}