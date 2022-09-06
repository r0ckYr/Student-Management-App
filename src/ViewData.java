import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class ViewData implements ActionListener,FocusListener{
    StudentDatabase sd = new StudentDatabase();
    public final String columns[] = {"Id", "Name", "Mobile Number", "Age", "Date of Birth", "Course", "Course Duration", "Start Date", "End Date", "Father's Name", "Mother's Name", "Address", "Fees/Month", "Total Fees", "Fees Paid"};
    JTextField searchField;
    JTextField focusTextfield;
    JButton searchButton;
    DefaultTableModel tableModel;
    JComboBox<String> searchMenu;
    JTable studentsTable;
    JButton showAllButton;

    ViewData()throws Exception
    {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);

        JFrame frame = new JFrame("View Students");
        frame.setSize(1300,740);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String data[][] = sd.getData();
        
        tableModel = new DefaultTableModel(data, columns);
        studentsTable=new JTable(tableModel);
        studentsTable.setBounds(30,40,1100,600);
        studentsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        studentsTable.getTableHeader().setOpaque(false);
        studentsTable.getTableHeader().setBackground(new Color(32,136,203));
        studentsTable.getTableHeader().setForeground(new Color(255,255,255));
        studentsTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(studentsTable);

        JPanel viewPanel = new JPanel();
        viewPanel.setBounds(20,50,1260, 620);
        viewPanel.setBorder(border);
        viewPanel.setLayout(new GridLayout(1,1));
        viewPanel.add(scrollPane);

        //search menu
        searchMenu = new JComboBox<String>(columns);
        searchMenu.setVisible(true);
        searchMenu.setBounds(30, 10, 150, 26);

        searchField = new JTextField();
        searchField.setBounds(230, 10, 150, 26);
        searchField.addFocusListener(this);
        searchField.setText("Search...");

        searchButton = new JButton("Search");
        searchButton.setBounds(430, 10, 100, 26);
        searchButton.addActionListener(this);
        
        showAllButton = new JButton("Show All");
        showAllButton.setBounds(1150, 10, 100, 26);
        showAllButton.addActionListener(this);
        
        frame.add(viewPanel);
        frame.add(searchMenu);
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(showAllButton);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchButton)
        {
            String searchText;
            int searchColumn;
            
            searchText = searchField.getText();
            searchColumn = searchMenu.getSelectedIndex();
            try {
                String filteredData[][] = sd.getFilteredData(searchColumn, searchText);
                int rows = tableModel.getRowCount(); 
                for(int i = rows - 1; i >=0; i--)
                {
                    tableModel.removeRow(i); 
                }
                tableModel.setNumRows(0);
                for(int i=0;i<filteredData.length;i++)
                {
                    if(filteredData[i][0]==null)
                        break;
                    tableModel.addRow(filteredData[i]);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==showAllButton)
        {
            searchField.setText("Search...");
            searchMenu.setSelectedIndex(0);
            try {
                String data[][] = sd.getData();
                int rows = tableModel.getRowCount(); 
                for(int i = rows - 1; i >=0; i--)
                {
                    tableModel.removeRow(i); 
                }
                tableModel.setNumRows(0);
                for(int i=0;i<data.length;i++)
                {
                    if(data[i][0]==null)
                        break;
                    tableModel.addRow(data[i]);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        focusTextfield = (JTextField) e.getSource();
        if(e.getSource()==searchField)
        {
            if(searchField.getText().equals("Search..."))
                focusTextfield.setText("");
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        focusTextfield = (JTextField) e.getSource();
        if(e.getSource()==searchField)
        {
            if(searchField.getText().equals(""))
                focusTextfield.setText("Search...");
        }
    }
}
