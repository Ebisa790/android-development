package com.example.my_first_project;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView ebba;
    EditText name_edit;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ebba = (TextView) findViewById(R.id.id_1);
        name_edit = (EditText) findViewById(R.id.id_2);
        bt1 = (Button) findViewById(R.id.id_6);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = name_edit.getText().toString();
                Toast.makeText(getApplicationContext(),
                        "hello ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}