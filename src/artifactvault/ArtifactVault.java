package artifactvault;


import java.util.Arrays;
import java.util.Scanner;

public class ArtifactVault {
    private Artifact[] artifacts;
    private int capacity;
    private int size;

    // Constructor to initialize the vault with a certain capacity
    public ArtifactVault(int capacity) {
        this.capacity = capacity;
        this.artifacts = new Artifact[capacity];
        this.size = 0;
    }

    // Method to add an artifact to the first empty slot
    public void addArtifact(String name, int age) {
        if (size < capacity) {
            Artifact newArtifact = new Artifact(name, age);
            artifacts[size++] = newArtifact;
            System.out.println("Added: " + newArtifact);
        } else {
            System.out.println("Vault is full, cannot add more artifacts.");
        }
    }

    // Method to remove an artifact by its name
    public void removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Removing: " + artifacts[i]);
                artifacts[i] = artifacts[size - 1];  // Replace the removed element with the last one
                artifacts[size - 1] = null;  // Set the last element to null
                size--;
                return;
            }
        }
        System.out.println("Artifact not found.");
    }

    // Linear search to find an artifact by name
    public Artifact findArtifactLinear(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i].getName().equalsIgnoreCase(name)) {
                return artifacts[i];
            }
        }
        return null;
    }

    // Binary search to find an artifact by age (assumes the array is sorted by age)
    public Artifact findArtifactBinary(int age) {
        Arrays.sort(artifacts, 0, size, (a, b) -> Integer.compare(a.getAge(), b.getAge()));  // Sort by age

        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (artifacts[mid].getAge() == age) {
                return artifacts[mid];
            } else if (artifacts[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Display all artifacts in the vault
    public void displayArtifacts() {
        if (size == 0) {
            System.out.println("No artifacts in the vault.");
        } else {
            System.out.println("Artifacts in the vault:");
            for (int i = 0; i < size; i++) {
                System.out.println(artifacts[i]);
            }
        }
    }

    // Class to represent an artifact
    public static class Artifact {
        private String name;
        private int age;

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Artifact{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the vault capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        ArtifactVault vault = new ArtifactVault(capacity);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nArtifact Vault Menu:");
            System.out.println("1. Add Artifact");
            System.out.println("2. Remove Artifact");
            System.out.println("3. Find Artifact (Linear Search)");
            System.out.println("4. Find Artifact (Binary Search)");
            System.out.println("5. Display Artifacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter artifact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter artifact age: ");
                    int age = scanner.nextInt();
                    vault.addArtifact(name, age);
                    break;

                case 2:
                    System.out.print("Enter artifact name to remove: ");
                    name = scanner.nextLine();
                    vault.removeArtifact(name);
                    break;

                case 3:
                    System.out.print("Enter artifact name to search (Linear): ");
                    name = scanner.nextLine();
                    Artifact foundLinear = vault.findArtifactLinear(name);
                    if (foundLinear != null) {
                        System.out.println("Found (Linear): " + foundLinear);
                    } else {
                        System.out.println("Artifact not found (Linear Search).");
                    }
                    break;

                case 4:
                    System.out.print("Enter artifact age to search (Binary): ");
                    age = scanner.nextInt();
                    Artifact foundBinary = vault.findArtifactBinary(age);
                    if (foundBinary != null) {
                        System.out.println("Found (Binary): " + foundBinary);
                    } else {
                        System.out.println("Artifact not found (Binary Search).");
                    }
                    break;

                case 5:
                    vault.displayArtifacts();
                    break;

                case 6:
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
