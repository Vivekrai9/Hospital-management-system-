package hospital.management.system;

import hospital.management.conn;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    public Employee_info() {

        // Create panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        // Create table
        JTable table = new JTable();
        table.setBounds(18, 34, 980, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        // Fetch data for table
        try {
            conn c = new conn();
            String query = "SELECT * FROM EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add labels
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(41, 9, 70, 20);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelName);

        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(180, 9, 70, 20);
        labelAge.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelAge);

        JLabel labelPhone = new JLabel("Phone Number");
        labelPhone.setBounds(350, 9, 150, 20);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelPhone);

        JLabel labelSalary = new JLabel("Salary");
        labelSalary.setBounds(550, 9, 150, 20);
        labelSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelSalary);

        JLabel labelGmail = new JLabel("Gmail");
        labelGmail.setBounds(730, 9, 150, 20);
        labelGmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelGmail);

        JLabel labelAadhar = new JLabel("Aadhar Number");
        labelAadhar.setBounds(830, 9, 150, 20);
        labelAadhar.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelAadhar);

        // Add Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(410, 500, 120, 30); // Center horizontally
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
            }
        });
        panel.add(backButton);

        // Frame settings
        setUndecorated(true);
        setSize(1000, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
