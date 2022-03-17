package com.ivy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_one, edt_two;
    TextView txt_resut;
    Button btn_add, btn_sub, btn_mul, btn_div, btn_round;
    BigDecimal val1 = BigDecimal.ZERO;
    BigDecimal  val2 = BigDecimal.ZERO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_decimal);
        edt_one = (EditText) findViewById(R.id.edt_one);
        edt_two = (EditText) findViewById(R.id.edt_two);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_round = (Button) findViewById(R.id.btn_round);
        txt_resut = (TextView) findViewById(R.id.txt_resut);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_round.setOnClickListener(this);
         txt_resut.setText("0");
    }

    private BigDecimal converttoBigdeicmalString(String val) {
        return new BigDecimal(val);

    }

    private BigDecimal converttoBigdeicmaldouble(double val) {
        return BigDecimal.valueOf(val);

    }


    private BigDecimal addBigdecimal(BigDecimal val1, BigDecimal val2) {
        BigDecimal res = BigDecimal.ZERO;
        res = val1.add(val2);

        return res;

    }

    private BigDecimal roudoff(BigDecimal val2) {
        BigDecimal res = BigDecimal.ZERO;
        MathContext m = new MathContext(2); // 4 precision

        // val2 is rounded using m
        res = val2.round(m);

        return res;

    }

    private BigDecimal subBigdecimal(BigDecimal val1, BigDecimal val2) {
        BigDecimal res = BigDecimal.ZERO;
        res = val1.subtract(val2);

        return res;

    }

    private BigDecimal divBigdecimal(BigDecimal val1, BigDecimal val2) {
        BigDecimal res = BigDecimal.ZERO;
        res = val1.divide(val2, RoundingMode.HALF_UP);

        return res;

    }

    private BigDecimal mulBigdecimal(BigDecimal val1, BigDecimal val2) {
        BigDecimal res = BigDecimal.ZERO;
        res = val1.multiply(val2);

        return res;

    }
    private void init()
    {
        val1 = converttoBigdeicmalString(edt_one.getText().toString());
        val2 = converttoBigdeicmalString(edt_two.getText().toString());

    }


    @Override
    public void onClick(View v) {
        init();
        switch (v.getId()) {

            case R.id.btn_add: {

                if (valid())
                    txt_resut.setText("0");
                    txt_resut.setText(addBigdecimal(val1, val2).toPlainString());
                    break;

            }
            case R.id.btn_sub: {
                if (valid())
                    txt_resut.setText("0");
                    txt_resut.setText("" + subBigdecimal(val1, val2).toPlainString());
                break;
            }
            case R.id.btn_mul: {
                if (valid())
                    txt_resut.setText("0");
                    txt_resut.setText("" + mulBigdecimal(val1, val2).toPlainString());
                break;
            }
            case R.id.btn_div: {
                if (valid())
                    txt_resut.setText("0");
                    txt_resut.setText("" + divBigdecimal(val1, val2).toPlainString());
                break;
            }
            case R.id.btn_round: {
                if (txt_resut.getText().toString() != null && !txt_resut.getText().toString().isEmpty())
                    txt_resut.setText(roudoff(converttoBigdeicmalString(txt_resut.getText().toString())).toPlainString());
                break;
            }


        }
    }

    private boolean valid() {
        boolean isvalid = true;
        if (edt_one.getText().toString() == null && edt_one.getText().toString().isEmpty()) {
            isvalid = false;
            Toast.makeText(this, "Enter value one", Toast.LENGTH_SHORT).show();
        }
        if (edt_two.getText().toString() == null && edt_two.getText().toString().isEmpty()) {
            isvalid = false;
            Toast.makeText(this, "Enter value two", Toast.LENGTH_SHORT).show();
        }
        return isvalid;
    }
}