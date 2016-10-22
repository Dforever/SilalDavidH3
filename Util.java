/**
 * Static Utility Class
 */
public class Util {
    /**
     * Use regular expression to clean out all non-alphanumeric input
     * @param input Input to clean
     * @return cleaned from input
     */
    public static String CleanInput(String input) {
        return input.replaceAll("[^A-Za-z0-9]","");
    }
}
