package com.techelevator.logs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.techelevator.vendomatic800.Product;

public class Logger {

    private static final String LOG_PATH = "/Users/yohannesmata/module-1-capstone/logs/logs.txt";
    //Shaun's path: "/Users/dashe/OneDrive/Desktop/MeritAmerica/module-1-capstone/logs/logs.txt";
    //private static final String TOTAL_SALES_LOG_PATH = "/Users/yohannesmata/module-1-capstone/logs/totalSales.txt";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy  hh:mm a");
    private static final NumberFormat USD_FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);
    private static double BALANCE;

    public static void logMoneyFed(double transactionAmount){

        BALANCE += transactionAmount;

        try(PrintWriter logger = new PrintWriter(new FileOutputStream(LOG_PATH, true)) ){

            logger.println(String.format("%s  %s: %16s %1s" ,
                    LocalDateTime.now().format(FORMAT) ,
                    "FEED MONEY",
                    USD_FORMATTER.format(transactionAmount),
                    USD_FORMATTER.format(BALANCE)));
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println(fileNotFoundException.getMessage());
        }

    }

    public static void logProductPurchase(Product product){

        BALANCE -= product.getPrice();

        try(PrintWriter logger = new PrintWriter(new FileOutputStream(LOG_PATH, true)) ){

            logger.println(String.format("%s  %-18s  %s %-4s %s",
                    LocalDateTime.now().format(FORMAT),
                    product.getName(),
                    product.getVendingIdentifier(),
                    USD_FORMATTER.format(product.getPrice()),
                    USD_FORMATTER.format(BALANCE)));

        }catch (FileNotFoundException fileNotFoundException){
            System.err.println(fileNotFoundException.getMessage());
        }
    }

    public static void logFinalizedTransactions(){

        try(PrintWriter logger = new PrintWriter(new FileOutputStream(LOG_PATH, true)) ){

            logger.println(String.format("%s  GIVE CHANGE: %15s %s",
                    LocalDateTime.now().format(FORMAT),
                    USD_FORMATTER.format(BALANCE),
                    USD_FORMATTER.format(0)));

            logger.println(String.format("********** Transaction completed %s **********\n" ,
                    LocalDateTime.now().format(FORMAT)));

            BALANCE = 0;

        }catch (FileNotFoundException fileNotFoundException){
            System.err.println(fileNotFoundException.getMessage());
        }
    }

}
