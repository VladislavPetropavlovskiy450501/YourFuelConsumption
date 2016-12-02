package com.vp3000r.yourfuelconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ConsumptionView extends AppCompatActivity implements View {

    double fuelCons=7.2, moneyCons=18.45, target=7.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption_view);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.periods, android.R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        ((TextView) findViewById(R.id.textViewFuelC)).setText("" + fuelCons +"л/100км");
        ((TextView) findViewById(R.id.textViewMoneyC)).setText("" + moneyCons);
        ((TextView) findViewById(R.id.textViewTarget)).setText("" + target + "л/100км");
    }

    public void btConsLeft(android.view.View view) {
        Intent intent = new Intent(ConsumptionView.this, RefuelView.class);
        startActivity(intent);
    }

    public void btConsRight(android.view.View view) {
        Intent intent = new Intent(ConsumptionView.this, PricesView.class);
        startActivity(intent);



    }

}
