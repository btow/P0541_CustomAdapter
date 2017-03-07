package com.example.samsung.p0541_customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //создать адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        //настроить список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    //генерация данных для адаптера
    private void fillData() {
        for (int i = 1; i < 20; i++) {
            products.add(new Product("Product " + i, i * 1000, R.mipmap.ic_launcher, false));
        }
    }

    //вывод информации о "корзине"
    public void showResult(View view) {
        String result = getString(R.string.product_in_box);
        for (Product p :
                boxAdapter.getBox()) {
            if (p.box) result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

    }
}
