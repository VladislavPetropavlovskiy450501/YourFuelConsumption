package com.vp3000r.yourfuelconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RefuelView extends AppCompatActivity implements View {

    public void btRefuelLeft(android.view.View view) {
        Intent intent = new Intent(RefuelView.this, PricesView.class);
        startActivity(intent);
    }

    public void btRefuelRight(android.view.View view) {
        Intent intent = new Intent(RefuelView.this, ConsumptionView.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuel_view);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fuels, android.R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

    }


    public void InpL(android.view.View view) {
        ((TextView) findViewById(R.id.editText)).setText("");
        ((TextView) findViewById(R.id.editText2)).setText("Сумма");
    }
    public void InpM(android.view.View view) {
        ((TextView) findViewById(R.id.editText2)).setText("");
        ((TextView) findViewById(R.id.editText)).setText("Количество литров");
    }
    public void InpO(android.view.View view) {
        ((TextView) findViewById(R.id.editText3)).setText("");

    }
    public void InpF(android.view.View view) {
        ((TextView) findViewById(R.id.editText4)).setText("");
    }
}
