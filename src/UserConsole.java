import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class UserConsole implements ActionListener{
    JButton feesButton;
    JButton viewButton;
    JButton updateButton;
    JButton registerButton;
    JButton signoutButton;
    JFrame frame;

    UserConsole(String username) 
    {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
        frame = new JFrame("User Management Console : "+username);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(9, 112, 222));
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);

        JPanel managementPanel = new JPanel();
        managementPanel.setBounds(95,80,600,400);
        managementPanel.setBorder(border);
        managementPanel.setLayout(new GridLayout(2,2));

        registerButton = new JButton("Register");
        registerButton.setSize(150,150);
        registerButton.setMargin(new Insets(50, 50, 50, 50));
        registerButton.setBorder(border);

        viewButton = new JButton("View");
        viewButton.setMargin(new Insets(50, 50, 50, 50));
        viewButton.setSize(150,150);
        viewButton.setBorder(border);

        updateButton = new JButton("Update");
        updateButton.setSize(150,150);
        updateButton.setMargin(new Insets(50, 50, 50, 50));
        updateButton.setBorder(border);

        feesButton = new JButton("Fees Management");
        feesButton.setSize(150,150);
        feesButton.setMargin(new Insets(50, 50, 50, 50));
        feesButton.setBorder(border);

        signoutButton = new JButton("Sign Out");
        signoutButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        signoutButton.setBounds(620, 520, 120, 20);

        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        registerButton.addActionListener(this);
        feesButton.addActionListener(this);
        signoutButton.addActionListener(this);

        managementPanel.add(registerButton);
        managementPanel.add(viewButton);
        managementPanel.add(updateButton);
        managementPanel.add(feesButton);
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