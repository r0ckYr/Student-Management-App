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

public class UpdatePanel implements ActionListener{

    StudentDatabase sd;
    JFrame frame;
    JButton updateButton;
    JButton cancleButton;
    JLabel loginLabel;
    JTextField userField;
    JTextField passField;
    JLabel errorLabel;

    //update lables
    JLabel nameLabel;
    JLabel mobileNumberLabel;
    JLabel courseLabel;
    JLabel courseDurationLabel;
    JLabel startDateLabel;
    JLabel endDateLabel;
    JLabel feesPerMonthLabel;
    JLabel totalFeesLabel;
    JLabel fathersNameLabel;
    JLabel mothersNameLabel;
    JLabel addressLabel;
    JLabel dobLabel;
    JLabel ageLabel;
    JLabel feesPaidLabel;

    //update textFields
    JTextField nameField;
    JTextField mobileNumberField;
    JTextField courseField;
    JTextField courseDurationField;
    JTextField startDateField;
    JTextField endDateField;
    JTextField feesPerMonthField;
    JTextField totalFeesField;
    JTextField fathersNameField;
    JTextField mothersNameField;
    JTextField addressField;
    JTextField dobField;
    JTextField ageField;
    JTextField feesPaidField;

    JTable studentsTable;

    String userId;
    String name;
    String mobileNumber;
    String course;
    String courseDuration;
    String startDate;
    String endDate;
    String feesPerMonth;
    String totalFees;
    String fathersName;
    String mothersName;
    String address;
    String dob;
    String age;
    String feesPaid;

    public boolean isAdmin = false;
    public String username;
    public String password;

    boolean isValid = false;

    UpdatePanel(String userData[], JTable studentsTable)
    {
        this.studentsTable = studentsTable;
        userId = userData[0];
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border innerBorder = BorderFactory.createLineBorder(Color.GRAY, 1);

        frame = new JFrame("Update Panel");
        frame.setLayout(null);
        frame.setSize(780,700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        //login panel
        JPanel updatePanel = new JPanel();
        updatePanel.setBounds(24, 20, 720, 580);
        updatePanel.setBorder(border);
        updatePanel.setVisible(true);
        updatePanel.setLayout(null);

        //buttons
        updateButton = new JButton("Update");
        cancleButton = new JButton("Cancle");
        updateButton.setBounds(70, 620, 110, 20);
        cancleButton.setBounds(500, 620, 100, 20);
        cancleButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        updateButton.setFont(new Font("MV Boli", Font.PLAIN, 18));

        cancleButton.addActionListener(this);
        updateButton.addActionListener(this);

        //all lables and buttons
        nameLabel = new JLabel("Name:");
        mobileNumberLabel = new JLabel("Mobile Number:");
        courseLabel = new JLabel("Course:");
        courseDurationLabel = new JLabel("Course Duration:");
        startDateLabel = new JLabel("Start Date:");
        endDateLabel = new JLabel("End Date:");
        feesPerMonthLabel = new JLabel("Fees/Month:");
        totalFeesLabel = new JLabel("Toatl Fees:");
        fathersNameLabel = new JLabel("Father's Name:");
        mothersNameLabel = new JLabel("Mother's Name:");
        addressLabel = new JLabel("Address:");
        dobLabel = new JLabel("Date Of Birth:");
        ageLabel = new JLabel("Age:");
        feesPaidLabel = new JLabel("Fees Paid:");

        //textFields
        //{"Id", "Name", "Mobile Number", "Age", "Date of Birth", "Course", "Course Duration", "Start Date", "End Date", "Father's Name", "Mother's Name", "Address", "Fees/Month", "Total Fees", "Fees Paid"};
        nameField = new JTextField(userData[1]);
        mobileNumberField = new JTextField(userData[2]);
        ageField = new JTextField(userData[3]);
        dobField = new JTextField(userData[4]);
        courseField = new JTextField(userData[5]);
        courseDurationField = new JTextField(userData[6]);
        startDateField = new JTextField(userData[7]);
        endDateField = new JTextField(userData[8]);
        fathersNameField = new JTextField(userData[9]);
        mothersNameField = new JTextField(userData[10]);
        addressField = new JTextField(userData[11]);
        feesPerMonthField = new JTextField(userData[12]);
        totalFeesField = new JTextField(userData[13]);
        feesPaidField = new JTextField(userData[14]);
        
        //all borders
        nameLabel.setBounds(10,10,120,20);
        nameLabel.setBorder(innerBorder);
        nameField.setBounds(140,10,200,20);
        nameField.setBorder(innerBorder);

        mobileNumberLabel.setBounds(380,10,120,20);
        mobileNumberLabel.setBorder(innerBorder);
        mobileNumberField.setBounds(510,10,200,20);
        mobileNumberField.setBorder(innerBorder);

        courseLabel.setBounds(10,50,120,20);
        courseLabel.setBorder(innerBorder);
        courseField.setBounds(140,50,200,20);
        courseField.setBorder(innerBorder);

        courseDurationLabel.setBounds(380,50,125,20);
        courseDurationLabel.setBorder(innerBorder);
        courseDurationField.setBounds(510,50,200,20);
        courseDurationField.setBorder(innerBorder);

        startDateLabel.setBounds(10,90,120,20);
        startDateLabel.setBorder(innerBorder);
        startDateField.setBounds(140,90,200,20);
        startDateField.setBorder(innerBorder);

        endDateLabel.setBounds(380,90,120,20);
        endDateLabel.setBorder(innerBorder);
        endDateField.setBounds(510,90,200,20);
        endDateField.setBorder(innerBorder);

        feesPerMonthLabel.setBounds(10,130,120,20);
        feesPerMonthLabel.setBorder(innerBorder);
        feesPerMonthField.setBounds(140,130,200,20);
        feesPerMonthField.setBorder(innerBorder);

        totalFeesLabel.setBounds(380,130,120,20);
        totalFeesLabel.setBorder(innerBorder);
        totalFeesField.setBounds(510,130,200,20);
        totalFeesField.setBorder(innerBorder);

        fathersNameLabel.setBounds(10,170,120,20);
        fathersNameLabel.setBorder(innerBorder);
        fathersNameField.setBounds(140,170,200,20);
        fathersNameField.setBorder(innerBorder);

        mothersNameLabel.setBounds(380,170,120,20);
        mothersNameLabel.setBorder(innerBorder);
        mothersNameField.setBounds(510,170,200,20);
        mothersNameField.setBorder(innerBorder);

        addressLabel.setBounds(10,210,120,20);
        addressLabel.setBorder(innerBorder);
        addressField.setBounds(140,210,200,20);
        addressField.setBorder(innerBorder);

        dobLabel.setBounds(380,210,120,20);
        dobLabel.setBorder(innerBorder);
        dobField.setBounds(510,210,200,20);
        dobField.setBorder(innerBorder);

        ageLabel.setBounds(10,250,120,20);
        ageLabel.setBorder(innerBorder);
        ageField.setBounds(140,250,200,20);
        ageField.setBorder(innerBorder);

        feesPaidLabel.setBounds(380,250,120,20);
        feesPaidLabel.setBorder(innerBorder);
        feesPaidField.setBounds(510,250,200,20);
        feesPaidField.setBorder(innerBorder);

        updatePanel.add(nameLabel);
        updatePanel.add(nameField);
        updatePanel.add(mobileNumberLabel);
        updatePanel.add(mobileNumberField);
        updatePanel.add(courseLabel);
        updatePanel.add(courseField);
        updatePanel.add(courseDurationLabel);
        updatePanel.add(courseDurationField);
        updatePanel.add(startDateLabel);
        updatePanel.add(startDateField);
        updatePanel.add(endDateLabel);
        updatePanel.add(endDateField);
        updatePanel.add(feesPerMonthLabel);
        updatePanel.add(feesPerMonthField);
        updatePanel.add(totalFeesLabel);
        updatePanel.add(totalFeesField);
        updatePanel.add(fathersNameLabel);
        updatePanel.add(fathersNameField);
        updatePanel.add(mothersNameLabel);
        updatePanel.add(mothersNameField);
        updatePanel.add(addressLabel);
        updatePanel.add(addressField);
        updatePanel.add(dobLabel);
        updatePanel.add(dobField);
        updatePanel.add(ageLabel);
        updatePanel.add(ageField);
        updatePanel.add(feesPaidLabel);
        updatePanel.add(feesPaidField);

        //editable
        //editable
        // nameField.setEditable(false);
        // mobileNumberField.setEditable(false);
        // courseField.setEditable(false);
        courseDurationField.setEditable(false);
        // startDateField.setEditable(false);
        // endDateField.setEditable(false);
        feesPerMonthField.setEditable(false);
        totalFeesField.setEditable(false);
        // fathersNameField.setEditable(false);
        // mothersNameField.setEditable(false);
        // addressField.setEditable(false);
        // dobField.setEditable(false);
        // ageField.setEditable(false);
        feesPaidField.setEditable(false);

        //error invalid credentials
        errorLabel = new JLabel("Invalid Data");
        errorLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(320,400, 350, 20);
        errorLabel.setVisible(false);

        frame.add(cancleButton);
        frame.add(updateButton);
        frame.add(errorLabel);

        frame.add(updatePanel);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==updateButton)
        {
            name = nameField.getText();
            mobileNumber = mobileNumberField.getText();
            course = courseField.getText();
            courseDuration = courseDurationField.getText();
            startDate = startDateField.getText();
            endDate = endDateField.getText();
            feesPerMonth = feesPerMonthField.getText();
            totalFees = totalFeesField.getText();
            fathersName = fathersNameField.getText();
            mothersName = mothersNameField.getText();
            address = addressField.getText();
            dob = dobField.getText();
            age = ageField.getText();
            feesPaid = feesPaidField.getText();

            String userData[] = {name ,mobileNumber ,course ,courseDuration ,startDate ,endDate ,feesPerMonth ,totalFees ,fathersName ,mothersName ,address ,dob ,age ,feesPaid};
            VerifyStudentData d = new VerifyStudentData();
            String errorMessage = d.verifyData(userData);
            
            if(errorMessage=="Data Registered")
            {
                String data[]={userId, name ,mobileNumber ,course ,courseDuration ,startDate ,endDate ,feesPerMonth ,totalFees ,fathersName ,mothersName ,address ,dob ,age ,feesPaid};
                try {
                    nameField.setText("");
                    mobileNumberField.setText("");
                    courseField.setText("");
                    courseDurationField.setText("");
                    startDateField.setText("");
                    endDateField.setText("");
                    feesPerMonthField.setText("");
                    totalFeesField.setText("");
                    fathersNameField.setText("");
                    mothersNameField.setText("");
                    addressField.setText("");
                    dobField.setText("");
                    ageField.setText("");
                    feesPaidField.setText("");
                    sd = new StudentDatabase();
                    sd.updateData(data);
                    errorLabel.setForeground(Color.GREEN);

                    DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
                    model.setValueAt(name, studentsTable.getSelectedRow(), 1);
                    model.setValueAt(mobileNumber, studentsTable.getSelectedRow(), 2);
                    model.setValueAt(age, studentsTable.getSelectedRow(), 3);
                    model.setValueAt(dob, studentsTable.getSelectedRow(), 4);
                    model.setValueAt(course, studentsTable.getSelectedRow(), 5);
                    model.setValueAt(courseDuration, studentsTable.getSelectedRow(), 6);
                    model.setValueAt(startDate, studentsTable.getSelectedRow(), 7);
                    model.setValueAt(endDate, studentsTable.getSelectedRow(), 8);
                    model.setValueAt(fathersName, studentsTable.getSelectedRow(), 9);
                    model.setValueAt(mothersName, studentsTable.getSelectedRow(), 10);
                    model.setValueAt(address, studentsTable.getSelectedRow(), 11);
                    model.setValueAt(feesPerMonth, studentsTable.getSelectedRow(), 12);
                    model.setValueAt(totalFees, studentsTable.getSelectedRow(), 13);
                    model.setValueAt(feesPaid, studentsTable.getSelectedRow(), 14);
                    
                    errorLabel.setText("Data updated");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else{
                errorLabel.setText(errorMessage);
                System.out.println("invalid");
            }
            errorLabel.setVisible(true);
        }
        else if(e.getSource()==cancleButton)
        {
            frame.dispose();
        }
        
    }

    boolean isValidDate(String date)
    {
        if(date.length()==10 && date.charAt(4)=='-' && date.charAt(7)=='-' && Integer.parseInt(date.substring(5, 7))<=12 && Integer.parseInt(date.substring(8))<=31)//1990-08-22
        {
            for(int i=0;i<date.length();i++)
            {
                if(i!=4 && i!=7)
                {
                    if(!Character.isDigit(date.charAt(i)))
                    {
                        return false;
                    }
                }
                
            }
            return true;
        }
        return false;
    }

    boolean isNumeric(String num)
    {
        for(int i=0;i<num.length();i++)
        {
            if(Character.isDigit(num.charAt(i)) || num.charAt(i)=='.')
                {}
            else  
                return false;
        }
        return true;
    }
}
