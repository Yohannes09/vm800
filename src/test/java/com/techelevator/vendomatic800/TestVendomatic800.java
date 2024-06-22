package com.techelevator.vendomatic800;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.IOException;

import com.techelevator.vendomatic800.Vendomatic800;
import com.techelevator.vendomatic800.Product;
import com.techelevator.vendomatic800.Transaction;


public class TestVendomatic800 {

    private Vendomatic800 vendomatic;
    private Transaction transaction;


    @BeforeEach
    public void setUp() throws IOException {
        vendomatic = new Vendomatic800();
        transaction = new Transaction();
    }

    @Test
    public void validCurrency_validates_different_amounts(){
        Assert.assertEquals(true, vendomatic.validCurrency(5));
        Assert.assertEquals(true, vendomatic.validCurrency(10));
        Assert.assertEquals(true, vendomatic.validCurrency(1));
        Assert.assertEquals(true, vendomatic.validCurrency(20));
        Assert.assertEquals(false, vendomatic.validCurrency(15));
        Assert.assertEquals(false, vendomatic.validCurrency(55));
        Assert.assertEquals(false, vendomatic.validCurrency(53));
    }

    //@Test
//    public void vendomaticCreateProduct(){
//        Vendomatic800 vm800 = new Vendomatic800();
//        vm800.readInventory(vendomaticAssert.assertEquals(vm800.createProduct(new Product("A1","Potato chips", 3.05, "Chi" )), vm800.getProduct("D4"));
//    }//A1|Potato Crisps|3.05|Chip

    //@Test
    public void testReadInventory() {
        //Arrange
        vendomatic.readInventory();

        //Assert
//        assertEquals(4, vendomatic.getProductList().size());
//        assertEquals("A1", vendomatic.getSlotIdentifier().get("0"));
//        assertEquals("B1", vendomatic.getSlotIdentifier().get("1"));
//        assertEquals("C1", vendomatic.getSlotIdentifier().get("2"));
//        assertEquals("D1", vendomatic.getSlotIdentifier().get("3"));

    }

    @Test
    public void testFeedMoney() {
        //Arrange
        vendomatic.feedMoney();

        //Assert

    }


}
