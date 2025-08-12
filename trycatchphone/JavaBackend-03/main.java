package BTVN_STACK_QUEUE;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TaskManager<Task> manager = new TaskManager<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choose;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Thêm Task vào Stack");
                System.out.println("2. Xem danh sách task trong stack");
                System.out.println("3. Xử lý task cuối trong stack");
                System.out.println("4. Redo task đã xử lý");
                System.out.println("5. Thêm task vào queue");
                System.out.println("6. Xem danh sách task trong queue");
                System.out.println("7. Xử lý Task đầu trong Queue");
                System.out.println("8. Xử lý Task ưu tiên nhất trong Queue");
                System.out.println("9. Thoát");
                System.out.print("Chọn: ");
                choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1:
                        Task task = input(scanner);
                        manager.pushToStack(task);
                        break;
                    case 2:
                        System.out.println(manager.getTaskStack());
                        break;
                    case 3:
                        manager.popFromStack();
                        break;
                    case 4:
                        manager.redo();
                        break;
                    case 5:
                        Task taskqueue = input(scanner);
                        manager.addToQueue(taskqueue);
                        break;
                    case 6:
                        System.out.println(manager.getTaskQueue());
                        break;
                    case 7:
                        manager.pollFromQueue();
                        break;
                    case 8:
                        manager.processHighestPriorityTask();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Nhập sai mời nhập lại!");
                }
            }while (choose <= 0 || choose > 8);
        }
    }
    private static Task input(Scanner sc){
        System.out.print("Nhập tên Task: ");
        String name = sc.nextLine();
        int priority;
        do {
            System.out.print("Nhập độ ưu tiên (số nguyên >= 1): ");
            priority = sc.nextInt();
        }while (priority <1);
        sc.nextLine();
        return new Task(name, priority);
    }
}
