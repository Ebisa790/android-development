package com.example.my_first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edtName, edtEmail, edtPhone;
    private RadioGroup radioGroupGender;
    private TextView tvHeader;

    private String selectedCourse = "";
    private final String[] courses = {"Select Course...", "C", "Data structures", "Interview prep", "Algorithms", "DSA with java", "OS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI components with their XML layout IDs
        tvHeader = findViewById(R.id.textview1);
        edtName = findViewById(R.id.edt1);
        edtEmail = findViewById(R.id.edt2);
        edtPhone = findViewById(R.id.edt3);
        radioGroupGender = findViewById(R.id.radioGroup);
        Spinner spinnerCourses = findViewById(R.id.coursesspinner);
        Button btnSubmit = findViewById(R.id.bt1);

        // Set up Spinner Listener & Adapter
        spinnerCourses.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourses.setAdapter(adapter);

        // Set up Submit Button Listener
        btnSubmit.setOnClickListener(v -> submitForm());
    }

    private void submitForm() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();

        // Check selected RadioButton in RadioGroup
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedGenderId);
            gender = selectedRadioButton.getText().toString();
        }

        // Form Validation
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (gender.isEmpty()) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedCourse.isEmpty() || selectedCourse.equals("Select Course...")) {
            Toast.makeText(this, "Please select a course", Toast.LENGTH_SHORT).show();
            return;
        }

        // Display results
        String result = "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Gender: " + gender + "\n" +
                "Course: " + selectedCourse;

        tvHeader.setText(result);
        Toast.makeText(MainActivity.this, "Submitted Successfully:\n" + result, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCourse = courses[position];
        if (position > 0) {
            Toast.makeText(getApplicationContext(), "Selected Course: " + selectedCourse, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        selectedCourse = "";
    }
}
