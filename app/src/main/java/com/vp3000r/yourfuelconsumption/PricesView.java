package com.vp3000r.yourfuelconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PricesView extends AppCompatActivity implements View {

    double ai92=1.11, ai95=1.19, dt=1.23, dtarctic=1.38, gas=0.63, adblue=0.65;


    public void btPrLeft(android.view.View view) {
        Intent intent = new Intent(PricesView.this, ConsumptionView.class);
        startActivity(intent);
    }

    public void btPrRight(android.view.View view) {
        Intent intent = new Intent(PricesView.this, RefuelView.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices_view);
        ((TextView) findViewById(R.id.textView92)).setText("" + ai92);
        ((TextView) findViewById(R.id.textView95)).setText("" + ai95);
        ((TextView) findViewById(R.id.textViewDT)).setText("" + dt);
        ((TextView) findViewById(R.id.textViewDTA)).setText("" + dtarctic);
        ((TextView) findViewById(R.id.textViewGas)).setText("" + gas);
        ((TextView) findViewById(R.id.textViewAB)).setText("" + adblue);
    }
}
