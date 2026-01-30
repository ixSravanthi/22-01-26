import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.*;

public class problem4 {
    static Logger logger=Logger.getLogger(problem4.class.getName());
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers do you want to enter: ");
        int n=sc.nextInt();
        int i=1;
        ArrayList<Number> list=new ArrayList<>();
        while(i<=n) {
            String s=sc.next();
            int flag=0;
            try{
                if(s.contains(".")){
                    list.add(Float.valueOf(s));
                }
                else{
                    list.add(Integer.valueOf(s));
                }
            }
            catch(NumberFormatException e){
                System.out.println(e);
                logger.info("Invalid input");
                flag=1;
            }
            if(flag==0){
                i+=1;
            }
        }
        System.out.println(list);
        int int_sum=0,float_count=0;
        float float_avg=0;
        for (Number number : list) {
            if(number.getClass().getSimpleName().equals("Integer")){
                int_sum+=number.intValue();
            }
            else{
                float_avg+=number.floatValue();
                float_count+=1;
            }
        }
        float_avg=float_avg/float_count;
        System.out.println(int_sum);
        System.out.println(float_avg);
    }
}
