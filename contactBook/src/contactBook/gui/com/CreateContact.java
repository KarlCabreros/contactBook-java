package contactBook.gui.com;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class CreateContact extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField contactNameField;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JTextField simCardTypeField;
    private DefaultTableModel tableModel;
	private ContactInterface parentFrame;

    public CreateContact(ContactInterface parentFrame, DefaultTableModel tableModel) {
    	this.parentFrame = parentFrame;
    	this.tableModel = tableModel;
        initialize();
    }

    private void initialize() {
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setBounds(100, 100, 691, 778);

        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        GradientPanel gradientPanel = new GradientPanel();
        contentPane.add(gradientPanel, BorderLayout.CENTER);
        gradientPanel.setLayout(null);

        JLabel titleLabel = 
        		new JLabel("Create contact");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setIcon(new ImageIcon("C:\\Users\\Karl\\Downloads\\ImageComponent\\ContactBook icon.png"));
        titleLabel.setBounds(13, 9, 250, 137);
        gradientPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Contact name");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        nameLabel.setBounds(159, 182, 170, 44);
        gradientPanel.add(nameLabel);

        contactNameField = new JTextField();
        contactNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        contactNameField.setBounds(159, 237, 338, 35);
        gradientPanel.add(contactNameField);
        contactNameField.setColumns(10);

        JLabel phoneLabel = new JLabel("Phone number");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        phoneLabel.setBounds(159, 283, 170, 44);
        gradientPanel.add(phoneLabel);

        phoneNumberField = new JTextField();
        phoneNumberField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        phoneNumberField.setBounds(159, 338, 338, 35);
        gradientPanel.add(phoneNumberField);
        phoneNumberField.setColumns(10);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        emailLabel.setBounds(159, 384, 170, 44);
        gradientPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        emailField.setBounds(159, 438, 338, 35);
        gradientPanel.add(emailField);
        emailField.setColumns(10);

        JLabel simCardLabel = new JLabel("Simcard type");
        simCardLabel.setForeground(Color.WHITE);
        simCardLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        simCardLabel.setBounds(159, 485, 170, 44);
        gradientPanel.add(simCardLabel);

        simCardTypeField = new JTextField();
        simCardTypeField.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        simCardTypeField.setBounds(159, 540, 338, 35);
        gradientPanel.add(simCardTypeField);
        simCardTypeField.setColumns(10);

        // Create a JButton
        JButton addButton = new JButton("Add");
        addButton.setBounds(278, 600, 90, 35);
        gradientPanel.add(addButton);
        addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        // Added an action listener to handle the click event with the validation in the text fields for ContactName, PhoneNumber, Email, SimCard Type.
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String contactName = contactNameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String simCardType = simCardTypeField.getText();

                if (contactName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || simCardType.isEmpty()) {
                    JOptionPane.showMessageDialog(CreateContact.this, "Please fill in all required fields", "Error", JOptionPane.ERROR_MESSAGE);
                    
                } else if (!isValidContactName(contactName)) {
                    JOptionPane.showMessageDialog(CreateContact.this, "Please enter a valid contact name (only letters and one space between words)", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(CreateContact.this, "Please enter a valid 11-digit phone number", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(CreateContact.this, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidSimCardType(simCardType)) {
                    JOptionPane.showMessageDialog(CreateContact.this, "Please enter a valid simcard type (Smart, Talk N Text, Globe, Dito, Gomo)", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tableModel.addRow(new Object[]{contactName, phoneNumber, email, simCardType});
                    JOptionPane.showMessageDialog(CreateContact.this, "Contact added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    contactNameField.setText("");
                    phoneNumberField.setText("");
                    emailField.setText("");
                    simCardTypeField.setText("");
                }
            }
        });
        // Create a back button to ensure if the input data from the JFields of contact information is already went already in the JTable from ContactInmterface. 
        JButton backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        backButton.setBorder(null);
        backButton.setBounds(553, 61, 90, 35);
        gradientPanel.add(backButton);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	parentFrame.setVisible(true);
                dispose();
            }
        });
    }
    // This private boolean are the checker for valid inputs in ContactName,PhoenNumber,Email,SimCardType.
    private boolean isValidContactName(String contactName) {
        return contactName.matches("^[a-zA-Z]+(\\s[a-zA-Z]+(\\s[a-zA-Z]+)?)?$");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("09\\d{9}");
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidSimCardType(String simCardType) {
        String[] validSimCardTypes = {"Smart", "Talk N Text", "Globe", "Dito", "Gomo"};
        for (String type : validSimCardTypes) {
            if (type.equalsIgnoreCase(simCardType)) {
                return true;
            }
        }
        return false;
    }
}
