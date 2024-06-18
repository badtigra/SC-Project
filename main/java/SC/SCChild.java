/**
 * Used to keep track of assigned and unassigned seats
 *
 * @author Gregory Ross McTaggart
 * @version June 18, 2024
 */
package SC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SCChild {

    public int numRows;
    public int numColumns;
    // javadb db = new javadb();

    ArrayList<String> storedNames = new ArrayList<String>(); // Stores names for input into chart
    String[][] names; // Array for storing name location

    /**
     * SCChild - Default constructor, no parameters Chance to initialize any or
     * all of the instance variables
     */
    public SCChild() {
        numRows = 0;
        numColumns = 0;
    }

    /**
     * SCCild - Constructor to initialize all seats to "________" (8 wide)
     * Initialize 2D Array
     *
     * @param inputRows - set rows from SCMain
     * @param inputColumns - set columns from SCMain
     */
    public SCChild(int inputRows, int inputColumns) {
        this.numRows = inputRows;
        this.numColumns = inputColumns;
        names = new String[numRows][numColumns];
        for (String[] underscore : names) {
            Arrays.fill(underscore, "________");
        }
    }

    /**
     * getRows - Return the current value of numRows
     *
     * @return numRows
     */
    public int getRows() {
        return numRows;
    }

    /**
     * setRows - Update the current value of numRows
     *
     * @param inputRows new value
     * @return void;
     */
    public void setRows(int inputRows) {
        this.numRows = inputRows;
    }

    /**
     * getColumns - Return the current value of numColumns
     *
     * @return numColumns
     */
    public int getColumns() {
        return numColumns;
    }

    /**
     * setColumns - Update the current value of numColumns
     *
     * @param inputColumns new value
     * @return void
     */
    public void setColumns(int inputColumns) {
        this.numColumns = inputColumns;
    }

    /**
     * printSeatingChart - prints each name 10 characters wide
     *
     * @return void
     */
    public void printSeatingChart() {
        for (String[] person : names) {
            for (String name : person) {
                //System.out.printf("%10s ", name);
                System.out.printf("%s\t", name);
            }
            System.out.println();
        }
    }

    /**
     * addPerson - puts name in correct element of 2-dimensional array
     *
     * @param row - which row (1 based)
     * @param column - which column (1 based)
     * @param name - which name
     * @return void
     */
    public void addPerson(int row, int column, String name) {
        names[row - 1][column - 1] = name;
        storedNames.add(name);
    }

    /**
     * getEmpty - Calculate and return number of unassigned seats
     *
     * @return total
     */
    public int getEmpty() {
        int total = 0;
        for (String[] unassigned : names) {
            for (String name : unassigned) {
                if ("________".equals(name)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * getAssigned - Calculate and return number of assigned seats
     *
     * @return total
     */
    public int getAssigned() {
        int total = 0;
        for (String[] assigned : names) {
            for (String name : assigned) {
                if (!"________".equals(name)) {
                    total += 1;
                }
            }
        }
        return total;
    }

    /**
     * printNames - Prints all names in sorted order (Alphabetically)
     *
     * @return void
     */
    public void printNames() {
        System.out.printf("%n--Your Attendees--%n");
        Collections.sort(storedNames);
        for (String w : storedNames) {
            System.out.printf("%s%n", w);
        }
    }

    /**
     * printNamesNumeric - Prints all names in left to right seating order
     *
     * @return void
     */
    public void printNamesNumeric() {
        System.out.printf("%n--In Numerical--%n");
        for (String[] w : names) {
            for (String name : w) {
                if (name.equals("________")) {
                    continue;
                } else {
                    System.out.printf("%s%n", name);
                }
            }
        }
    }
}
