package com.example.textinputlayoutcftic;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText cajatextomail = (EditText)findViewById(R.id.cajamail);
        cajatextomail.setOnFocusChangeListener(new FocusListener(this));
    }
}
