package com.example.android.firstapp.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealBill;
    double totalBill;
    double tipAmount;
    String tipChoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText bill =(EditText)findViewById(R.id.idEnterCost);
        final Spinner group =(Spinner)findViewById(R.id.idTipAmntSpin);
        Button tip =(Button)findViewById(R.id.idCalculateBttn);
            tip.setOnClickListener(new View.OnClickListener() {
                final TextView result = ((TextView)findViewById(R.id.idTipTotal));
                final TextView totalResult = ((TextView)findViewById(R.id.idTotalCostReturn));
                @Override
                public void onClick(View view) {
                    String holdEditText = "";
                    holdEditText = bill.getText().toString();
                    try {
                        mealBill = Double.parseDouble(holdEditText);
                    } catch (NumberFormatException d){
                        mealBill = 0.00;
                    }
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    tipChoice = group.getSelectedItem().toString();
                    switch (tipChoice) {
                        case "\t5%":
                            tipAmount = mealBill * 0.05;
                            break;
                        case "\t10%":
                            tipAmount = mealBill * 0.10;
                            break;
                        case "\t15%":
                            tipAmount = mealBill * 0.15;
                            break;
                        case "\t20%":
                            tipAmount = mealBill * 0.20;
                            break;
                        case "\t25%":
                            tipAmount = mealBill * 0.25;
                            break;
                        default:
                            tipAmount = mealBill * 0.0;
                    }
                    totalBill = mealBill + tipAmount;
                    result.setText(currency.format(tipAmount));
                    totalResult.setText(currency.format(totalBill));

                }

            });



    }
}
