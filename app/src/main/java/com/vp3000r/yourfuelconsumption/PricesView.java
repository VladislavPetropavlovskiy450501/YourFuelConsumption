package com.vp3000r.yourfuelconsumption;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Класс, отвечающий за отображение окна цен на топлива
 */
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
        PricesController prices = new PricesController(this);
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

    /**
     * Метод, проверяющий соединение с интернетом
     * @return true, если соединение есть (тогда нажатие клавиши передается обработчику), false - если подключение отсутствует (тогда появляется сообщение об ошибке)
     */
    public static boolean hasConnection(final Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        return false;
    }
    public void refreshPrices (android.view.View view) {

        if (hasConnection(this)==true) {
            PricesController.refreshPrices();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    showPrices();
                }
            }, 30000);
        }
        else
        {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();

        }
    }
}
