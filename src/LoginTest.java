import java.awt.Font;
import java.awt.Color;
// import java.awt.FlowLayout;
// import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class LoginTest implements ActionListener{

    JFrame frame;
    JButton loginButton;
    JButton userButton;
    JLabel loginLabel;
    JTextField userField;
    JTextField passField;
    JLabel errorLabel;

    public boolean isAdmin = false;
    public String username;
    public String password;

    boolean isValid = false;
    

    LoginTest(int height, int width, String header)
    {
        //test
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        frame = new JFrame("Management App");
        frame.setLayout(null);
        frame.setSize(width,height);
        frame.getContentPane().setBackground(new Color(14,14,26));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //header
        loginLabel = new JLabel(header);
        loginLabel.setBounds(100,2, 350,200); 
        loginLabel.setForeground(new Color(255,255,255));
        loginLabel.setFont(new Font("MV Boli", Font.PLAIN, 52));

        //login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, 500, 600);
        loginPanel.setBorder(border);
        loginPanel.setVisible(true);
        loginPanel.setLayout(null);
        //inputs
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        userLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        passLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        passLabel.setForeground(new Color(255,255,255));
        userLabel.setForeground(new Color(255,255,255));
        userLabel.setBounds(70,220, 150, 50);
        passLabel.setBounds(70,280, 150, 50);
        //userLabel.setBorder(border);
        //passLabel.setBorder(border);

        userField = new JTextField();
        passField = new JTextField();
        userField.setBounds(220,233, 200,25);
        passField.setBounds(220,293, 200,25);
        userField.setBackground(new Color(73, 73, 84));
        userField.setForeground(new Color(255,255,255));
        passField.setBackground(new Color(73, 73, 84));
        passField.setForeground(new Color(255,255,255));

        loginPanel.add(userLabel);
        loginPanel.add(passLabel);

        loginPanel.add(userField);
        loginPanel.add(passField);

        //buttons
        loginButton = new JButton("Login");
        userButton = new JButton("Admin Login");
        loginButton.setBounds(40, 480, 100, 20);
        userButton.setBounds(330, 480, 150, 20);
        userButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        loginButton.setFont(new Font("MV Boli", Font.PLAIN, 18));
        userButton.setBackground(new Color(73, 73, 84));
        userButton.setForeground(new Color(255,255,255));
        loginButton.setBackground(new Color(73, 73, 84));
        loginButton.setForeground(new Color(255,255,255));
        
        userButton.addActionListener(this);
        loginButton.addActionListener(this);

        //error invalid credentials
        errorLabel = new JLabel("The username or password is incorrect!");
        errorLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(70,40, 350, 20);
        errorLabel.setVisible(false);

        loginPanel.add(userButton);
        loginPanel.add(loginButton);
        loginPanel.add(errorLabel);
        loginPanel.setBackground(new Color(9, 112, 222));

        //
        ImageIcon img=new ImageIcon("School-Management-System-Edecofy-1024x555.png");
        JLabel photoLabel = new JLabel(img);
        photoLabel.setBounds(500, 0, 300, 700);

        JLabel sideLabel = new JLabel("Management Console");
        sideLabel.setBounds(500, 270, 300, 30);
        sideLabel.setFont(new Font("MV Boli", Font.PLAIN, 27));

        frame.add(loginLabel);
        frame.add(loginPanel);
        //frame.add(photoLabel);
        frame.add(sideLabel);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userButton) {
            errorLabel.setVisible(false);
			String pageHeader = loginLabel.getText();
            //System.out.println(header);
            if(pageHeader.equals("Admin Login"))
            {
                loginLabel.setText("User Login");
                userButton.setText("Admin Login");
                isAdmin = false;
            }
            else
            {
                loginLabel.setText("Admin Login");
                userButton.setText("User Login");
                isAdmin = true;
            }
		}
        
        else if(e.getSource()==loginButton)
        {
            username = userField.getText();
            password = passField.getText();
            UserDatabase ud;
            try 
            {
                ud = new UserDatabase();
                isValid = ud.checkCredentials(username, password, isAdmin);
                System.out.println(username+" "+password+" "+isAdmin+" "+isValid);
            }
            catch (Exception e1) 
            {
                e1.printStackTrace();
            }
            
            if(isValid)
            {
                frame.dispose();
                if(isAdmin)
                    new AdminConsole(username);
                else
                    new UserConsole(username);
            }
            else
            {
                errorLabel.setVisible(true);
                //System.out.println("Not Valid");
                userField.setText("");
                passField.setText("");
            }
        }   
    }
    
}

