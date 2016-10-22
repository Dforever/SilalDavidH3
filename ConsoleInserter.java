import java.util.Scanner;
public class ConsoleInserter {
    private LinkList dl;



    /**
     * Constructor - Doubly Linked list to insert to
     * @param LinkedListInsertTo REF to linked list to insert into
     */
    public ConsoleInserter(LinkList LinkedListInsertTo)
    {
        dl = LinkedListInsertTo;
    }

    /**
     * Insertion
     */
    public void Insert(ConsoleAction actionTodo) {
        String keysIn = "";
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("Enter a word to " + actionTodo.toString() + " or EXIT to end: ");
            keysIn = Util.CleanInput(keyboard.nextLine());
            if (keysIn.length() > 0 && keysIn.compareTo("EXIT") != 0) {
                if (actionTodo == ConsoleAction.Delete) {
                    dl.remove(keysIn);
                } else if (actionTodo == ConsoleAction.Insert) {
                    dl.add(keysIn);
                }
                System.out.println("Printing revised list");
                dl.print();
            } else {
                System.out.println("Input included invalid characters!");
            }
        } while (keysIn.compareTo("EXIT") != 0);
    }
}
