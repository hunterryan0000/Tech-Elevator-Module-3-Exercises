package com.techelevator.purple.reports;

import com.techelevator.purple.order.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class SalesReporter {
    public static final String SALES_REPORT_FILE = "shopSalesReport.txt";
    public static final String SEPARATOR_CHARACTER = ", ";

    private File outputFile;

    public SalesReporter() {
        this.outputFile = new File(SALES_REPORT_FILE);
    }

    public void writeOrderToReport(Order order){
        try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(outputFile, true))) {
            fileWriter.write("" + order.getOrderNumber() + SEPARATOR_CHARACTER);
            // TODO - write is delivery or pickup
            // TODO - write zipcode
            fileWriter.write(order.getProducts().length + SEPARATOR_CHARACTER);
            // TODO - write tax collected
            // Last item so don't add separator BUT do add an end of the line character
            fileWriter.write(NumberFormat.getCurrencyInstance().format(order.getTotalPrice()) + System.lineSeparator());

        } catch (FileNotFoundException e) {
            System.out.println("Could not find sales report file. Please make sure it exists: " + outputFile.getAbsolutePath());
        }
    }
}
