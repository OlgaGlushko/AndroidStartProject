package ru.synergy.androidstartproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    private static final int REQ_C = 1;

    EditText et;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

     et = (EditText) findViewById(R.id.et);
     tv = (TextView)  findViewById(R.id.tv);

     Button btn = (Button)  findViewById(R.id.button);
     Button btn2 = (Button)  findViewById(R.id.button2);
     Button btn3 = (Button)  findViewById(R.id.button3);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
//TextView textView = (TextView) findViewById(R.id.normal);

//TextView.setText("Text from Java code");
//TextView.setTextColor(Color.RED);



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_OK:
                tv.setText(data.getStringExtra("et"));

        }
    }

    public void onClick(View v) {
        Intent i ;
        witch (v.getId()) ;
            case R.id.button;
                i= new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.button2;
                i= new Intent(This, ToInfActivity.class);
                String eText = et.getText().toString();
                i.putExtra("et", eText);
                startActivity(i);
                break;

            case R.id.button3:
                i= new Intent(This, ComeBackActivity.class);
                startActivityForResult(i, REQ_C);
                break;

        }
    }
}