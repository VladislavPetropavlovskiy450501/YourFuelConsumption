package com.vp3000r.yourfuelconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PricesView extends AppCompatActivity implements View {




    public void btPrLeft(android.view.View view) {
        Intent intent = new Intent(PricesView.this, ConsumptionView.class);
        startActivity(intent);
    }

    public void btPrRight(android.view.View view) {
        Intent intent = new Intent(PricesView.this, RefuelView.class);
        startActivity(intent);
    }

    public void showPrices()
    {

        PricesController prices = new PricesController();
        ((TextView) findViewById(R.id.textView92)).setText("" + prices.ai92);
        ((TextView) findViewById(R.id.textView95)).setText("" + prices.ai95);
        ((TextView) findViewById(R.id.textViewDT)).setText("" + prices.dt);
        ((TextView) findViewById(R.id.textViewDTA)).setText("" + prices.dtarctic);
        ((TextView) findViewById(R.id.textViewGas)).setText("" + prices.gas);
        ((TextView) findViewById(R.id.textViewAB)).setText("" + prices.adblue);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices_view);
        showPrices();
    }

    public void refreshPrices (android.view.View view) {
        PricesController.refreshprices();
        showPrices();
    }
}
