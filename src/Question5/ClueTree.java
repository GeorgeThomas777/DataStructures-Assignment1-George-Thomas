package Question5;

import java.util.Scanner;

public class ClueTree {
    private TreeNode rootNode;  // The starting point of the clue tree

    // Inner class representing a node (clue) in the binary tree
    private static class TreeNode {
        String clue;           // The actual clue text
        TreeNode leftChild;    // Reference to the left child node
        TreeNode rightChild;   // Reference to the right child node

        TreeNode(String clue) {
            this.clue = clue;
            leftChild = null;   // Initialize left child to null
            rightChild = null;  // Initialize right child to null
        }
    }

    // Method to add a new clue to the tree
    public void addClue(String clue) {
        rootNode = addClueRecursively(rootNode, clue);
    }

    // Helper method to insert a clue recursively
    private TreeNode addClueRecursively(TreeNode currentNode, String clue) {
        // If we reach a null node, this is where the new clue will go
        if (currentNode == null) {
            return new TreeNode(clue);
        }
        // Compare the clue to the current node's clue to decide where to go
        if (clue.compareTo(currentNode.clue) < 0) {
            currentNode.leftChild = addClueRecursively(currentNode.leftChild, clue);
        } else if (clue.compareTo(currentNode.clue) > 0) {
            currentNode.rightChild = addClueRecursively(currentNode.rightChild, clue);
        }
        // Return the unchanged current node pointer
        return currentNode;
    }

    // In-order traversal to display clues in sorted order
    public void showInOrder() {
        System.out.print("In-order clues: ");
        inOrderRecursively(rootNode);
        System.out.println(); // New line for better readability
    }

    private void inOrderRecursively(TreeNode currentNode) {
        if (currentNode != null) {
            inOrderRecursively(currentNode.leftChild);
            System.out.print(currentNode.clue + " ");
            inOrderRecursively(currentNode.rightChild);
        }
    }

    // Pre-order traversal to show clues in a different order
    public void showPreOrder() {
        System.out.print("Pre-order clues: ");
        preOrderRecursively(rootNode);
        System.out.println(); // New line for better readability
    }

    private void preOrderRecursively(TreeNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.clue + " ");
            preOrderRecursively(currentNode.leftChild);
            preOrderRecursively(currentNode.rightChild);
        }
    }

    // Post-order traversal to show clues after their children
    public void showPostOrder() {
        System.out.print("Post-order clues: ");
        postOrderRecursively(rootNode);
        System.out.println(); // New line for better readability
    }

    private void postOrderRecursively(TreeNode currentNode) {
        if (currentNode != null) {
            postOrderRecursively(currentNode.leftChild);
            postOrderRecursively(currentNode.rightChild);
            System.out.print(currentNode.clue + " ");
        }
    }

    // Method to search for a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRecursively(rootNode, clue);
    }

    private boolean findClueRecursively(TreeNode currentNode, String clue) {
        if (currentNode == null) {
            return false; // Clue not found
        }
        if (currentNode.clue.equals(clue)) {
            return true; // Clue found
        }
        // Continue searching in the appropriate subtree
        return clue.compareTo(currentNode.clue) < 0 
                ? findClueRecursively(currentNode.leftChild, clue) 
                : findClueRecursively(currentNode.rightChild, clue);
    }

    // Method to count the total number of clues in the tree
    public int countClues() {
        return countCluesRecursively(rootNode);
    }

    private int countCluesRecursively(TreeNode currentNode) {
        if (currentNode == null) {
            return 0; // Base case: no clues here
        }
        // Count this clue plus the clues in both subtrees
        return 1 + countCluesRecursively(currentNode.leftChild) + countCluesRecursively(currentNode.rightChild);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClueTree clueTree = new ClueTree(); // Create a new ClueTree instance
        boolean isRunning = true; // Control variable for the menu loop

        while (isRunning) {
            // Display the menu options
            System.out.println("\n=== Clue Tree Menu ===");
            System.out.println("1. Add a Clue");
            System.out.println("2. Show Clues (In-order)");
            System.out.println("3. Show Clues (Pre-order)");
            System.out.println("4. Show Clues (Post-order)");
            System.out.println("5. Search for a Clue");
            System.out.println("6. Count Total Clues");
            System.out.println("7. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the clue you want to add: ");
                    String newClue = scanner.nextLine();
                    clueTree.addClue(newClue);
                    System.out.println("Clue added successfully!");
                    break;

                case 2:
                    clueTree.showInOrder();
                    break;

                case 3:
                    clueTree.showPreOrder();
                    break;

                case 4:
                    clueTree.showPostOrder();
                    break;

                case 5:
                    System.out.print("Enter the clue you want to search for: ");
                    newClue = scanner.nextLine();
                    if (clueTree.findClue(newClue)) {
                        System.out.println("Clue found: " + newClue);
                    } else {
                        System.out.println("Clue not found: " + newClue);
                    }
                    break;

                case 6:
                    System.out.println("Total clues in the tree: " + clueTree.countClues());
                    break;

                case 7:
                    isRunning = false; // Exit the menu loop
                    System.out.println("Thank you for using the Clue Tree program!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid input
            }
        }

        scanner.close(); // Close the scanner
    }
}

