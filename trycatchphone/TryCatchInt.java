package trycatchphone;

import java.util.Scanner;

public class TryCatchInt extends Exception{
    private static final Scanner sc = new Scanner(System.in);

    public static int chooseInt(String message,int min,int max) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }if (input.equals("")){
                    throw new TryCatchPhoneInput("Null");
                }
                else {
                    throw new IllegalArgumentException("ArithmeticException");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chỉ được nhập số nguyên!");
            }catch (IllegalArgumentException iae){
                System.out.println("Vui lòng nhập trong khoảng từ "+min+" đến "+max);
            }catch (TryCatchPhoneInput tcpi){
                System.out.printf(tcpi.getMessage());
                System.out.printf(" Vui lòng nhập lại: ");
        }
    }
    }
    public static int inputInt(String message){
        while (true){
            System.out.print(message);
            String input = sc.nextLine().trim();
            try{
                if (input.equals("")){
                    throw new TryCatchPhoneInput("Null");
                }
                Integer value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                } else {
                    throw new IllegalArgumentException("Lỗi tham số!");
                }
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số nguyên: ");
            }
            catch (IllegalArgumentException iae){
                System.out.println("Vui lòng nhập lớn hơn > 0");
            } catch (TryCatchPhoneInput tcpi){
            System.out.printf(tcpi.getMessage());
            System.out.printf(" Vui lòng nhập lại: ");}
        }
        }
    public static String checkOS(){
        while (true){
            String input = sc.nextLine().trim();
            try{
                if (input.toUpperCase().equals("IOS") || input.toUpperCase().equals("ANDROID") || input.toUpperCase().equals("WINDOWN")){
                    return input;
                }
                if (input == ""){
                    throw new TryCatchPhoneInput("Null");
                }
                else {
                    throw new IllegalArgumentException("IllegalArgumentException");
                }
            }catch (IllegalArgumentException iae){
                System.out.printf("Chỉ được nhập IOS,Android hoạc Windown \nMời bạn nhập lại: ");
            }catch (TryCatchPhoneInput tcpi){
                System.out.printf(tcpi.getMessage());
                System.out.printf(" Vui lòng nhập lại: ");
            }
        }
    }
    public static String checkSpecial(){
        while (true){
            String input = sc.nextLine();
            try{
                if (input.matches("^[a-zA-Z0-9 ]+$")){
                    return input;
                }
                if (input.equals("")){
                    throw new TryCatchPhoneInput("Null");
                }
                throw new IllegalArgumentException("IllegalArgumentException");
            }catch (IllegalArgumentException iae){
                System.out.printf("Vui lòng không nhập kí tự đặc biệt!\nMời nhập lại: ");
            }catch (TryCatchPhoneInput tcpi){
                System.out.printf(tcpi.getMessage());
                System.out.printf(" Vui lòng nhập lại: ");
            }
        }
    }
}
