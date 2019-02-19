package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in =new Scanner(new File("numbers.txt"));
        HashTable table1=new HashTable();
        initTable(in,table1);
        Scanner scanfile2=new Scanner(new File("numbers2.txt"));
        HashTable table2=new HashTable();
       initTable(scanfile2,table2);
        Scanner scanfile3=new Scanner(new File("numbers3.txt"));
        HashTable table3=new HashTable();
        initTable(scanfile3,table3);
        Scanner scanfile4=new Scanner(new File("numbers4.txt"));
        HashTable table4=new HashTable();
        initTable(in,table4);
        System.out.print("Введите число:");
        Scanner scan=new Scanner(System.in);
        int number=scan.nextInt();
        testTableMethods(table1,number);
        testTableMethods(table2,number);
        testTableMethods(table3,number);
        testTableMethods(table4,number);
    }
    static void initTable(Scanner in,HashTable table)
    {
        while(in.hasNextLine())
        {
            int number=Integer.parseInt(in.nextLine());
            Node node=new Node(number);
            table.insert(node,false);
        }
    }

    static void testTableMethods(HashTable table,int key)
    {
        Node node=new Node(key);
        System.out.println(table.insert(node,true));
        System.out.println(table.searsh(key,true));
        System.out.println(table.remove(key,true));
    }
}
