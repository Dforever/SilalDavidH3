import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;
public class FileInserter {
    private LinkList dl;

    /**
     * Constructor - Doubly Linked list to insert to
     * @param LinkedListInsertTo REF to linked list to insert into
     */
    public FileInserter(LinkList LinkedListInsertTo)
    {
        dl = LinkedListInsertTo;
    }

    /**
     * Insertion
     */
    public void Insert() {
        Scanner sc2 = null;
        try {
            File inputFile = GetFile();
            if (inputFile != null)
                sc2 = new Scanner(inputFile);
            else return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = Util.CleanInput(s2.next());
                if (s.compareTo("") != 0) {
                    dl.add(s);
                }
            }
        }
    }

    private File GetFile() {
        //http://www.avajava.com/tutorials/lessons/how-do-i-use-a-filenamefilter-to-display-a-subset-of-files-in-a-directory.html
        File f = new File("."); // current directory
        System.out.println(f.getName());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        File allfiles[] = f.listFiles(textFilter);
        if (allfiles.length > 0) {
            System.out.println(allfiles[0].getName());
            return allfiles[0];
        } else {
            System.out.println("Cannot find a .txt file in the current working directory");
            return null;
        }

    }
}
