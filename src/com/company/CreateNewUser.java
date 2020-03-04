package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CreateNewUser implements MenuOption {
    JFrame mainFrame, secondaryFrame;
    JLabel firstNameLabel;
    JLabel surnameLabel;
    JLabel pPPSLabel;
    JLabel dOBLabel;

    JTextField firstNameTextField;
    JTextField surnameTextField;
    JTextField pPSTextField;
    JTextField dOBTextField;

    JPanel options;
    JPanel panel2;
    JButton add;

    String PPS;
    String firstName;
    String surname;
    String DOB;
    String CustomerID;
    private String password;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public CreateNewUser() {
    }

    public CreateNewUser(String PPS, String firstName, String surname, String DOB, String customerID, String password) {
        this.PPS = PPS;
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        CustomerID = customerID;
        this.password =  password;
    }

    @Override
    public void createUserOption() {
        mainFrame = new JFrame("Create New Customer");
        mainFrame.setSize(400, 300);
        mainFrame.setLocation(200, 200);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });
        Container content = mainFrame.getContentPane();
        content.setLayout(new BorderLayout());

        firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
        pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
        dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
        firstNameTextField = new JTextField(20);
        surnameTextField = new JTextField(20);
        pPSTextField = new JTextField(20);
        dOBTextField = new JTextField(20);
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(firstNameLabel);
        panel.add(firstNameTextField);
        panel.add(surnameLabel);
        panel.add(surnameTextField);
        panel.add(pPPSLabel);
        panel.add(pPSTextField);
        panel.add(dOBLabel);
        panel.add(dOBTextField);

        options= new JPanel();
        add = new JButton("Add");

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                PPS = pPSTextField.getText();
                firstName = firstNameTextField.getText();
                surname = surnameTextField.getText();
                DOB = dOBTextField.getText();
                password = "";

                CustomerID = "ID"+PPS ;

                add.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {


                            password = JOptionPane.showInputDialog(secondaryFrame, "Enter 7 character Password;");

                            if(password.length() < 7)//Making sure password is 7 characters
                            {
                                JOptionPane.showMessageDialog(null, null, "Password must be 7 characters long", JOptionPane.OK_OPTION);
                            }

                        ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
                        Customer customer = new Customer(PPS, surname, firstName, DOB, CustomerID, password, accounts);

                        customerList.add(customer);

                        JOptionPane.showMessageDialog(secondaryFrame, "CustomerID = " + CustomerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
//                        menuStart();
                        mainFrame.dispose();
                    }
                });
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
//                menuStart();
            }
        });

        options.add(add);
        options.add(cancel);

        content.add(panel, BorderLayout.CENTER);
        content.add(options, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }
}
