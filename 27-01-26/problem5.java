import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class problem5 {
    static Logger logger=Logger.getLogger(problem5.class.getName());
    public static void main(String[] args) {
        //reading file
        File file=new File("student_data.txt");
        //writing file
        Path valid_file=Path.of("valid.txt");
        Path invalid_file=Path.of("invalid.txt");

        HashSet<String[]> valid_data_set=new HashSet<>();
        HashSet<String[]> invalid_data_set=new HashSet<>();

        try(Scanner sc=new Scanner(file)){
            while (sc.hasNextLine()) {
                int flag=0;
                String data=sc.nextLine();
                String[] data_list=data.split(",");
                //data formating
                for (String str : data_list) {
                    System.out.print(str+" ");   
                }
                System.out.print("\n");
                data_list[1]=data_list[1].replaceAll("\\s+", " ");
                data_list[1]=data_list[1].strip();
                try{
                    validateName(data_list[1]);
                    validateAge(Integer.parseInt(data_list[2]));
                }
                catch(InvalidNameException e){
                    System.out.println(e.getMessage());
                    logger.info("Invalid Name");
                    flag=1;
                    invalid_data_set.add(data_list);
                }
                catch(InvalidAgeException e){
                    System.out.println(e.getMessage());
                    logger.info("Invalid Age");
                    flag=1;
                    invalid_data_set.add(data_list);
                }
                if(flag==0){
                    valid_data_set.add(data_list);
                }
            }
        }
        catch(Exception e){
            System.out.println("File not found");
        }

        //writing data
        try(FileWriter writer=new FileWriter("valid.txt")){
            for (String[] array : valid_data_set) {
                for (String str : array) {
                    writer.write(str+",");    
                }
                writer.write("\n");
            }
        }
        catch(IOException e){
            System.out.println("Error");
        }
        try(FileWriter writer=new FileWriter("invalid.txt")){
            for (String[] array : invalid_data_set) {
                for (String str : array) {
                    writer.write(str+",");    
                }
                writer.write("\n");
            }
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }

    //Validation methods
    private static final String NAME_REGEX="^[A-Za-z]{2}+\s*[A-Za-z]*\s*[A-Za-z]*$";
    public static void validateName(String name) throws InvalidNameException{
        if(name==null || !Pattern.matches(NAME_REGEX, name)){
            throw new InvalidNameException("Invalid name");
        }
    }

    public static void validateAge(Integer age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Invalid age");
        }
    }
}


//Exception classes
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
 
