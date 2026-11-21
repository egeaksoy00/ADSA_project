import java.util.Scanner;

/*
  Binary Search Tree application with menu
 * Author: Ege Aksoy
 */
public class BST_Menu {

   
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    
    private static Node root = null;

    /*
      Display the menu
     */
    private static void displayMenu() {
        System.out.println("\n--- Binary Search Tree Menu ---");
        System.out.println("1. Display the tree (inorder)");
        System.out.println("2. Insert a value");
        System.out.println("3. Delete a value");
        System.out.println("4. Display smallest and largest values");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /*
      Read menu choices and runs the selected operation
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            // Reject non-integer input
            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }
            int choice = input.nextInt();

            
            if (choice < 1 || choice > 5) {
                 System.out.println("Invalid input. Please enter a num between 1 and 5.");
                 input.nextLine();
                continue;
            }

            

            switch (choice) {
                case 1:
                    
                    System.out.println("Inorder operation will be added.");
                    break;

                case 2:
                    
                    System.out.println("Insert operation will be added.");
                    break;

                case 3:
                    
                    System.out.println("Delete operation will be added.");
                    break;

                case 4:
                    
                    System.out.println("Minimum/maximum operation will be added.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }
        }

        input.close();
    }
}