import java.util.ArrayList;

public class ChapterOne {

    public static void main(String... args) {
       if (args.length == 0) {
           printUsage();
           return;
       }
       if (args[0].equals("-q1")) {
           if (args.length != 2) {
               printUsage();
           } else {
               System.out.println(isUnique(args[1]));
           }
       } else if (args[0].equals("-q6")) {
           if (args.length != 1) {
               printUsage();
           } else {
               System.out.println(testRotateMatrix());
           }
       } else if (args[0].equals("-q7")) {
           if (args.length != 1) {
               printUsage();
           } else {
               System.out.println(testSetMatrixZeros());
           }
       } else if (args[0].equals("-q8")) {
           if (args.length != 3) {
               printUsage();
           } else {
               System.out.println(isRotation(args[1], args[2]));
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

    public static int[][] rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 1) return matrix;
        for (int i = matrix.length - 1; i > 0; i-= 1) {
            for (int j = matrix.length - i - 1; j < i; j++) {
                int top = matrix[j][matrix.length - i - 1];
                int right = matrix[i][j];
                int bottom = matrix[matrix.length - j - 1][i];
                matrix[j][matrix.length - i - 1] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[i][j] = top;
                matrix[matrix.length - j - 1][i] = right;
                matrix[matrix.length - i -1][matrix.length - j - 1] = bottom;
            }
        }
        return matrix;
    }

    public static boolean testMatrixEquality(int[][] matrixOne, int[][]matrixTwo) {
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                if (matrixOne[i][j] != matrixTwo[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean testRotateMatrix() {
        int[][] c = {{1, 2}, {3, 4}};
        int[][] rotatedC = {{2, 4}, {1, 3}};
        int[][] maybeRotated = rotateMatrix(c);
        if (!testMatrixEquality(maybeRotated, rotatedC)) {
            return false;
        }
        int[][] a ={{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotatedA[][] = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        if (!testMatrixEquality(rotateMatrix(a), rotatedA)) {
            return false;
        }
        int[][] b = {{1}};
        if (!testMatrixEquality(rotateMatrix(b), b)) {
            return false;
        }
        return true;
    }

    public static int[][] setMatrixZeros(int[][] matrix) {
        if (matrix == null) return matrix;
        ArrayList<Integer[]> seen = new ArrayList<Integer[]>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    seen.add(new Integer[] {i, j});
                }
            }
        }
        for (Integer[] pair : seen) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[pair[0]][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][pair[1]] = 0;
            }
        }
        return matrix;
    }

    public static boolean testSetMatrixZeros() {
        int[][] a = {{1, 2, 0}, {3, 0, 4}};
        int[][] zeroedA = {{0, 0, 0}, {0, 0, 0}};
        if (!testMatrixEquality(setMatrixZeros(a), zeroedA)) {
            return false;
        }
        int[][] b = {{1, 2}, {3, 4}};
        if (!testMatrixEquality(setMatrixZeros(b), b)) {
            return false;
        }
        int[][] c = {{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] zeroedC = {{0, 1, 0, 1}, {0, 0, 0, 0}, {0, 1, 0, 1}, {0, 1, 0, 1}};
        if (!testMatrixEquality(setMatrixZeros(c), zeroedC)) {
            return false;
        }
        return true;
    }

    public static boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String ab = a + b;
        return ab.contains(b);
    }
}
