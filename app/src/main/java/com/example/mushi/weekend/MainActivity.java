package com.example.mushi.weekend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity m = this;


        LinearLayout.LayoutParams paramsRoot = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(paramsRoot);

        LinearLayout.LayoutParams paramsEdt= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        EditText edtUsername = new EditText(m);
        edtUsername.setLayoutParams(paramsEdt);
        layout.addView(edtUsername);

        LinearLayout.LayoutParams paramsBtn= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Button Btnokay = new Button(this);
        Btnokay.setText("Okay");
        Btnokay.setLayoutParams(paramsBtn);
        layout.addView(Btnokay);


        setContentView(layout);

    }
}
