package com.vp3000r.yourfuelconsumption;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RefuelView extends AppCompatActivity implements View {

    float litres, cost, fuellevel, odometr;
    boolean inpflag=true, costflag=true, litresflag=true;
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
        Button btnRefuel = (Button) findViewById(R.id.button);

        assert btnRefuel != null;
        btnRefuel.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {

                if (((TextView)findViewById(R.id.editText)).getText().toString().equals(""))
                {
                    litresflag = false;
                    litres=0;
                }
                else
                {
                    litres = Float.valueOf(((TextView)findViewById(R.id.editText)).getText().toString());
                }
                if (((TextView)findViewById(R.id.editText2)).getText().toString().equals(""))
                {
                    costflag = false;
                    cost=0;
                }
                else
                {
                    cost = Float.valueOf(((TextView)findViewById(R.id.editText2)).getText().toString());
                }
                if (((TextView)findViewById(R.id.editText4)).getText().toString().equals(""))
                {
                    inpflag = false;
                }
                else
                {
                    fuellevel = Float.valueOf(((TextView)findViewById(R.id.editText4)).getText().toString());
                }
                if (((TextView)findViewById(R.id.editText3)).getText().toString().equals(""))
                {
                    inpflag = false;
                }
                else
                {
                    odometr = Float.valueOf(((TextView)findViewById(R.id.editText3)).getText().toString());
                }

                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                int fuelkind = spinner.getSelectedItemPosition();

                if (litresflag==true && costflag == true)
                {
                    ((TextView) findViewById(R.id.textView9)).setText("Нельзя ввести количество литров и сумму одновременно");
                }
                else
                {
                    ((TextView) findViewById(R.id.textView9)).setText("");
                    if (inpflag==true && (litresflag==true || costflag == true))
                    {
                        RefuelController refuel = new RefuelController(litres, cost, fuellevel, odometr, fuelkind);
                        btRefuelRight(v);

                    }
                }



                inpflag=true; costflag=true; litresflag=true;


            }


        });
    }






}
