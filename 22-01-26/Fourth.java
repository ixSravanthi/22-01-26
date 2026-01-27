public class Fourth {
    public static void main(String[] args) {
        Student s=new Student(1,"siri",30);
        System.out.println(s.get_id()+" "+s.get_marks()+" "+s.get_name());   
        if(s.isPass(s.get_marks())){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }
        s.set_id(10);
        s.set_name("ram");
        s.set_marks(50);
        System.out.println(s.get_id()+" "+s.get_marks()+" "+s.get_name());   
        if(s.isPass(s.get_marks())){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }
    }
    
}

class Student{
    private int id, marks;
    private String name;
    Student(int id, String name, int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    int get_marks(){
        return marks;
    }

    String get_name(){
        return name;
    }

    int get_id(){
        return id;
    }

    void set_marks(int marks){
        this.marks=marks;
    }

    void set_id(int id){
        this.id=id;
    }

    void set_name(String name){
        this.name=name;
    }
    
    boolean isPass(int marks){
        if(marks>=40){
            return true;
        }
        else{
            return false;
        }
    }
}