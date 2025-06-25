package main;

public class Counter {
    public Counter() { value = 0; }

    public Counter(int value) { this.value = value; }

    public int getValue() { return value; }

    public void add(int amt) { value += amt; }

    public void subtract(int amt) {
        value -= amt;
    }

    private int value;
}
