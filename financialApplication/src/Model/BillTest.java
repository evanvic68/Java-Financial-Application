package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    @Test
    void getBillFrequency() {
        Bill b1 = new Bill();
        b1.setBillFrequency(1);
        assertEquals(1, b1.getBillFrequency());
    }

    @Test
    void getBillCost() {
        Bill b1 = new Bill();
        b1.setBillCost(0);
        assertEquals(0, b1.getBillCost());
    }


    @Test
    void setBillFrequency() {
        Bill b1 = new Bill();
        b1.setBillFrequency(1);
        assertEquals(1, b1.getBillFrequency());
    }

    @Test
    void setBillCost() {
        Bill b1 = new Bill();
        b1.setBillCost(0);
        assertEquals(0, b1.getBillCost());
    }

    @Test
    void testToString() {
        Bill b1 = new Bill();
        String toString = "\n Bill Frequency: " + b1.getBillFrequency() + "\n Cost: " + b1.getBillCost();
        assertEquals(toString, b1.toString());
    }
}