package contactBook.gui.com;

import javax.swing.*;
import java.awt.*;

public class ViewContactDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewContactDialog(Frame parent, String name, String phoneNumber, String email, String simCardType) {
        super(parent, "View Contact", true);

        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 300);
        setLocationRelativeTo(parent);

        add(new JLabel("Contact Name:"));
        JTextField contactNameField = new JTextField(name);
        contactNameField.setEditable(false);
        add(contactNameField);

        add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField(phoneNumber);
        phoneNumberField.setEditable(false);
        add(phoneNumberField);

        add(new JLabel("Email:"));
        JTextField emailField = new JTextField(email);
        emailField.setEditable(false);
        add(emailField);

        add(new JLabel("Simcard Type:"));
        JTextField simCardTypeField = new JTextField(simCardType);
        simCardTypeField.setEditable(false);
        add(simCardTypeField);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton);
    }
}
