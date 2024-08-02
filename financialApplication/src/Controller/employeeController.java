package Controller;

import Model.Employee;
import View.financeView;

import javax.swing.*;
import java.io.IOException;

public class employeeController {
    private Employee e1;
    private financeView view;
    private objectUtil u1;

    public employeeController(financeView view){
        e1 = new Employee();
        this.view = view;

        view.form().getEmployeeNametxt().setText(e1.getName());
        view.form().getEmployeeBirthDatetxt().setText(Integer.toString(e1.getBirthDate()));
        view.form().getEmployeeAgetxt().setText(Integer.toString(e1.getAge()));
        view.form().getJobNametxt().setText(e1.getJobName());
        view.form().getEmployeeWeeklyHourstxt().setText(Double.toString(e1.getJobHoursWorked()));
        view.form().getEmployeeHourlyPaytxt().setText(Double.toString(e1.getHourlyPay()));

        view.form().getUpdateButtonThree().addActionListener(e -> {
            e1.setName(view.form().getEmployeeNametxt().getText());
            e1.setBirthDate(Integer.parseInt(view.form().getEmployeeBirthDatetxt().getText()));
            e1.setAge(Integer.parseInt(view.form().getEmployeeAgetxt().getText()));
            e1.setJobName(view.form().getJobNametxt().getText());
            e1.setJobHoursWorked(Double.parseDouble(view.form().getEmployeeWeeklyHourstxt().getText()));
            e1.setHourlyPay(Double.parseDouble(view.form().getEmployeeHourlyPaytxt().getText()));

            /*
            try {
                u1.writeEmployeeFile(e1, "employeeInfo.ser");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            */

            System.out.println(e1);
        });

        view.form().getQuitButtonThree().addActionListener(e -> {
            System.exit(0);
        });

        view.form().getCalculateSalaryButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Your annual salary is: " + e1.calculateSalary(e1.getJobHoursWorked(), e1.getHourlyPay()));
        });

    }
}
