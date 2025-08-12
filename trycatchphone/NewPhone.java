package trycatchphone;

import java.util.Scanner;

public class NewPhone extends Phone {
    Scanner scanner = new Scanner(System.in);
    int quantity;
    String id;
    int countID;
    public NewPhone() {
    }

    public NewPhone(String name, int price, String time, String os, String brand, int quantity,String id) {
        super(name, price, time, os, brand);
        this.quantity = quantity;
        this.id = "DTM" + String.format("%03d", countID++);
    }

    public void input(){
        super.input();
        quantity = TryCatchInt.inputInt("Nhập số lượng: ");
        this.id = "DTM" + String.format("%03d", countID++);
    }
    public void output(){
        id = "DTM" + String.format("%03d", countID);
        super.output();
        System.out.printf("Số lượng: %d || ",quantity);
        System.out.printf("ID: %s",id);
    }
    public String getId(){
        return id;
    }
}
