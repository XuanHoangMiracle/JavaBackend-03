package trycatchphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {
    static ArrayList<Phone> phone = new ArrayList<>();
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int choose;
            while (true) {
                System.out.println("===== Màn Hình Menu Chính =====\nCHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI");
                System.out.println("1. Xem danh sách điện thoại");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp theo giá");
                System.out.println("6. Tìm kiếm");
                System.out.println("7. Tính tổng tiền");
                System.out.println("8. Giảm giá cho điện thoại cũ");
                System.out.println("9. Thoát chương trình!");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,9);

                switch (choose) {
                    case 1:
                        menuShowList();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        update(phone);
                        break;
                    case 4:
                        deletePhone(phone);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println("Giá: "+ Phone.total);
                        break;
                    case 8:
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            }
    }
    private static void menuShowList() {
        int choose;
        while (true) {
//            Scanner scanner = new Scanner(System.in);
                System.out.println("===== Màn Hình 1 =====\nDANH SÁCH ĐIỆN THOẠI");
                System.out.println("1. Tất cả điện thoại");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn",1,4);

                switch (choose) {
                    case 1:
                        if (phone.isEmpty()) {
                            System.out.println("Danh sách điện thoại hiện đang trống.");
                        } else {
                            System.out.println("===== DANH SÁCH TẤT CẢ ĐIỆN THOẠI =====");
                            for (Phone p : phone) {
                                p.output();
                                System.out.println("-------------------------------");
                            }
                        }
                        break;
                    case 2:
                        if(phone.isEmpty()){
                            System.out.println("Danh sách điện thoại cũ đang  trống!");
                        }else {
                            for (Phone p : phone){
                                if(p instanceof OldPhone){
                                    p.output();
                                    System.out.println("----------------------------");
                                }
                            }
                        }
                        break;
                    case 3:
                        if (phone.isEmpty()){
                            System.out.println("Danh sách điện thoại mới đang trống!");
                        }else {
                            for(Phone p : phone){
                                if (p instanceof NewPhone){
                                    p.output();
                                    System.out.println("-------------------------");
                                }
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
        }
    }
    private static void addProduct(){
        int choose;
        while (true){
                System.out.println("===== Màn Hình 2 =====\nTHÊM ĐIỆN THOẠI");
                System.out.println("1. Thêm điện thoại mới");
                System.out.println("2. Thêm điện thoại cũ");
                System.out.println("3. Trở về menu chính");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,3);
                switch (choose){
                    case 1:
                        Phone newphone = new NewPhone();
                        newphone.input();
                        phone.add(newphone);
                        System.out.println("Thêm điện thoại mới thành công!");
                        break;
                    case 2:
                        Phone oldphone = new OldPhone();
                        oldphone.input();
                        phone.add(oldphone);
                        System.out.println("Thêm điện thoại cũ thành công");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }

        }
    }
    private static void sort(){
//        Scanner scanner =new Scanner(System.in);
        int choose;
        while (true){
                System.out.println("===== Màn Hình 3 =====\nSẮP XẾP ĐIỆN THOẠI");
                System.out.println("1. Sắp xếp tăng dần");
                System.out.println("2. Sắp xếp giảm dần");
                System.out.println("3. Trở về menu chính");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,3);
                switch (choose){
                    case 1:
                    Collections.sort(phone, new SortPriceAscending());
                    System.out.println("Danh sách đã được sắp xếp tăng dần:");
                    for (Phone p : phone) {
                        p.output();
                        System.out.println("-------------------------");
                    }
                    break;
                    case 2:
                        Collections.sort(phone, new SortPriceDescending());
                        System.out.println("Danh sách đã được sắp xếp giảm dần:");
                        for (Phone p : phone) {
                            p.output();
                            System.out.println("-------------------------");
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
        }
    }
    private static void search(){
//        Scanner scanner =new Scanner(System.in);
        int choose;
        while (true){
                System.out.println("===== Màn Hình 4 =====\nTìm kiếm");
                System.out.println("1. Tìm kiếm tất cả điện thoại");
                System.out.println("2. Tìm kiếm điện thoại cũ");
                System.out.println("3. Tìm kiếm điện thoại mới");
                System.out.println("4. Trở về menu chính");
                System.out.print("Mời bạn lựa chọn: ");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,4);
                switch (choose){
                    case 1:
                        searchPhone();
                        break;
                    case 2:
                        searchOld();
                        break;
                    case 3:
                        searchNew();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
        }
    }
    private static void searchPhone(){
//        Scanner scanner =new Scanner(System.in);
        int choose;
        while (true){
                System.out.println("===== Màn Hình 4 =====\nTìm kiếm");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");
                System.out.print("Mời bạn lựa chọn: ");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,4);
                switch (choose){
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
        }
    }
    private static void searchNew(){
//        Scanner scanner =new Scanner(System.in);
        int choose;
        while (true){
                System.out.println("===== Màn Hình 4 =====\nTìm kiếm");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");
                System.out.print("Mời bạn lựa chọn: ");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,4);
                switch (choose){
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
        }
    }
    private static void searchOld(){
//        Scanner scanner =new Scanner(System.in);
        int choose;
        while (true){
            do {
                System.out.println("===== Màn Hình 4 =====\nTìm kiếm");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");
                System.out.print("Mời bạn lựa chọn: ");
                choose = TryCatchInt.chooseInt("Mời bạn nhập lựa chọn: ",1,4);
                switch (choose){
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }

            }while (choose < 1 || choose > 4);
        }
    }
    private static void update(ArrayList<Phone> phone){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID cần cập nhật: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (Phone p : phone) {
            String currentId = "";

            if (p instanceof NewPhone) {
                currentId = ((NewPhone) p).getId();
            } else if (p instanceof OldPhone) {
                currentId = ((OldPhone) p).getId();
            }

            if (id.toLowerCase().equals(currentId.toLowerCase())) {
                System.out.println("Tìm thấy điện thoại có ID: " + id);
                p.input();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại với ID: " + id);
        }
    }
    private static void deletePhone(ArrayList<Phone> phone) {
        Scanner scanner = new Scanner(System.in);
        int choose;

        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < phone.size(); i++) {
            Phone p = phone.get(i);
            String currentId = "";

            if (p instanceof NewPhone) {
                currentId = ((NewPhone) p).getId();
            } else if (p instanceof OldPhone) {
                currentId = ((OldPhone) p).getId();
            }

            if (id.toLowerCase().equals(currentId.toLowerCase())) {
                System.out.println("Bạn có muốn xóa sản phẩm này?");
                p.output();
                System.out.println("\n1. Yes\n2. No");
                choose = scanner.nextInt();
                scanner.nextLine();

                if (choose == 1) {
                    phone.remove(i);
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Bạn đã hủy xóa.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy điện thoại với ID: " + id);
        }
    }

}
