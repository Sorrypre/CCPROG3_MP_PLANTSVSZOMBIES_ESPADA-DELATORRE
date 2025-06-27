/*********************************************************************************************************
 This is to certify that this project is our own work, based on our personal efforts in studying and applying the concepts
 learned. We have constructed the functions and their respective algorithms and corresponding code by ourselves. The
 program was run, tested, and debugged by our own efforts. We further certify that we have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jensel John L. Espada, DLSU ID# 12409383
 Joramm Fredrik A. Dela Torre DLSU ID#12409529
 *********************************************************************************************************/
package main;

/**
 * The class Counter represents the details of an accumulator
 *
 * @author Jensel John L. Espada
 * @author Joramm Fredrik A. Dela Torre
 * @version 1.0
 */
public class Counter {
    /** This constructor initializes the accumulated value to 0
     */
    public Counter() {
        value = 0;
        accumulator = 0;
    }

    /** This constructor initializes the accumulated value to the parameter
     @param value the starting value of the accumulator
     */
    public Counter(int value) {
        this.value = value;
        accumulator = 0;
    }

    /** This method returns the accumulated value of the Counter
     @return value the integer accumulated value
     */
    public int getValue() { return value; }

    /** This method add the parameter to the accumulator value
     @param amt amount to be added to value
     */
    public void add(int amt) { value += amt; }

    /** This method subtracts the parameter to the accumulator value
     @param amt amount to be subtracted to value
     */
    public void subtract(int amt) {
        value -= amt;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void collectAll (int amt) {
        value = amt * accumulator;
        accumulator = 0;
    }
    public void decrementAccumulator () {
        accumulator--;
    }

    public void incrementAccumulator () {
        accumulator++;
    }
    private int accumulator;
    private int value;
}
