import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.table.*;

public class UserManagement implements ActionListener {
    UserDatabase ud=new UserDatabase();
    String columns[] = {"id", "username", "password"};
    JButton deleteUserButton;
    JButton addUserButton;
    public JTable usersTable;
    JFrame frame;
    String data[][];
    private DefaultTableModel model;

    UserManagement()throws Exception
    {
        {
            Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
    
            frame = new JFrame("User Management");
            frame.setSize(1200,700);
            frame.setLayout(null);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            data = ud.getData();
            
            model = new DefaultTableModel(data, columns);
            usersTable = new JTable(model);
            usersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            
            //usersTable=new JTable(data,columns);
            usersTable.setBounds(30,40,1100,600);
            usersTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
            usersTable.getTableHeader().setOpaque(false);
            usersTable.getTableHeader().setBackground(new Color(32,136,203));
            usersTable.getTableHeader().setForeground(new Color(255,255,255));
            usersTable.setRowHeight(25);
            JScrollPane scrollPane = new JScrollPane(usersTable);
    
            addUserButton=new JButton("Add User");
            
            addUserButton.setBounds(40, 610, 130, 20);
            addUserButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            deleteUserButton=new JButton("Delete User");
            deleteUserButton.setBounds(990, 610, 130, 20);
            deleteUserButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            addUserButton.addActionListener(this);
            deleteUserButton.addActionListener(this);

            JPanel viewPanel = new JPanel();
            viewPanel.setBounds(20,20,1160, 570);
            viewPanel.setBorder(border);
            viewPanel.setLayout(new GridLayout(1,1));
            viewPanel.add(scrollPane);

            frame.add(viewPanel);
            frame.add(addUserButton);
            frame.add(deleteUserButton);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedUserId;
        int column = 0;
        int row;

        if(e.getSource()==addUserButton)
        {
            new AddNewUser(usersTable);
            //update table at runtime
        }
        else if(e.getSource()==deleteUserButton)
        {
            column = 0;
            row = usersTable.getSelectedRow();
            selectedUserId = usersTable.getModel().getValueAt(row, column).toString();
            ud.deleteUser(selectedUserId);
            try {
                data = ud.getData();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            model.removeRow(usersTable.getSelectedRow());
        }
    }
}
