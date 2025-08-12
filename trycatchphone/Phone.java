package trycatchphone;

import java.util.Scanner;

abstract public class Phone {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private int price;
    String time;
    String os;
    String brand;
    public static float total;

    public Phone() {
    }

    public Phone(String name, int price, String time, String os, String brand) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.os = os;
        this.brand = brand;
    }

    public void input(){
        System.out.printf("Nhập tên điện thoại: ");
        name = TryCatchInt.checkSpecial();
        price = TryCatchInt.inputInt("Nhập giá bán: ");
        total += price;
        System.out.printf("Nhập hệ điều hành: ");
        os = TryCatchInt.checkOS();
        System.out.printf("Nhập hãng: ");
        brand = TryCatchInt.checkSpecial();
    }
    public void output(){
        System.out.printf("Tên: %s || Giá: %d || Hệ điều hành: %s || Hãng: %s ||",name,price,os,brand);
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public abstract String getId();
}
