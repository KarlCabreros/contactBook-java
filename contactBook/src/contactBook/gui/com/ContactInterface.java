package contactBook.gui.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class ContactInterface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel model; 
    private JTable tableList;

    public static void main(String[] args) {
        // Schedules the creation and display of the ContactInterface frame to run on the Event Dispatch Thread (EDT)
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create an instance of ContactInterface, which is presumably a JFrame
                    ContactInterface frame = new ContactInterface();
                    // Make the frame visible
                    frame.setVisible(true);
                    // Make the frame non-resizable
                    frame.setResizable(false);
                } catch (Exception e) {
                    // Print the stack trace if an exception occurs
                    e.printStackTrace();
                }
            }
        });
    }

    public ContactInterface() {
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1058, 772);

        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 580, 721); 
        contentPane.add(panel, BorderLayout.WEST); 
        
        GradientPanel gradientPanel =  new GradientPanel();
        gradientPanel.setBackground(new Color(30, 144, 255));
        contentPane.add(gradientPanel, BorderLayout.CENTER);
        gradientPanel.setLayout(null);
        
        JLabel TitleLabel = new JLabel("Contact Book");
        TitleLabel.setBounds(0, -38, 268, 197);
        TitleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
        TitleLabel.setForeground(Color.WHITE);
        TitleLabel.setIcon(new ImageIcon("C:\\Users\\Karl\\Downloads\\ImageComponent\\ContactBook icon.png"));
        gradientPanel.add(TitleLabel);
        
        JLabel ContactLabel = new JLabel("Contact name");
        ContactLabel.setBounds(27, 202, 136, 35);
        ContactLabel.setForeground(Color.WHITE);
        ContactLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(ContactLabel);
        
        JLabel PhoneNumLabel = new JLabel("Phone number");
        PhoneNumLabel.setBounds(194, 202, 144, 35);
        PhoneNumLabel.setForeground(Color.WHITE);
        PhoneNumLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(PhoneNumLabel);
        
        JLabel SimcarLabel = new JLabel("Simcard type");
        SimcarLabel.setBounds(620, 202, 144, 35);
        SimcarLabel.setForeground(Color.WHITE);
        SimcarLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(SimcarLabel);
        
        JLabel ActionsLabel = new JLabel("Actions");
        ActionsLabel.setBounds(905, 190, 80, 35);
        ActionsLabel.setForeground(Color.WHITE);
        ActionsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(ActionsLabel);
        
        JLabel EmailLabel = new JLabel(" Email address");
        EmailLabel.setBounds(390, 202, 152, 35);
        EmailLabel.setForeground(Color.WHITE);
        EmailLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(EmailLabel);
        
        JTextField SearchtextField = new JTextField();
        SearchtextField.setBounds(112, 145, 562, 35);
        SearchtextField.setBackground(Color.LIGHT_GRAY);
        SearchtextField.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gradientPanel.add(SearchtextField);
        SearchtextField.setColumns(10);
        
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.LIGHT_GRAY);
        scrollPane.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        scrollPane.setBounds(27, 235, 841, 480);
        gradientPanel.add(scrollPane);
        
     // Create a new JTable for displaying the information of contacts
        tableList = new JTable();
        tableList.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        // Define the table model with column names and empty datat. 
        // The process of managing the data in a table by providing methods to add, remove, and modify rows and columns.
        model = new DefaultTableModel(
                new Object[][]{}, // Empty data
                new String[]{"Name", "Number", "Email", "Simcard"} // Column names
        ) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                boolean valid = true;
                String errorMessage = "";

                switch (column) {
                    case 0: // Name column
                        if (!isValidName(aValue.toString())) {
                            valid = false;
                            errorMessage = "Invalid name. Please enter a valid contact name (only letters and spaces).";
                        }
                        break;
                    case 1: // Number column
                        if (!isValidNumber(aValue.toString())) {
                            valid = false;
                            errorMessage = "Invalid number. Please enter an 11-digit number.";
                        }
                        break;
                    case 2: // Email column
                        if (!isValidGmail(aValue.toString())) {
                            valid = false;
                            errorMessage = "Invalid email. Please enter a valid Gmail address.";
                        }
                        break;
                    case 3: // Simcard column
                        if (!isValidSimcardType(aValue.toString())) {
                            valid = false;
                            errorMessage = "Invalid simcard type. Please enter a valid type (Smart, Talk N Text, Globe, Dito, Gomo).";
                        }
                        break;
                }

                if (valid) {
                    super.setValueAt(aValue, row, column);
                } else {
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            }

            private boolean isValidName(String name) {
                String nameRegex = "^[A-Za-z]+( [A-Za-z]+){0,2}$";
                return name.matches(nameRegex);
            }

            private boolean isValidNumber(String number) {
                String numberRegex = "^\\d{11}$";
                return number.matches(numberRegex);
            }

            private boolean isValidGmail(String email) {
                String emailRegex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
                return email.matches(emailRegex);
            }

            private boolean isValidSimcardType(String simcardType) {
                String[] validTypes = {"Smart", "Talk N Text", "Globe", "Dito", "Gomo"};
                for (String type : validTypes) {
                    if (type.equalsIgnoreCase(simcardType)) {
                        return true;
                    }
                }
                return false;
            }
        };
        tableList.setModel(model);
        tableList.setBackground(Color.LIGHT_GRAY);
        scrollPane.setViewportView(tableList);
      // In this phase is Searching for the contacts connected with the SearchTextFields 
     // When the user click the search button with the SearchTextField are filled with the name of the contact it will display on the JTable the contact that you want to see 
        JButton SearchButton = new JButton("Search contact");
        
        // Add an ActionListener to the button to handle click events
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve the text from the search text field and trim any leading or trailing spaces
                String searchText = SearchtextField.getText().trim();
                
                if (!searchText.isEmpty()) {
                    // Get the table model from the JTable
                    DefaultTableModel tableModel = (DefaultTableModel) tableList.getModel();
                    
                    // Create a TableRowSorter to enable sorting and filtering on the table
                    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
                    
                    // Set the TableRowSorter on the JTable
                    tableList.setRowSorter(sorter);

                    // Create a RowFilter to match the search text against the data in the table
                    // The (?i) makes the search case-insensitive
                    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);

                    // Apply the RowFilter to the TableRowSorter
                    sorter.setRowFilter(rowFilter);
                } else {
                    // If the search text is empty, remove any existing RowFilter to show all rows
                    tableList.setRowSorter(null);
                }
            }
        });
        SearchButton.setBounds(684, 145, 184, 35);
        SearchButton.setForeground(Color.BLACK);
        SearchButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        SearchButton.setBackground(Color.WHITE);
        gradientPanel.add(SearchButton);

        // When the user click the Create button mapupunta sya sa create contact interface
        JButton CreateButton = new JButton("Create");
        CreateButton.setBounds(896, 228, 110, 33);
        CreateButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        CreateButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CreateContact createContact = new CreateContact(ContactInterface.this, model);
        		createContact.setVisible(true);
        		setVisible(false);
        		dispose();
        	}
        });
        gradientPanel.add(CreateButton);
        
     // When the user click the Edit button the ediTDialog will pop up on the screen the screen and you can edit the contact information
        JButton EditButton = new JButton("Edit");
        EditButton.setBounds(896, 271, 110, 35);

        // Add an ActionListener to the button to handle click events
        EditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the index of the selected row in the table
                int selectedRow = tableList.getSelectedRow();

                // Check if a row is actually selected
                if (selectedRow >= 0) {
                    // Retrieve current values from the selected row
                    String name = (String) tableList.getValueAt(selectedRow, 0);
                    String phoneNumber = (String) tableList.getValueAt(selectedRow, 1);
                    String email = (String) tableList.getValueAt(selectedRow, 2);
                    String simCardType = (String) tableList.getValueAt(selectedRow, 3);

                    // Create and show the edit dialog
                    // Pass the current frame (ContactInterface.this), the table model, the selected row, 
                    // and the current values to the dialog
                    EditContactDialog editDialog = new EditContactDialog(ContactInterface.this, model, selectedRow, name, phoneNumber, email, simCardType);
                    editDialog.setVisible(true);
                } else {
                    // If no row is selected, show an error message
                    JOptionPane.showMessageDialog(ContactInterface.this, "Please select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        EditButton.setForeground(Color.BLACK);
        EditButton.setBackground(Color.WHITE);
        EditButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        gradientPanel.add(EditButton);

        
     // When the user click a column or contact in the JTable and then click the delete buttton it will clear all of the information about the contact of a person 
        JButton DeleteButton = new JButton("Delete");
        DeleteButton.setBounds(896, 316, 110, 35);

        // Add an ActionListener to the button to handle click events
        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the indices of the selected rows in the table
                int[] selectedRows = tableList.getSelectedRows();

                // Check if at least one row is selected
                if (selectedRows.length > 0) {
                    // Iterate over selected rows in reverse order to avoid index changes
                    for (int i = selectedRows.length - 1; i >= 0; i--) {
                        // Remove the row from the table model
                        model.removeRow(selectedRows[i]);
                    }
                } else {
                    // If no rows are selected, show an error message
                    JOptionPane.showMessageDialog(null, "Please select at least one row to delete.");
                }
            }
        });
        DeleteButton.setForeground(Color.BLACK);
        DeleteButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        DeleteButton.setBackground(Color.WHITE);
        gradientPanel.add(DeleteButton);

        // When the user click the View Button you can see the information of the contact person and it read only
        JButton ViewButton = new JButton("View");

        // Add an ActionListener to the button to handle click events
        ViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the index of the selected row in the table
                int selectedRow = tableList.getSelectedRow();

                // Check if a row is actually selected
                if (selectedRow >= 0) {
                    // Retrieve current values from the selected row
                    String name = (String) tableList.getValueAt(selectedRow, 0);
                    String phoneNumber = (String) tableList.getValueAt(selectedRow, 1);
                    String email = (String) tableList.getValueAt(selectedRow, 2);
                    String simCardType = (String) tableList.getValueAt(selectedRow, 3);

                    // Create and show the view dialog
                    // Pass the current frame (ContactInterface.this) and the current values to the dialog
                    ViewContactDialog viewDialog = new ViewContactDialog(ContactInterface.this, name, phoneNumber, email, simCardType);
                    viewDialog.setVisible(true);
                } else {
                    // If no row is selected, show an error message
                    JOptionPane.showMessageDialog(ContactInterface.this, "Please select a row to view", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ViewButton.setBounds(896, 361, 110, 35);
        ViewButton.setForeground(Color.BLACK);
        ViewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        ViewButton.setBackground(Color.WHITE);
        gradientPanel.add(ViewButton);
}
    }