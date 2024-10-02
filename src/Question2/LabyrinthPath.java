package Question2;

import java.util.Scanner;

public class LabyrinthPath {
    private Node head;

    // Inner class to represent a Node in the linked list
    private static class Node {
        String location;
        Node next;

        public Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    // Constructor for LabyrinthPath
    public LabyrinthPath() {
        head = null;
    }

    // Method to add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added location: " + location);
    }

    // Method to remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("The path is empty, no location to remove.");
            return;
        }

        if (head.next == null) {
            System.out.println("Removing last location: " + head.location);
            head = null;
            return;
        }

        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        System.out.println("Removing last location: " + secondLast.next.location);
        secondLast.next = null;
    }

    // Method to check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null || head.next == null) {
            return false;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;  // Loop detected
            }
        }
        return false;
    }

    // Method to print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Labyrinth Path: ");
        while (temp != null) {
            System.out.print(temp.location + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LabyrinthPath path = new LabyrinthPath();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLabyrinth Path Menu:");
            System.out.println("1. Add Location");
            System.out.println("2. Remove Last Location");
            System.out.println("3. Check for Loop");
            System.out.println("4. Print Path");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter location name to add: ");
                    String locationToAdd = scanner.nextLine();
                    path.addLocation(locationToAdd);
                    break;

                case 2:
                    path.removeLastLocation();
                    break;

                case 3:
                    boolean hasLoop = path.containsLoop();
                    if (hasLoop) {
                        System.out.println("The path contains a loop.");
                    } else {
                        System.out.println("The path does not contain a loop.");
                    }
                    break;

                case 4:
                    path.printPath();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}