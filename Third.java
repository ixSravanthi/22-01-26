public class Third {

    public int add(int a, int b){
        return a+b;
    }

    public boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int findFactorial(int number){
        int i=1,fac=1;
        while(number>0 & i<=number){
            fac*=i;
            i+=1;
        }
        return fac;
    }

    public static void main(String[] args){
        Third x=new Third();
        System.out.println(x.add(2,3));
        System.out.println(x.isEven(9));
        System.out.println(x.findFactorial(5));
    }
    
}
