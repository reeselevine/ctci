public class ChapterOne {

    public static void main(String... args) {
       if (args.length == 0) printUsage();
       if (args[0].equals("-q1")) {
           if (args.length != 2) {
               printUsage();
           } else {
               System.out.println(isUnique(args[1]));
           }
       }
    }

    public static void printUsage() {
        System.out.println("Usage:\n" +
                "java ChapterOne -q<number> <args>");
    }

    public static boolean isUnique(String str) {
        if (str.length() < 2) { 
            return true;
        }
        if (str.substring(1).contains(str.substring(0, 1))) {
            return false;
        }
        return isUnique(str.substring(1)); 
    }
}
