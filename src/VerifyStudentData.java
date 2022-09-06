import java.util.Calendar;

public class VerifyStudentData
{
    String verifyData(String data[])
    {
        String errorMessage = "Data Registered";
        String columns[] = {"Name", "Mobile Number", "Course", "Course Duration", "Start Date", "End Date", "Father's Name", "Mother's Name", "Address", "Age", "Date of Birth", "Fees/Month", "Total Fees", "Fees Paid"};

        String mobileNumber = data[1];
        String courseDuration = data[3];
        String startDate = data[4];
        String endDate = data[5];
        String feesPerMonth = data[6];
        String totalFees = data[7];
        String dob = data[11];
        String age = data[12];

        
        for(int i=0;i<data.length;i++)
        {
            if(data[i].equals("") || isHint(data[i]))
            {
                errorMessage = "Data Cannot be empty : "+columns[i];
                return errorMessage; 
            }
        }

        if(!verifyMobileNumber(mobileNumber))
        {
            errorMessage = "Invalid Mobile Number : "+mobileNumber;
            return errorMessage;
        }
        if(!isValidDate(startDate))
        {   
            errorMessage = "Invalid Start Date : "+startDate;
            return errorMessage;
        }
        if(!isValidDate(endDate))
        {   
            errorMessage = "Invalid End Date : "+endDate;
            return errorMessage;
        }
        if(!isNumeric(courseDuration))
        {
            errorMessage = "Invalid Course Duration : "+courseDuration;
        }
        if(!isNumeric(feesPerMonth))
        {
            errorMessage = "Invalid Fees Per Month : "+feesPerMonth;
            return errorMessage;
        }
        if(!isNumeric(totalFees))
        {
            errorMessage = "Invalid Total Fees : "+totalFees;
            return errorMessage;
        }
        if(!isValidDate(dob))
        {   
            errorMessage = "Invalid Date Of Birth : "+dob;
            return errorMessage;
        }
        if(!isNumeric(age))
        {   
            errorMessage = "Invalid Age : "+age;
            return errorMessage;
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String validAge = Integer.toString(currentYear-Integer.parseInt(dob.split("-")[0]));
        String validTotalFees = Float.toString(Float.parseFloat(feesPerMonth)*Float.parseFloat(courseDuration));

        if(!age.equals(validAge))
        {
            errorMessage = "Age Should be : "+validAge;
            return errorMessage;
        }
        if(!validTotalFees.equals(totalFees))
        {
            errorMessage = "Total Fees Should be : "+validTotalFees;
            return errorMessage;
        }
        return errorMessage;
    }    
    
    boolean verifyMobileNumber(String mobileNumber)
    {
        if(mobileNumber.length()!=10)
        {
            return false;
        }
        else{
            for(int i=0;i<10;i++)
            {
                if(!Character.isDigit(mobileNumber.charAt(i)))
                {
                    return false;
                }
            }
        }
        return true;
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
