package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.tvDisplay);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        String currentText = display.getText().toString();
        if (currentText.equals("0")) {
            display.setText(buttonText);
        } else if (isOperatorPressed) {
            display.setText(buttonText);
            isOperatorPressed = false;
        } else {
            display.append(buttonText);
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        num1 = Double.parseDouble(display.getText().toString());
        isOperatorPressed = true;
    }

    @SuppressLint("SetTextI18n")
    public void onEqualsClick(View view) {
        num2 = Double.parseDouble(display.getText().toString());

        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
            default:
                return;
        }

        display.setText(String.valueOf(result));
        isOperatorPressed = true;
    }

    public void onClearClick(View view) {
        display.setText("0");
        num1 = 0;
        num2 = 0;
        operator = "";
    }
    public void onDecimalClick(View view) {
        String currentText = display.getText().toString();
        if (!currentText.contains(".")) {
            display.append(".");
        }
    }
    public void onCosClick(View view) {
        double value = Double.parseDouble(display.getText().toString());
        double result = Math.cos(Math.toRadians(value));
        display.setText(String.valueOf(result));
    }

    public void onSinClick(View view) {
        double value = Double.parseDouble(display.getText().toString());
        double result = Math.sin(Math.toRadians(value));
        display.setText(String.valueOf(result));
    }

    public void onLogClick(View view) {
        double value = Double.parseDouble(display.getText().toString());
        if (value > 0) {
            double result = Math.log10(value);
            display.setText(String.valueOf(result));
        } else {
            display.setText("Error");
        }
    }

    public void onSqrtClick(View view) {
        double value = Double.parseDouble(display.getText().toString());
        if (value >= 0) {
            double result = Math.sqrt(value);
            display.setText(String.valueOf(result));
        } else {
            display.setText("Error");
        }
    }

}
