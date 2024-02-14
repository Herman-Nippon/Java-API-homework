import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TelephoneBook tb = new TelephoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean stopFlag = false;

        while (!stopFlag) {
            printMenu();
            int command = scanner.nextInt();
            scanner.nextLine(); // to get rid of the \n character that's left in the buffer
            switch (command) {
                case 1:
                    tb.addContact(scanner);
                    break;
                case 2:
                    tb.deleteNumber(scanner);
                    break;
                case 3:
                    tb.deleteContact(scanner);
                    break;
                case 4:
                    tb.printContacts();
                    break;
                default:
                    stopFlag = true;
                    break;
            }
        }
        scanner.close();
        System.out.println("Thanks for working with our telephone book!");
    }

    /**
     * Prints the menu
     */
    public static void printMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.printf("%d: add a contact\n%d: delete a number\n%d: delete a contact\n%d: print contacts\n",
                1, 2, 3, 4);
        System.out.println("If you want to finish working, input 5\n");
    }
}