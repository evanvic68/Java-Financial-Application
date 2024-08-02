import Model.*;

import java.util.*;

public class TestHarness {
    public TestHarness(){
        testEmployeeClass();
        testAssetClass();
        testInheritanceandInterface();
        //testLinkedList();
    }

    public void testEmployeeClass(){
        Employee e1 = new Employee();

        System.out.println("Testing Employee Class Getters.");
        System.out.println(e1.getName());
        System.out.println(e1.getBirthDate());
        System.out.println(e1.getAge());
        System.out.println(e1.getJobName());
        System.out.println(e1.getJobHoursWorked());
        System.out.println(e1.getHourlyPay());
        System.out.println("First toString method test: ");
        System.out.println(e1.toString());
        System.out.println("Employee Salary: $" + e1.calculateSalary(e1.getJobHoursWorked(), e1.getHourlyPay()));

        System.out.println("Testing parameterized constructor");
        Employee e2 = new Employee("Tim", 2002, 21,  "Help Desk Specialist", 40, 27);
        System.out.println(e2);

        System.out.println("Testing setter methods.");
        e1.setName("Steven");
        e1.setBirthDate(2001);
        e1.setAge(22);
        e1.setJobName("IT Specialist");
        e1.setJobHoursWorked(40);
        e1.setHourlyPay(32);
        System.out.println("Second toString method test: ");
        System.out.println(e1.toString());
        System.out.println("Employee Salary: $" + e1.calculateSalary(e1.getJobHoursWorked(), e1.getHourlyPay()));

    }
    public void testAssetClass(){
        Asset a1 = new Asset();

        System.out.println("Testing Asset Class Getters.");
        System.out.println(a1.getAssetName());
        System.out.println(a1.getAssetType());
        System.out.println(a1.getEstimatedYearlyIncome());
        System.out.println(a1.getIncomeRate());
        System.out.println("First toString method test: ");
        System.out.println(a1.toString());

        System.out.println("Testing parameterized constructor");
        Asset a2 = new Asset("Apple Stock", "Stock", 200, 1.5);
        System.out.println(a2);

        System.out.println("Testing setter methods.");
        a1.setAssetName("SPDR Income Fund");
        a1.setAssetType("ETF");
        a1.setEstimatedYearlyIncome(300);
        a1.setIncomeRate(3.75);
        System.out.println("Second toString method test: ");
        System.out.println(a1.toString());
    }

    public void testInheritanceandInterface(){
        ArrayList<Liability> listOne = new ArrayList<>();

        Liability billOne = new Bill();
        Liability LoanOne = new Loan();

        listOne.add(billOne);
        listOne.add(LoanOne);

        System.out.println(listOne.get(0));
        System.out.println(listOne.get(1));

        System.out.println("Making payments.");
        billOne.somePayment();
        LoanOne.somePayment();

        listOne.clear();
        listOne.add(billOne);
        listOne.add(LoanOne);

        System.out.println(listOne.get(0));
        System.out.println(listOne.get(1));
    }
}
