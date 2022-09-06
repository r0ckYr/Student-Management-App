
public class test {
    static final int loginFrameHeight = 600;
    static final int loginFrameWidth = 800;
    static final String loginUserHeader = "User Login";
    public static void main(String args[])throws Exception
    {
        // Scanner sc=new Scanner(System.in);
        // while(true)
        //     System.out.println(isNumeric(sc.nextLine()));
        new LoginTest(loginFrameHeight, loginFrameWidth, loginUserHeader);
    }   
    static boolean isValidDate(String date)
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
    static boolean isNumeric(String num)
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


// if(!(name.isEmpty() || mobileNumber.isEmpty() || course.isEmpty() || courseDuration.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || feesPerMonth.isEmpty() || totalFees.isEmpty() || fathersName.isEmpty() || mothersName.isEmpty() || address.isEmpty() || dob.isEmpty() || age.isEmpty() || feesPaid.isEmpty()))
            // {
            //     if(isValidDate(dob) && isValidDate(startDate) && isValidDate(endDate) && isNumeric(age) && isNumeric(totalFees) && isNumeric(feesPerMonth))
            //     {
            //         String data[]={name ,mobileNumber ,course ,courseDuration ,startDate ,endDate ,feesPerMonth ,totalFees ,fathersName ,mothersName ,address ,dob ,age ,feesPaid};
            //         try {
            //             // for (int i=0;i<data.length;i++) {
            //             //     System.out.println(data[i]);
            //             // }
            //             nameField.setText("");
            //             mobileNumberField.setText("");
            //             courseField.setText("");
            //             courseDurationField.setText("");
            //             startDateField.setText("");
            //             endDateField.setText("");
            //             feesPerMonthField.setText("");
            //             totalFeesField.setText("");
            //             fathersNameField.setText("");
            //             mothersNameField.setText("");
            //             addressField.setText("");
            //             dobField.setText("");
            //             ageField.setText("");
            //             feesPaidField.setText("");
            //             sd = new StudentDatabase();
            //             sd.registerData(data);
            //             errorLabel.setForeground(Color.GREEN);
            //             errorLabel.setText("Data Registered");
            //         } catch (Exception e1) {
            //             e1.printStackTrace();
            //         }
            //     }
            // }
            // else{
            //     System.out.println("invalid");
            // }