package com.techelevator.salesReport;

import com.techelevator.vendomatic800.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class SalesReport {

    /*
     *   The format must have '-' rather than '/' because java will confuse it as a hierarchy of subdirectories.
     *
     *   The format needs seconds to gurantee each file is uniquely named.
     *   */

    private static final String DIRECTORY_NAME = "/Users/yohannesmata/module-1-capstone/salesreports/";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy-hh:mm:ss a");
    private static final NumberFormat USD_FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);
    private static final String FILE_NAME = DIRECTORY_NAME + LocalDateTime.now().format(FORMAT);

    public static void generateSalesReport(List<Product> proudcts){

        File newSalesReport = new SalesReport().createNewFile();
        double totalSales = 0;

        try (PrintWriter salesReportWritter = new PrintWriter(newSalesReport) ){

            for(Product product: proudcts){
                salesReportWritter.println(product.getName() + "|" + product.getAmountSold());
                totalSales += product.getPrice() * product.getAmountSold();
            }

            salesReportWritter.println("\n**TOTAL SALES** " + USD_FORMATTER.format(totalSales));

        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("File does not exist");
        }catch (NullPointerException nullPointerException){
            System.err.println("An error occured: " + nullPointerException.getMessage());
        }

    }

    public File createNewFile()  {

        try{
            return Files.createFile(Path.of(FILE_NAME)).toFile();
        }catch (IOException ioException){
            System.err.println("New sales report file could not be created");
        }
        return null;
    }

}
