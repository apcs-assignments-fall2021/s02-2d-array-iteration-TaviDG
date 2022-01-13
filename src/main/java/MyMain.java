public class MyMain {
    // Returns the String that shows up latest alphabetically
    // in a normal 1D String array
    // You can assume that the array will not be empty
    // and that all Strings are lowercase
    // Hint: recall how the compareTo() method works:
    //      int x = "apple".compareTo("banana"); // x is negative
    //      int y = "banana".compareTo("apple"); // y is positive
    public static String findLastWord(String[] arr) {
        String lastWord = "a";
        for (String word: arr){
            if (word.compareTo(lastWord)>=0){
                lastWord = word;
            }
        }
        return lastWord;
    }

    // Given a 2D array, return an 1D array of the last word
    // in each row in the array
    // You can assume that the matrix will not be empty
    // Hint: use the previous method to help yourself!
    public static String[] findLastWord2D(String[][] mat) {
        String[] words = new String[mat.length];
        for (int i = 0; i < mat.length ; i++) {
            words[i] = findLastWord(mat[i]);
        }
        return words;
    }

    // Given a 2D array and some column index col
    // finds the number of Strings in the specified column
    // of the 2D array that contain the word "apple"
    // For example, if col = 0, you should only look through
    // the values in column 0 of the array; likewise, if
    // col = 2, you should only look through the values in column 2

    // Hint: remember how the indexOf() method works?
    // alternatively, consider the contains() method
    public static int appleCounter(String[][] mat, int col) {
        int apples = 0;
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col].contains("apple")){
                apples++;
            }
        }
        return apples;
    }

    // Given a 2D array, return the column number corresponding
    // to the column that contains the most Strings containing
    // the word "apple"

    // Hint: use your previous method!
    // Hint 2: you might need to loop through the columns!
    public static int findMostAppleColumn(String[][] mat) {
        int mostApples = 0;
        int mostAppleColumn = -1;
        for (int i = 0; i < mat[0].length; i++) {
            int apples = appleCounter(mat,i);
            if (apples>=mostApples){
                mostAppleColumn = i;
                mostApples = apples;
            }
        }
        return mostAppleColumn;
    }


    // Creates Pascal's Triangle, with a height of n
    // The first row of numbers has a single number, 1
    // Each subsequent row has one more number than the previous row
    // The first and last numbers of every row are 1
    // All other numbers’ values are calculated by adding together the two numbers above that number

    // Here are some examples:
    // pascalTriangle(2) =>
    // 1  0
    // 1  1

    // pascalTriangle(6) =>
    // 1  0  0  0  0  0
    // 1  1  0  0  0  0
    // 1  2  1  0  0  0
    // 1  3  3  1  0  0
    // 1  4  6  4  1  0
    // 1  5  10 10 5  1

    // Hint: fill in the first column and first diagonal with 1's
    //       and then go through and calculate the rest of the values
    //       from top to bottom

    public static int[][] pascal(int height) {
        int[][] pascal = new int[height][height];
        for (int row = 0; row < pascal.length; row++) {
            pascal[row][0] = 1;
            pascal[row][row]=1;
            if (row>1){
                for (int col = 1; col < row ; col++) {
                    pascal[row][col] = pascal[row-1][col]+pascal[row-1][col-1];
                }
            }
        }
        return pascal;
    }










    // Methods for the homework:

    // Checks if a 2D array is a magic square or not
    // You can assume that the 2D array mat will be square
    // A 2D array is a magic square if:
    // There is some set value x such that:
    // * all rows sum to x
    // * all columns sum to x
    // * both diagonals sum to x

    // Hint 1: you might first want to add up the values in the
    // first row/col and save that value to compare with later.
    // Then, you should check each rows, check each column, and
    // check each diagonal

    // Hint 2: you problably want to break this down into many parts.
    // You should have two loops to check the row sums. Then two more
    // loops to chekc the column sums. Finally, it might help to have
    // one for loop for each diagonal

    // Hint 3: when thinking the diagonals, consider the following
    // * do you see any pattern for the row and col indexes for a diagonal?
    // * can you use a for loop that goes through that pattern?
    public static boolean isMagic(int[][] mat) {
        int x = sumRow(mat[0]);
        return (checkRows(mat,x)&&checkCols(mat,x)&&checkDiagonals(mat,x));
    }
    public static int sumRow(int[] row){
        int sum = 0;
        for (int x: row){
            sum+=x;
        }
        return sum;
    }
    public static int sumCol(int[][]mat, int col){
        int sum = 0;
        for (int[] row: mat){
            sum+= row[col];
        }
        return sum;
    }
    public static int sumDiagonal(int[][]mat, int shift){
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            sum+=mat[row][Math.abs(shift-row)];
        }
        return sum;
    }
    public static boolean checkRows(int[][]mat, int x){
        for (int i = 1; i < mat.length; i++) {
            if (sumRow(mat[i])!=x){
                return false;
            }
        }
        return true;
    }
    public static boolean checkCols(int[][]mat, int x){
        for (int i = 0; i < mat[0].length; i++) {
            if (sumCol(mat,i)!=x) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkDiagonals(int[][]mat, int x){
        if (sumDiagonal(mat,0)!=x||sumDiagonal(mat,mat[0].length-1)!=x){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
