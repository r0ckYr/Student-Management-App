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

public class DeleteStudent implements ActionListener {
    StudentDatabase sd = new StudentDatabase();
    public final String columns[] = {"Id", "Name", "Mobile Number", "Age", "Date of Birth", "Course", "Course Duration", "Start Date", "End Date", "Father's Name", "Mother's Name", "Address", "Fees/Month", "Total Fees", "Fees Paid"};
    JFrame frame;
    JButton updateButton;
    public JTable studentsTable;
    private DefaultTableModel model;
    JButton cancleButton;
    String data[][];

    DeleteStudent()throws Exception
    {
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);

        frame = new JFrame("Delete Student");
        frame.setSize(1300,730);
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String data[][] = sd.getData();
        
        model = new DefaultTableModel(data, columns);
        studentsTable = new JTable(model);
        studentsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        studentsTable.setBounds(30,40,1100,600);
        studentsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        studentsTable.getTableHeader().setOpaque(false);
        studentsTable.getTableHeader().setBackground(new Color(32,136,203));
        studentsTable.getTableHeader().setForeground(new Color(255,255,255));
        studentsTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(studentsTable);

        updateButton = new JButton("Delete");
        cancleButton = new JButton("Cancle");
        updateButton.setBounds(90, 650, 100, 20);
        cancleButton.setBounds(1100, 650, 100, 20);
        cancleButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        updateButton.setFont(new Font("MV Boli", Font.PLAIN, 18));

        updateButton.addActionListener(this);
        cancleButton.addActionListener(this);

        JPanel viewPanel = new JPanel();
        viewPanel.setBounds(20,20,1260, 620);
        viewPanel.setBorder(border);
        viewPanel.setLayout(new GridLayout(1,1));
        viewPanel.add(scrollPane);
        

        frame.add(viewPanel);
        frame.add(updateButton);
        frame.add(cancleButton);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedStudentId;
        int column = 0;
        int row;

        if(e.getSource()==updateButton)
        {
            column = 0;
            row = studentsTable.getSelectedRow();
            selectedStudentId = studentsTable.getModel().getValueAt(row, column).toString();
            sd.deleteStudent(selectedStudentId);
            try {
                data = sd.getData();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            model.removeRow(studentsTable.getSelectedRow());
        }
        else if(e.getSource()==cancleButton)
        {
            frame.dispose();
        }
        
    }
}
