package com.example.samsung.p0541_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by samsung on 07.03.2017.
 */

public class BoxAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Product> objects;

    BoxAdapter (Context context, ArrayList<Product> products) {
        this.ctx = context;
        this.objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //вернуть количество элементов
    @Override
    public int getCount() {
        return objects.size();
    }
    //вернуть элемент по номеру позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }
    //id-элемента по номеру позиции в списке
    @Override
    public long getItemId(int position) {
        return position;
    }
    //вернуть пунк списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //использовать озданные, но не использованные ранее view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Product product = getProduct(position);
        //заполнить View в пункте списка данными о товаре: наименование, цена, картинка
        ((TextView) view.findViewById(R.id.tvDescr)).setText(product.name);
        ((TextView) view.findViewById(R.id.tvPrice)).setText(product.price + "");
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(product.image);

        CheckBox chBuy = (CheckBox) view.findViewById(R.id.chBuy);
        chBuy.setOnCheckedChangeListener(myCheckChengList);
        //записать номер позиции пункта в списке
        chBuy.setTag(position);
        //дозаполнить данными о товаре: в корзине или нет
        chBuy.setChecked(product.box);
        return view;
    }

    //вернуть товар по номеру позиции
    private Product getProduct(int position) {
        return ((Product) getItem(position));
    }

    //вернуть список товаров в корзине
    ArrayList<Product> getBox() {
        ArrayList<Product> box = new ArrayList<Product>();
        for (Product p : objects) {
            //если продукт в корзине
            if (p.box) {
                box.add(p);
            }
        }
        return box;
    }

    //Обработчик для чекбоксов
    CompoundButton.OnCheckedChangeListener myCheckChengList = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //изменить данные товара: в корзине или нет
            getProduct((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
