package hospital.management;

import hospital.management.system.*;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Reception extends JFrame {

    public Reception() {
        setTitle("Hospital Management System - Reception");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Top Panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        // Main Panel
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5, 160, 1525, 670);
        panel2.setBackground(new Color(109, 164, 170));
        add(panel2);

        // Doctor Icon
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/dr1.png"));
            Image img1 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            JLabel label1 = new JLabel(new ImageIcon(img1));
            label1.setBounds(1300, 0, 250, 250);
            panel1.add(label1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Doctor Icon not found: " + ex.getMessage());
        }

        // Ambulance Icon
        try {
            ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icon/amb1.png"));
            Image img2 = i2.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH);
            JLabel label2 = new JLabel(new ImageIcon(img2));
            label2.setBounds(1000, 50, 300, 100);
            panel1.add(label2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ambulance Icon not found: " + ex.getMessage());
        }

        // Buttons
        addButton(panel1, "Add New Patient", 30, 15, e -> new NEW_PATIENT());
        addButton(panel1, "Room", 30, 58, e -> new Room());
        addButton(panel1, "Department", 30, 100, e -> new Department());
        addButton(panel1, "All Employee Info", 270, 15, e -> new Employee_info());
        addButton(panel1, "Patient Info", 270, 58, e -> new ALL_Patient_Info());
        addButton(panel1, "Patient Discharge", 270, 100, e -> new patient_discharge());
        addButton(panel1, "Update Patient Details", 510, 15, e -> new update_patient_details());
        addButton(panel1, "Hospital Ambulance", 510, 58, e -> new Ambulance());
        addButton(panel1, "Search Room", 510, 100, e -> new SearchRoom());
        addButton(panel1, "Logout", 750, 15, e -> {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                dispose();
                //new Login(); // Assuming Login class exists
            }
        });

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    /**
     * Helper method to add buttons to the panel.
     */
    private void addButton(JPanel panel, String text, int x, int y, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 30);
        button.setBackground(new Color(246, 215, 118));
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.addActionListener(actionListener);
        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Reception::new);
    }
}
