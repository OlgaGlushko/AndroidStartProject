package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;

public class ComeBackActivity extends AppCompatActivity {

    EditText TextView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back);

        TextView = (EditText) findViewById(R.id. Backtv);
        button = (Button) findViewById(R.id.SendBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ();
                BreakIterator textView;
                intent.putExtra("tv", textView.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}