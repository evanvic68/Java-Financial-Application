package Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LiabilityTest {

    @Test
    void getLiabilityName() {
        Liability l1 = new Liability();
        l1.setLiabilityName("Toyota RAV4");
        assertEquals("Toyota RAV4", l1.getLiabilityName());
    }

    @Test
    void getLiabilityType() {
        Liability l1 = new Liability();
        l1.setLiabilityType("Car");
        assertEquals("Toyota RAV4", l1.getLiabilityType());
    }

    @Test
    void getEstimateYearlyInterest() {
        Liability l1 = new Liability();
        l1.setEstimateYearlyInterest(20);
        assertEquals(20, l1.getEstimateYearlyInterest());
    }

    @Test
    void getInterestRate() {
        Liability l1 = new Liability();
        l1.setInterestRate(1.25);
        assertEquals(1.25, l1.getInterestRate());
    }

    @Test
    void setLiabilityName() {
        Liability l1 = new Liability();
        l1.setLiabilityName("Toyota RAV4");
        assertEquals("Toyota RAV4", l1.getLiabilityName());
    }

    @Test
    void setLiabilityType() {
        Liability l1 = new Liability();
        l1.setLiabilityName("Toyota RAV4");
        assertEquals("Toyota RAV4", l1.getLiabilityName());
    }

    @Test
    void setEstimateYearlyInterest() {
        Liability l1 = new Liability();
        l1.setLiabilityName("Toyota RAV4");
        assertEquals("Toyota RAV4", l1.getLiabilityName());
    }

    @Test
    void setInterestRate() {
        Liability l1 = new Liability();
        l1.setLiabilityName("Toyota RAV4");
        assertEquals("Toyota RAV4", l1.getLiabilityName());
    }

    @Test
    void testToString() {
        Liability l1 = new Liability();
        String toString = "Liability: " + l1.getLiabilityName() + "\n Liability Type: " + l1.getLiabilityType() + "\n Estimated Yearly Interest: " + l1.getEstimateYearlyInterest() + "\n Interest Rate: " + l1.getInterestRate();
        assertEquals(toString, l1.toString());
    }
}