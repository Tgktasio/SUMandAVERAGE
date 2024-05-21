package com.example.sumandaverage;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber1, edtNumber2;
    Button btnSum, btnAvg;
    Toast toast;
    double number1, number2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.txtNum1);
        edtNumber2 = findViewById(R.id.txtNum2);
        btnSum = findViewById(R.id.btnSum);
        btnAvg = findViewById(R.id.btnAve);


        computeTotal();

    }


    private boolean validateInput() {
        if (edtNumber1.getText().toString().isEmpty() || edtNumber2.getText().toString().isEmpty()) {
            toast = Toast.makeText(MainActivity.this, "Please Enter a Number ", Toast.LENGTH_LONG);
            toast.show();
            return false;
        } else if (!edtNumber1.getText().toString().matches("\\d+") || !edtNumber2.getText().toString().matches("\\d+")) {
            toast = Toast.makeText(MainActivity.this, "Please Enter valid number", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        return true;
    }

    public void closeActivity() {
        finish();
    }

    public void computeTotal() {
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {
                    number1 = Double.parseDouble(edtNumber1.getText().toString());
                    number2 = Double.parseDouble(edtNumber2.getText().toString());
                    result = number1 + number2;
                    showToasts("SUM: " + result);
                }
            }
        });
        btnAvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {
                    number1 = Double.parseDouble(edtNumber1.getText().toString());
                    number2 = Double.parseDouble(edtNumber2.getText().toString());
                    result = (number1 + number2) / 2;
                    showToasts("AVE: " + result);
                }
            }
        });
    }
    public void closeActivity(View view) {
        // Clear input fields
        edtNumber1.setText("");
        edtNumber2.setText("");
    }

    public void clearAllFields(View view) {
        // Clear all EditText fields
        edtNumber1.getText().clear();
        edtNumber2.getText().clear();
    }


    private void showToasts(String message) {
        toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 100);
        toast.show();
    }
}