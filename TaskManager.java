package BTVN_STACK_QUEUE;

import java.util.*;

public class TaskManager<T extends Task> {
    private Stack<T> taskStack = new Stack<>();
    private Stack<T> redoStack = new Stack<>();
    private Queue<T> taskQueue = new LinkedList<>();

    public void pushToStack(T task) {
        taskStack.push(task);
        System.out.println("Đã thêm vào Stack: " + task);
    }

    public T popFromStack() {
        if (!taskStack.isEmpty()) {
            T task = taskStack.pop();
            redoStack.push(task);
            System.out.println("Đã xử lý (pop): " + task);
            return task;
        }
        System.out.println("Stack rỗng!");
        return null;
    }

    public T peekStack() {
        return taskStack.isEmpty() ? null : taskStack.peek();
    }

    public boolean isStackEmpty() {
        if (taskStack.isEmpty()) {
            System.out.println("Stack trống!");
            return true;
        }
        return false;
    }

    public void addToQueue(T task) {
        taskQueue.add(task);
        System.out.println("Đã thêm vào Queue: " + task);
    }

    public T peekQueue() {
        return taskQueue.isEmpty() ? null : taskQueue.peek();
    }

    public T pollFromQueue() {
        if (!taskQueue.isEmpty()) {
            T task = taskQueue.poll();
            System.out.println("Đã xử lý (poll): " + task);
            return task;
        }
        System.out.println("Queue rỗng!");
        return null;
    }

    public boolean isQueueEmpty() {
        if (taskQueue.isEmpty()) {
            System.out.println("Queue rỗng!");
            return true;
        }
        return false;
    }
    public void redo() {
        if (!redoStack.isEmpty()) {
            T task = redoStack.pop();
            taskStack.push(task);
            System.out.println("Đã hoàn tác lại (redo): " + task);
        } else {
            System.out.println("Không có gì để redo.");
        }
    }

    public T processHighestPriorityTask() {
        if (isQueueEmpty()) return null;

        int currentPriority = 1;
        while (true) {
            int size = taskQueue.size();
            boolean found = false;
            Queue<T> tempQueue = new LinkedList<>();
            T targetTask = null;

            for (int i = 0; i < size; i++) {
                T task = taskQueue.poll();
                if (!found && task.getPriority() == currentPriority) {
                    targetTask = task;
                    found = true;
                    System.out.println("Đã xử lý task ưu tiên: " + task);
                } else {
                    tempQueue.offer(task);
                }
            }

            taskQueue = tempQueue;

            if (found) return targetTask;

            currentPriority++;
        }
    }


    public Stack<T> getTaskStack() {
        return taskStack;
    }

    public Queue<T> getTaskQueue() {
        return taskQueue;
    }
}
