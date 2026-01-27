import java.util.Scanner;

class First{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if(a>0){
            System.out.println("Positive");
            if(a%2==0){
                System.out.println("Even");
            }
            else{
                System.out.println("Odd");
            }
        }
        else if(a<0){
            System.out.println("Negative");
            if(a%2==0){
                System.out.println("Even");
            }
            else{
                System.out.println("Odd");
            }
        }
        else{
            System.out.println("Zero \nEven");
        }
    }
}