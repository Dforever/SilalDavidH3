/**
 * Doubly-linked list main test file
 */

import java.io.Console;
import java.util.Scanner;
public class DLLTest {
    public static void main(String args[]) {
        ListNode testNode = new ListNode("test");
        System.out.println(testNode.getInfo());

        LinkList dll = new LinkList();
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        do {
            System.out.println("Doubly Linked List Tester");
            System.out.println("1 - Insert from Console");
            System.out.println("2 - Delete from Console");
            System.out.println("3 - Run automated suite of tests");
            System.out.println("4 - Import .txt file");
            System.out.println("8 - Print current linked list");
            System.out.println("9 - Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");
            input = Util.CleanInput(keyboard.nextLine());
            switch (input) {
                case "1":
                    ConsoleInserter ci = new ConsoleInserter(dll);
                    ci.Insert(ConsoleAction.Insert);
                    break;
                case "2":
                    ConsoleInserter cd = new ConsoleInserter(dll);
                    cd.Insert(ConsoleAction.Delete);
                    break;
                case "3":
                    automaticActions(dll);
                    break;
                case "4":
                    FileInserter in = new FileInserter(dll);
                    in.Insert();
                    break;
                case "8":
                    dll.print();
                    break;
                case "9":
                    break;
                default:
                    System.out.println("Invalid selection: " + input);
                    break;
            }
        } while (input.compareTo("9") != 0);
    }
