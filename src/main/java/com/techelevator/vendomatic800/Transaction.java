package com.techelevator.vendomatic800;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/*
* Stores a list of products*/

public class Transaction {

    private List<Product> cart;

    public Transaction(){

        this.cart = new ArrayList<>();
    }


    public void addToCart(Product product){
        this.cart.add(product);
    }

    public void clear(){
        this.cart.clear();
    }

    public double getTransactionAmount(){

        double cartSum = 0;

        for(Product product:this.cart){
            cartSum += product.getPrice();
        }

        return cartSum;
    }

    public void productsPurchased(){
        for(Product product: cart)
            System.out.println(product.getName());

    }

    public List<Product> getCart(){
        return this.cart;
    }

}

