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
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.event.FocusListener;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RegisterStudent implements ActionListener,FocusListener{

    StudentDatabase sd;
    JFrame frame;
    JButton registerButton;
    JButton cancleButton;
    JLabel loginLabel;
    JTextField userField;
    JTextField passField;
    JLabel errorLabel;
    JTextField focusTextfield;

    String currentHint;
    //register lables
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

    //register textFields
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

    RegisterStudent()
    {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border innerBorder = BorderFactory.createLineBorder(Color.GRAY, 1);

        frame = new JFrame("Register New Student");
        frame.setLayout(null);
        frame.setSize(780,700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        //login panel
        JPanel registerPanel = new JPanel();
        registerPanel.setBounds(24, 20, 720, 580);
        registerPanel.setBorder(border);
        registerPanel.setVisible(true);
        registerPanel.setLayout(null);

        //buttons
        registerButton = new JButton("Register");
        cancleButton = new JButton("Cancle");
        registerButton.setBounds(70, 620, 110, 20);
        cancleButton.setBounds(500, 620, 100, 20);
        cancleButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        registerButton.setFont(new Font("MV Boli", Font.PLAIN, 18));

        cancleButton.addActionListener(this);
        registerButton.addActionListener(this);

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
        nameField = new JTextField("Name");
        mobileNumberField = new JTextField("1111111111");
        courseField = new JTextField("Course");
        courseDurationField = new JTextField("Months");
        startDateField = new JTextField("YYYY-MM-DD");
        endDateField = new JTextField("YYYY-MM-DD");
        feesPerMonthField = new JTextField("0.00");
        totalFeesField = new JTextField("0.00");
        fathersNameField = new JTextField();
        mothersNameField = new JTextField();
        addressField = new JTextField("Locality, City, State");
        dobField = new JTextField("YYYY-MM-DD");
        ageField = new JTextField("0.");
        feesPaidField = new JTextField("Yes/No");
        
        nameField.addFocusListener(this);
        mobileNumberField.addFocusListener(this);
        courseField.addFocusListener(this);
        courseDurationField.addFocusListener(this);
        startDateField.addFocusListener(this);
        endDateField.addFocusListener(this);
        feesPerMonthField.addFocusListener(this);
        totalFeesField.addFocusListener(this);
        fathersNameField.addFocusListener(this);
        mothersNameField.addFocusListener(this);
        addressField.addFocusListener(this);
        dobField.addFocusListener(this);
        ageField.addFocusListener(this);
        feesPaidField.addFocusListener(this);

        
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

        registerPanel.add(nameLabel);
        registerPanel.add(nameField);
        registerPanel.add(mobileNumberLabel);
        registerPanel.add(mobileNumberField);
        registerPanel.add(courseLabel);
        registerPanel.add(courseField);
        registerPanel.add(courseDurationLabel);
        registerPanel.add(courseDurationField);
        registerPanel.add(startDateLabel);
        registerPanel.add(startDateField);
        registerPanel.add(endDateLabel);
        registerPanel.add(endDateField);
        registerPanel.add(feesPerMonthLabel);
        registerPanel.add(feesPerMonthField);
        registerPanel.add(totalFeesLabel);
        registerPanel.add(totalFeesField);
        registerPanel.add(fathersNameLabel);
        registerPanel.add(fathersNameField);
        registerPanel.add(mothersNameLabel);
        registerPanel.add(mothersNameField);
        registerPanel.add(addressLabel);
        registerPanel.add(addressField);
        registerPanel.add(dobLabel);
        registerPanel.add(dobField);
        registerPanel.add(ageLabel);
        registerPanel.add(ageField);
        registerPanel.add(feesPaidLabel);
        registerPanel.add(feesPaidField);


        //error invalid credentials
        errorLabel = new JLabel("Invalid Data");
        errorLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(320,400, 350, 20);
        errorLabel.setVisible(false);

        frame.add(cancleButton);
        frame.add(registerButton);
        frame.add(errorLabel);

        frame.add(registerPanel);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
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

            String data[] = {name ,mobileNumber ,course ,courseDuration ,startDate ,endDate ,feesPerMonth ,totalFees ,fathersName ,mothersName ,address ,dob ,age ,feesPaid};
            VerifyStudentData d = new VerifyStudentData();
            String errorMessage = d.verifyData(data);
            if(errorMessage=="Data Registered")
            {
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
                        sd.registerData(data);
                        errorLabel.setForeground(Color.GREEN);
                    } catch (Exception e1) {
                        errorLabel.setForeground(Color.RED);
                        errorLabel.setText("Databse Error");
                        e1.printStackTrace();
                    }
            }
            else{
                errorLabel.setBounds(290,400, 350, 20);
                errorLabel.setForeground(Color.RED);
            }
            errorLabel.setText(errorMessage);
            errorLabel.setVisible(true);
        }
        else if(e.getSource()==cancleButton)
        {
            frame.dispose();
        }
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        focusTextfield = (JTextField) e.getSource();
        if(isHint(focusTextfield.getText()))
        {
            currentHint = focusTextfield.getText();
            focusTextfield.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusTextfield = (JTextField) e.getSource();
        currentHint = focusTextfield.getText();
        if(currentHint.equals(""))
        {
            if(e.getSource()==nameField){currentHint="Name";}
            if(e.getSource()==mobileNumberField){currentHint="1111111111";}
            if(e.getSource()==courseField){currentHint="Course";}
            if(e.getSource()==courseDurationField){currentHint="Months";}
            if(e.getSource()==startDateField){currentHint="YYYY-MM-DD";}
            if(e.getSource()==endDateField){currentHint="YYYY-MM-DD";}
            if(e.getSource()==feesPerMonthField){currentHint="0.00";}
            if(e.getSource()==totalFeesField){currentHint="0.00";}
            if(e.getSource()==fathersNameField){currentHint="";}
            if(e.getSource()==mothersNameField){currentHint="";}
            if(e.getSource()==addressField){currentHint="Locality, City, State";}
            if(e.getSource()==dobField){currentHint="YYYY-MM-DD";}
            if(e.getSource()==ageField){currentHint="0.";}
            if(e.getSource()==feesPaidField){currentHint="Yes/No";}
        }
        focusTextfield.setText(currentHint);
    }

    boolean isHint(String text)
    {
        String hints[] = {"Name", "1111111111", "Course", "Months", "YYYY-MM-DD", "0.00", "0.", "Yes/No", "Locality, City, State"}; 
        for(int i=0;i<hints.length;i++)
        {
            if(hints[i].equals(text))
                return true;
        }
        return false;
    }
}