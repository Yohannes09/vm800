package com.techelevator.vendomatic800;

public class Product {

    private final String vendingIdentifier;
    private final String name;
    private final double price;
    private final String type;
    private int quantity;

    private int amountSold; // this should be static but i'm scared to make changes given our deadline.

    private static int DEFAULT_QUANTITY = 5;

    public Product(String vendingIdentifier, String name, double price, String type){

        this.vendingIdentifier = vendingIdentifier;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = DEFAULT_QUANTITY;
        this.amountSold = 0;
    }


    public void restock(){
        this.quantity = DEFAULT_QUANTITY;
    }

    public void restock(int quantity){
        if(this.quantity + quantity >= DEFAULT_QUANTITY )
            this.quantity = DEFAULT_QUANTITY;
        else
            this.quantity += quantity;
    }

    public void purchase(){

        try {
            // allows for purchasing when 1 item is left
            if(this.quantity - 1 > -1) {
                this.quantity --;
                this.amountSold ++;
            }
            else {
                this.quantity = 0;
                throw new InvalidChoiceException("SOLD OUT");
            }
        } catch (InvalidChoiceException invalidChoiceException) {
            System.err.println(invalidChoiceException.getMessage());
        }
    }


    public String getVendingIdentifier(){
        return this.vendingIdentifier;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getAmountSold(){
        return this.amountSold;
    }

}
