package Model;

import java.io.*;

public class Employee implements Serializable {
    private String name;
    private int birthDate;
    private int age;
    private String jobName;
    private double jobHoursWorked;
    private double hourlyPay;

    public Employee(String name, int birthDate, int age, String jobName, double jobHoursWorked, double hourlyPay) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.jobName = jobName;
        this.jobHoursWorked = jobHoursWorked;
        this.hourlyPay = hourlyPay;
    }

    public Employee(){
        name = "name";
        birthDate = 0;
        age = 0;
        jobName = "jobName";
        jobHoursWorked = 0;
        hourlyPay = 0;
    }

    public double calculateSalary(double hours, double hourlyPay){
        return (hours * 52) * hourlyPay;
    }

    public String getName() {
        return name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public String getJobName() {
        return jobName;
    }

    public double getJobHoursWorked() {
        return jobHoursWorked;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setJobHoursWorked(double jobHoursWorked) {
        this.jobHoursWorked = jobHoursWorked;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    @Override
    public String toString(){
        return " Employee name: " + name + "\n Birth Date: " + birthDate + "\n Age: " + age + "\n Job Title: " + jobName + "\n Standard hours per week: "+ jobHoursWorked + "\n Hourly Pay: $" + hourlyPay;
    }
}
