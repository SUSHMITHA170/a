package com.example.practisecal;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, mul, div, dot, ac;
    EditText result;
    String operatorpressed = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        one = findViewById(R.id.one);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
        result=findViewById(R.id.result);
        ac = findViewById(R.id.ac);
        dot = findViewById(R.id.equal);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        dot.setOnClickListener(this);
        ac.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double finalres = 0.0;
        switch (view.getId()) {
            case R.id.nine:
                result.append("9");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.seven:
                result.append("7");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.plus:
                result.append("+");
                operatorpressed = ("+");
                break;
            case R.id.minus:
                result.append("-");
                operatorpressed = ("-");
                break;
            case R.id.div:
                result.append("/");
                operatorpressed = ("/");
                break;
            case R.id.mul:
                result.append("*");
                operatorpressed = ("*");
                break;
            case R.id.equal:
                finalres = (double) evaluate(result.getText().toString(), operatorpressed);
                result.setText(String.valueOf(finalres));
                break;
            case R.id.ac:
                result.setText(" ");
                break;


        }
    }

    private Object evaluate(String toString, String operatorpressed) {
        String[] tokens;
        tokens = toString.split("\\+|-|\\*|\\/");
        double firstop = Double.parseDouble(tokens[0]);
        double secop = Double.parseDouble(tokens[1]);
        switch (operatorpressed) {
            case "+":
                return firstop + secop;
            case "-":
                return firstop - secop;
            case "*":
                return firstop * secop;
            case "/":
                return firstop / secop;

            default:
            return 0;
        }
    }

}




<TextView
        android:id="@+id/textView"
                android:layout_width="match_parent"
                android:layout_height="93dp"
                android:text="CALCULATOR"
                android:textSize="34sp" />
<EditText
        android:id="@+id/result"
                android:layout_width="match_parent"
                android:layout_height="92dp"
                android:ems="10"
                android:inputType="textPersonName"
                android:text="" />
<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="108dp"
                android:orientation="horizontal">


<Button
            android:id="@+id/nine"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="9" />

<Button
            android:id="@+id/eight"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="8" />

<Button
            android:id="@+id/seven"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="7" />

<Button
            android:id="@+id/ac"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="AC" />


</LinearLayout>

<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="103dp"
                android:orientation="horizontal">


<Button
            android:id="@+id/six"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="6" />

<Button
            android:id="@+id/five"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="5" />

<Button
            android:id="@+id/four"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="4" />

<Button
            android:id="@+id/plus"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="+" />


</LinearLayout>

<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="115dp"
                android:orientation="horizontal">


<Button
            android:id="@+id/three"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="3" />

<Button
            android:id="@+id/two"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="2" />

<Button
            android:id="@+id/one"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="1" />

<Button
            android:id="@+id/minus"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="-" />


</LinearLayout>

<LinearLayout
        android:layout_width="match_parent"
                android:layout_height="89dp"
                android:orientation="horizontal">


<Button
            android:id="@+id/equal"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="=" />

<Button
            android:id="@+id/zero"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="0" />

<Button
            android:id="@+id/mul"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="*" />

<Button
            android:id="@+id/div"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="/" />


</LinearLayout>



