package hospital.management.system;

import hospital.management.conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class patient_discharge extends JFrame {

    // UI Components
    Choice choice;
    JLabel RNo, INTime, OUTTime;
    JButton discharge, check, back;

    // Constructor
    public patient_discharge() {
        setTitle("Patient Discharge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(880, 400);
        setLayout(null);
        setLocation(400, 250);

        // Panel Setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 860, 350);
        panel.setBackground(new Color(98, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Header Label
        JLabel header = new JLabel("Patient Check-Out");
        header.setBounds(350, 20, 200, 30);
        header.setFont(new Font("Tahoma", Font.BOLD, 20));
        header.setForeground(Color.black);
        panel.add(header);

        // Customer ID Label & Choice
        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(30, 80, 150, 25);
        customerIdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        customerIdLabel.setForeground(Color.black);
        panel.add(customerIdLabel);

        choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("number"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching Patient IDs!");
        }

        // Room Number Label
        JLabel roomLabel = new JLabel("Room Number:");
        roomLabel.setBounds(30, 130, 150, 25);
        roomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomLabel.setForeground(Color.black);
        panel.add(roomLabel);

        RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 25);
        RNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        RNo.setForeground(Color.black);
        panel.add(RNo);

        // Check-In Time Label
        JLabel inTimeLabel = new JLabel("Check-In Time:");
        inTimeLabel.setBounds(30, 180, 150, 25);
        inTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        inTimeLabel.setForeground(Color.black);
        panel.add(inTimeLabel);

        INTime = new JLabel();
        INTime.setBounds(200, 180, 250, 25);
        INTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        INTime.setForeground(Color.black);
        panel.add(INTime);

        // Check-Out Time Label
        JLabel outTimeLabel = new JLabel("Out-Time:");
        outTimeLabel.setBounds(30, 230, 150, 25);
        outTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        outTimeLabel.setForeground(Color.black);
        panel.add(outTimeLabel);

        Date date = new Date();
        OUTTime = new JLabel("" + date);
        OUTTime.setBounds(200, 230, 250, 25);
        OUTTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        OUTTime.setForeground(Color.black);
        panel.add(OUTTime);

        // Buttons
        discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);

        check = new JButton("Check");
        check.setBounds(170, 300, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);

        back = new JButton("Back");
        back.setBounds(310, 300, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);

        // Action Listeners
        discharge.addActionListener(e -> handleDischarge());
        check.addActionListener(e -> handleCheck());
        back.addActionListener(e -> setVisible(false));

        setVisible(true);
    }

    // Handle Discharge Action
    private void handleDischarge() {
        conn c = new conn();
        try {
            c.statement.executeUpdate("DELETE FROM Patient_Info WHERE number = '" + choice.getSelectedItem() + "'");
            c.statement.executeUpdate("UPDATE room SET Availability='Available' WHERE room_no = '" + RNo.getText() + "'");
            JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
            setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error processing discharge!");
        }
    }

    // Handle Check Action
    private void handleCheck() {
        conn c = new conn();
        try {
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info WHERE number = '" + choice.getSelectedItem() + "'");
            while (resultSet.next()) {
                RNo.setText(resultSet.getString("Room_Number"));
                INTime.setText(resultSet.getString("Time"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching patient details!");
        }
    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
