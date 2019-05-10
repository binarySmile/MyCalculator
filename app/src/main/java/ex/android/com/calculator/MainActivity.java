package ex.android.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9,
            buttonAdd, buttonDiv, buttonSub, buttonMul,
            buttonPoint, buttonC, buttonCE, buttonEqual;

    EditText inputField, countingField;

    private double value1 = Double.NaN;
    private double value2;
    private char operation;
    private final char ADD = '+';
    private final char SUB = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private final char EQU = '=';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.button_point);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonDiv = (Button) findViewById(R.id.button_divide);
        buttonSub = (Button) findViewById(R.id.button_subtract);
        buttonMul = (Button) findViewById(R.id.button_multiply);
        buttonC = (Button) findViewById(R.id.button_clear);
        buttonCE = (Button) findViewById(R.id.button_delete);
        buttonEqual = (Button) findViewById(R.id.button_equals);
        inputField = (EditText) findViewById(R.id.input_field);
        countingField = (EditText) findViewById(R.id.counting_field);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + "9");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText(inputField.getText() + ".");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                inputField.setText(null);
                countingField.setText(null);
            }
        });

        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.getText().toString();
                if (inputField != null) {
                    inputField.getText().delete(inputField.length() - 1, inputField.length());
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operation = ADD;
                countingField.setText(String.valueOf(value1) + "+");
                inputField.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operation = SUB;
                countingField.setText(String.valueOf(value1) + "-");
                inputField.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operation = MUL;
                countingField.setText(String.valueOf(value1) + "*");
                inputField.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operation = DIV;
                countingField.setText(String.valueOf(value1) + "/");
                inputField.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operation = EQU;
                countingField.setText(countingField.getText().toString() + String.valueOf(value2));
                inputField.setText(null);
                inputField.setText(String.valueOf(value1));
            }
        });
    }

    private void compute() {
        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(inputField.getText().toString());
            switch (operation) {
                case ADD:
                    value1 = value1 + value2;
                    break;
                case SUB:
                    value1 = value1 - value2;
                    break;
                case MUL:
                    value1 = value1 * value2;
                    break;
                case DIV:
                    value1 = value1 / value2;
                    break;
                case EQU:
                    break;
            }
        } else {
            value1 = Double.parseDouble(inputField.getText().toString());
        }
    }
}
