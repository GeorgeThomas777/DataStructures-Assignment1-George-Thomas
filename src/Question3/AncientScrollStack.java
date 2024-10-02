package Question3;

import java.util.Scanner;
import java.util.Stack;

public class AncientScrollStack {
    private Stack<ScrollDocument> scrollDocuments;

    // Constructor to initialize the stack
    public AncientScrollStack() {
        scrollDocuments = new Stack<>();
    }

    // Method to add a new scroll to the stack
    public void addScroll(String title) {
        ScrollDocument newScroll = new ScrollDocument(title);
        scrollDocuments.push(newScroll);
        System.out.println("Scroll added: " + newScroll);
    }

    // Method to remove the top scroll from the stack
    public void removeTopScroll() {
        if (!scrollDocuments.isEmpty()) {
            ScrollDocument removedScroll = scrollDocuments.pop();
            System.out.println("Scroll removed: " + removedScroll);
        } else {
            System.out.println("No scrolls available to remove.");
        }
    }

    // Method to view the top scroll without removing it
    public void viewTopScroll() {
        if (!scrollDocuments.isEmpty()) {
            ScrollDocument topScroll = scrollDocuments.peek();
            System.out.println("Current top scroll: " + topScroll);
        } else {
            System.out.println("No scrolls in the stack.");
        }
    }

    // Method to check if a scroll with a specific title exists in the stack
    public boolean scrollExists(String title) {
        for (ScrollDocument scroll : scrollDocuments) {
            if (scroll.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Class to represent a scroll document
    private static class ScrollDocument {
        private String title;

        public ScrollDocument(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "ScrollDocument{title='" + title + "'}";
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        AncientScrollStack ancientScrollStack = new AncientScrollStack();
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nAncient Scroll Stack Menu:");
            System.out.println("1. Add Scroll");
            System.out.println("2. Remove Top Scroll");
            System.out.println("3. View Top Scroll");
            System.out.println("4. Check Scroll Existence");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = inputScanner.nextInt();
            inputScanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter scroll title: ");
                    String scrollTitle = inputScanner.nextLine();
                    ancientScrollStack.addScroll(scrollTitle);
                    break;

                case 2:
                    ancientScrollStack.removeTopScroll();
                    break;

                case 3:
                    ancientScrollStack.viewTopScroll();
                    break;

                case 4:
                    System.out.print("Enter scroll title to check: ");
                    scrollTitle = inputScanner.nextLine();
                    boolean exists = ancientScrollStack.scrollExists(scrollTitle);
                    if (exists) {
                        System.out.println("The scroll exists in the stack.");
                    } else {
                        System.out.println("The scroll does not exist in the stack.");
                    }
                    break;

                case 5:
                    continueRunning = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        inputScanner.close();
    }
}
