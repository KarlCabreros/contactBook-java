package contactBook.gui.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class EditContactDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField contactNameField;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JTextField simCardTypeField;
    private int rowIndex;
    private DefaultTableModel tableModel;

    public EditContactDialog(Frame parent, DefaultTableModel tableModel, int rowIndex, String name, String phoneNumber, String email, String simCardType) {
        super(parent, "Edit Contact", true);
        this.tableModel = tableModel;
        this.rowIndex = rowIndex;

        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 300);
        setLocationRelativeTo(parent);

        add(new JLabel("Contact Name:"));
        contactNameField = new JTextField(name);
        add(contactNameField);

        add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField(phoneNumber);
        add(phoneNumberField);

        add(new JLabel("Email:"));
        emailField = new JTextField(email);
        add(emailField);

        add(new JLabel("Simcard Type:"));
        simCardTypeField = new JTextField(simCardType);
        add(simCardTypeField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveContact();
            }
        });
        add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelButton);
    }

    private void saveContact() {
        String newName = contactNameField.getText();
        String newPhoneNumber = phoneNumberField.getText();
        String newEmail = emailField.getText();
        String newSimCardType = simCardTypeField.getText();

        tableModel.setValueAt(newName, rowIndex, 0);
        tableModel.setValueAt(newPhoneNumber, rowIndex, 1);
        tableModel.setValueAt(newEmail, rowIndex, 2);
        tableModel.setValueAt(newSimCardType, rowIndex, 3);

        dispose();
    }
}
