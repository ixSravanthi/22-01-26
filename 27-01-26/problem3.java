import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;

public class problem3 {
    Logger logger=Logger.getLogger(problem3.class.getName());

    public static void main(String[] args) {
        problem3 obj= new problem3();
        int age;
        String name,email;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name: ");
        name=sc.next();
        System.out.println("Enter your age: ");
        age=sc.nextInt();
        System.out.println("Enter your email: ");
        email=sc.next();
        try{
            validateName(name);
            validateAge(age);
            validateEmail(email);
            obj.logger.info("Validation completed");
        }
        catch(InvalidNameException e){
            System.out.println(e.getMessage());
            obj.logger.info("Invalid Name");
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
            obj.logger.info("Invalid Age");
        }
        catch(InvalidEmailException e){
            System.out.println(e.getMessage());
            obj.logger.info("Invalid Email");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            obj.logger.info("Unknow Error");
        }

        
    }

    //Validation methods
    private static final String EMAIL_REGEX ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static void validateEmail(String email) throws InvalidEmailException {
        if(email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidEmailException("Invalid email address");
        }
    }

    private static final String NAME_REGEX="^[A-Za-z]+$";
    public static void validateName(String name) throws InvalidNameException{
        if(name==null || !Pattern.matches(NAME_REGEX, name)){
            throw new InvalidNameException("Invalid name");
        }
    }

    public static void validateAge(Integer age) throws InvalidAgeException{
        if(age<=0){
            throw new InvalidAgeException("Invalid age");
        }
    }
}

//Exception classes
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}