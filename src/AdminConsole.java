import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

public class AdminConsole implements ActionListener{
    JButton registerButton;
    JButton updateButton;
    JButton feesButton;
    JButton viewButton;
    JButton userButton;
    JButton deleteButton;

    JButton signoutButton;
    JFrame frame;

    AdminConsole(String username)
    {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
        frame = new JFrame("Admin Management Console : "+username);
        frame.setLayout(null);
        frame.setSize(900,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);

        JPanel managementPanel = new JPanel();
        managementPanel.setBounds(100,80,700,450);
        managementPanel.setBorder(border);
        managementPanel.setLayout(new GridLayout(2,2));

        registerButton = new JButton("Register");
        registerButton.setSize(100,100);
        registerButton.setMargin(new Insets(50, 50, 50, 50));
        registerButton.setBorder(border);

        viewButton = new JButton("View");
        viewButton.setMargin(new Insets(50, 50, 50, 50));
        viewButton.setSize(100,100);
        viewButton.setBorder(border);

        updateButton = new JButton("Update");
        updateButton.setSize(100,100);
        updateButton.setMargin(new Insets(50, 50, 50, 50));
        updateButton.setBorder(border);

        feesButton = new JButton("Fees Management");
        feesButton.setSize(100,100);
        feesButton.setMargin(new Insets(50, 50, 50, 50));
        feesButton.setBorder(border);

        userButton = new JButton("User Management");
        userButton.setSize(100,100);
        userButton.setMargin(new Insets(50, 50, 50, 50));
        userButton.setBorder(border);

        deleteButton = new JButton("Delete");
        deleteButton.setSize(100,100);
        deleteButton.setMargin(new Insets(50, 50, 50, 50));
        deleteButton.setBorder(border);

        signoutButton = new JButton("Sign Out");
        signoutButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        signoutButton.setBounds(740, 570, 120, 20);


        viewButton.addActionListener(this);
        registerButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        feesButton.addActionListener(this);
        userButton.addActionListener(this);
        signoutButton.addActionListener(this);

        managementPanel.add(registerButton);
        managementPanel.add(viewButton);
        managementPanel.add(updateButton);
        managementPanel.add(deleteButton);
        managementPanel.add(feesButton);
        managementPanel.add(userButton);
        frame.add(signoutButton);
        frame.add(managementPanel);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewButton)
        {
            try{
                new ViewData();
            }catch(Exception eview){}
        }
        else if(e.getSource()==registerButton)
        {
            new RegisterStudent();
        }

        else if(e.getSource()==updateButton)
        {
            try {
                new UpdateStudent();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        else if(e.getSource()==feesButton)
        {
            try {
                new FeesManagement();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==userButton)
        {
            try {
                new UserManagement();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==deleteButton)
        {
            try {
                new DeleteStudent();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==signoutButton)
        {
            int height = 600;
            int width = 800;
            String header = "User Login";
            frame.dispose();
            new LoginFrame(height, width, header);
        }
    }
}