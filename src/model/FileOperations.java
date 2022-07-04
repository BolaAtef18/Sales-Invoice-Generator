package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import static sun.nio.ch.WindowsAsynchronousFileChannelImpl.writeFile;

public class FileOperations {
    private int No;
    private Date Date;
    private String Customer;
    private double Total;

    public FileOperations(int no, Date date, String customer, double total)
    {
        No = no;
        Date = date;
        Customer = customer;
        Total = total;
    }
    public int getNo(){
        return No;
    }
    public Date getDate(){
        return Date;
    }
    public String getCustomer(){
        return Customer;
    }
    public double getTotal(){
        return Total;
    }
    public String toString(){
        return String.format("",getNo(),getDate(),getCustomer(),getTotal());
    }

    public static void main(String[] args) throws FileNotFoundException {




        ArrayList<InvoiceHeader> InvoiceHeader = new ArrayList<>();
        File csvFile = new File("C:\\Users\\Bola\\Desktop\\test\\test.csv");
        PrintWriter out = new PrintWriter(csvFile);





    }


    private static ArrayList<InvoiceHeader> readFile(String InvoiceHeader, String invoiceHeader) {
        ArrayList list = new ArrayList();

              }


        ArrayList<InvoiceHeader> ArrayList;
    int writeFile(long handle,
    long address,
    int len,
    long offset,
    long overlapped){

    }



}
