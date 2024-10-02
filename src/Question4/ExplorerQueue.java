package Question4;

import java.util.Scanner;

public class ExplorerQueue {
    private String[] explorerList;  // Array to hold the explorers
    private int headIndex;           // Index of the front of the queue
    private int tailIndex;           // Index of the rear of the queue
    private int maxCapacity;         // Maximum capacity of the queue
    private int currentSize;         // Current number of explorers in the queue

    // Constructor to initialize the queue with a specific capacity
    public ExplorerQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.explorerList = new String[maxCapacity];
        this.headIndex = 0;
        this.tailIndex = -1;
        this.currentSize = 0;
    }

    // Method to add a new explorer to the queue
    public void addExplorer(String explorerName) {
        if (isQueueFull()) {
            System.out.println("The queue is full. Cannot add more explorers.");
            return;
        }
        tailIndex = (tailIndex + 1) % maxCapacity; // Circular increment
        explorerList[tailIndex] = explorerName;
        currentSize++;
        System.out.println("Explorer added: " + explorerName);
    }

    // Method to remove an explorer from the queue
    public void removeExplorer() {
        if (isQueueEmpty()) {
            System.out.println("The queue is empty. No explorer to remove.");
            return;
        }
        System.out.println("Explorer entered the temple: " + explorerList[headIndex]);
        explorerList[headIndex] = null; // Optional: Clear the reference
        headIndex = (headIndex + 1) % maxCapacity; // Circular increment
        currentSize--;
    }

    // Method to display the next explorer in line
    public void showNextExplorer() {
        if (isQueueEmpty()) {
            System.out.println("The queue is empty. No explorer in line.");
        } else {
            System.out.println("Next explorer in line: " + explorerList[headIndex]);
        }
    }

    // Method to check if the queue is full
    public boolean isQueueFull() {
        return currentSize == maxCapacity;
    }

    // Method to check if the queue is empty
    public boolean isQueueEmpty() {
        return currentSize == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the explorer queue: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ExplorerQueue explorerQueue = new ExplorerQueue(maxCapacity);
        boolean running = true;

        while (running) {
            System.out.println("\nExplorer Queue Menu:");
            System.out.println("1. Add Explorer");
            System.out.println("2. Remove Explorer");
            System.out.println("3. Show Next Explorer");
            System.out.println("4. Check Queue Status (Full/Empty)");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter explorer name: ");
                    String explorerName = scanner.nextLine();
                    explorerQueue.addExplorer(explorerName);
                    break;

                case 2:
                    explorerQueue.removeExplorer();
                    break;

                case 3:
                    explorerQueue.showNextExplorer();
                    break;

                case 4:
                    System.out.println("Queue is " + (explorerQueue.isQueueEmpty() ? "empty." : "not empty."));
                    System.out.println("Queue is " + (explorerQueue.isQueueFull() ? "full." : "not full."));
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

