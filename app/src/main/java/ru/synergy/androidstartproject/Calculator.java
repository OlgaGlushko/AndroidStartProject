package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button calculate =(Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswe();

            }
        });
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