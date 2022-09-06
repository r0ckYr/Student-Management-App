import java.awt.Font;
import java.awt.Color;
// import java.awt.FlowLayout;
// import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class AddNewUser implements ActionListener{
    
    JFrame frame;
    JButton addUserButton;
    JButton cancleButton;
    JLabel addUserLabel;
    JTextField userField;
    JTextField passField;
    JTextField confirmPassField;
    JLabel errorLabel;
    JTable usersTable;
    public String username;
    public String password;
    public String confirmPassword;
    public String userId;

    boolean isValid = false;

    AddNewUser(JTable usersTable)
    {
        this.usersTable = usersTable;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        frame = new JFrame("Add New User");
        frame.setLayout(null);
        frame.setSize(600,450);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        //header
        addUserLabel = new JLabel("Add New User");
        addUserLabel.setBounds(195,0, 450,180); 
        addUserLabel.setFont(new Font("MV Boli", Font.PLAIN, 32));

        //login panel
        JPanel addUserPanel = new JPanel();
        addUserPanel.setBounds(50, 35, 500, 300);
        addUserPanel.setBorder(border);
        addUserPanel.setVisible(true);
        addUserPanel.setLayout(null);

        //inputs
        JLabel userLabel = new JLabel("Username: ");
        JLabel passLabel = new JLabel("Password: ");
        JLabel confirmPassLabel = new JLabel("Confirm Password: ");
        userLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
        passLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
        confirmPassLabel.setFont(new Font("MV Boli", Font.PLAIN, 22));
        userLabel.setBounds(70,70, 150, 50);
        passLabel.setBounds(70,130, 150, 50);
        confirmPassLabel.setBounds(20,190, 350, 50);

        userField = new JTextField();
        passField = new JTextField();
        confirmPassField = new JTextField();
        userField.setBounds(235,85, 200,25);
        passField.setBounds(235,143, 200,25);
        confirmPassField.setBounds(235,203, 200,25);

        addUserPanel.add(userLabel);
        addUserPanel.add(passLabel);
        addUserPanel.add(confirmPassLabel);

        addUserPanel.add(userField);
        addUserPanel.add(passField);
        addUserPanel.add(confirmPassField);

        //buttons
        addUserButton = new JButton("Add User");
        cancleButton = new JButton("Cancle");
        addUserButton.setBounds(70, 360, 120, 20);
        cancleButton.setBounds(400, 360, 120, 20);
        cancleButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        addUserButton.setFont(new Font("MV Boli", Font.PLAIN, 18));

        cancleButton.addActionListener(this);
        addUserButton.addActionListener(this);

        //error invalid credentials
        errorLabel = new JLabel("Confirmation password don not match");
        errorLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(70,243, 350, 20);
        errorLabel.setVisible(false);

        frame.add(cancleButton);
        frame.add(addUserButton);
        addUserPanel.add(errorLabel);

        frame.add(addUserLabel);
        frame.add(addUserPanel);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addUserButton) {
            
            username = userField.getText();
            password = passField.getText();
            confirmPassword = confirmPassField.getText();
            if(password.equals(confirmPassword))
            {
                userField.setText("");
                passField.setText("");
                confirmPassField.setText("");
                UserDatabase ud;
                try {
                    ud = new UserDatabase();
                    userId = Integer.toString(ud.addUser(username, password)+1);
                    errorLabel.setForeground(Color.GREEN);
                    DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
                    model.addRow(new Object[]{userId, username, password});
                    errorLabel.setText("User Created");
                    errorLabel.setBounds(170,243, 350, 20);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
            else{
                errorLabel.setBounds(70,243, 350, 20);
                errorLabel.setText("Confirmation password don not match");
                errorLabel.setForeground(Color.RED);
            }
            errorLabel.setVisible(true);
		}
        
        else if(e.getSource()==cancleButton)
        {
            frame.dispose();
        }   
        
    }
}
