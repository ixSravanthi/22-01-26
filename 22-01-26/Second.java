import java.util.Scanner;
public class Second {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        System.out.printf("\nNumbers from 1 to %d are: ",n);
        for(int i=1; i<=n; i++){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.printf("\nEven numbers from 1 to %d are: ",n);
        int i=2;
        while(i<=n){
            System.out.print(i+" ");
            i+=2;
        }
        System.out.printf("\nSum of first %d numbers is %d",n,sum);
    }
    
}
