package com.example.samsung.p0541_customadapter;

/**
 * Created by samsung on 07.03.2017.
 */

public class Product {

    String name;
    int price, image;
    boolean box;

    Product (String _describe, int _price, int _image, boolean _box) {
        this.name = _describe;
        this.price = _price;
        this.image = _image;
        this.box = _box;
    }

}
