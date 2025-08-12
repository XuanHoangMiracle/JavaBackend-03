package trycatchphone;

public class OldPhone extends Phone implements Promotion {
    int status;
    int percent;
    String id;
    int countID;

    public OldPhone() {
    }

    public OldPhone(String name, int price, String time, String os, String brand, int status) {
        super(name, price, time, os, brand);
        this.status = status;
        this.id = "DTC" + String.format("%03d", countID++);
    }

    public void input(){
        super.input();
        status = TryCatchInt.chooseInt("Nhập tình trạng pin: ",0,100);
        this.id = "DTC" + String.format("%03d", countID++);
    }
    public void output(){
        id = "DTC" + String.format("%03d", countID);
        super.output();
        System.out.printf("Tình trạng: %d || ",status);
        System.out.printf("ID: %s",id);
    }
    public String getId(){
        return id;
    }
    @Override
    public void promote(double percent) {
        int oldPrice = getPrice();
        double discount = oldPrice * (percent / 100);
        int newPrice = (int)(oldPrice - discount);
        System.out.printf("Đã áp dụng giảm giá %.1f%%: Giá gốc: %d => Giá sau giảm: %d\n", percent, oldPrice, newPrice);
    }
}
