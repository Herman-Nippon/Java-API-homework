import java.util.*;

public class TelephoneBook {
    private Map<String, ArrayList<String>> book;


    public TelephoneBook() {
        this.book = new HashMap<>();
        book.put("Катя", new ArrayList<>(Arrays.asList("43-23-12")));
        book.put("Данил", new ArrayList<>(Arrays.asList("123-123", "321-321")));
        book.put("Витя", new ArrayList<>(Arrays.asList("90-80-70", "80-80-80", "40-30-20")));
    }

    /**
     * Retrieves the name of a contact from the user input.
     *
     * @param sc The Scanner object used for user input.
     * @return The name of the contact entered by the user.
     */
    private String getName(Scanner sc) {
        System.out.print("Enter a name of a contact: ");
        return sc.nextLine();
    }

    /**
     * Retrieves the number of a contact from the user input.
     *
     * @param sc The Scanner object used for user input.
     * @return The number of the contact entered by the user.
     */
    private String getNumber(Scanner sc) {
        System.out.print("Enter a number of a contact: ");
        return sc.nextLine();
    }

    /**
     * Adds a new contact to the address book.
     *
     * @param scanner The Scanner object used for user input.
     */
    public void addContact(Scanner scanner) {
        String contactName = getName(scanner);
        String telNum = getNumber(scanner);

        if (book.containsKey(contactName)) {
            book.get(contactName).add(telNum);
        } else {
            book.put(contactName, new ArrayList<>(Arrays.asList(telNum)));
        }
    }

    /**
     * Prints the contacts in the address book sorted by the number of telephone numbers each contact has.
     */
    public void printContacts() {
        List<Map.Entry<String, ArrayList<String>>> list = new ArrayList<>(book.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        for (Map.Entry<String, ArrayList<String>> item : list) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    /**
     * Deletes a specific telephone number associated with a contact from the address book.
     *
     * @param scanner The Scanner object used for user input.
     */
    public void deleteNumber(Scanner scanner) {
        String contactName = getName(scanner);
        String telNum = getNumber(scanner);

        for (String s : book.keySet()) {
            if (s.equals(contactName)) {
                if (book.get(s).remove(telNum))
                    System.out.println("The number " + telNum + " of the contact " + contactName + " was removed successfully.");
                else
                    System.out.println("Contact " + contactName + " doesn't have such number.");
                return;
            }
        }
        System.out.println("There's no such contact in the book.");
    }

    /**
     * Deletes a contact from the address book.
     *
     * @param scanner The Scanner object used for user input.
     */
    public void deleteContact(Scanner scanner) {
        String contactName = getName(scanner);

        if (book.remove(contactName) == null)
            System.out.println("There's no such contact in the book.");
        else
            System.out.println("The contact " + contactName + " was removed successfully.");
    }
}
