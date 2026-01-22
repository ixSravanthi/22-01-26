public class Five {
    public static void main(String[] args) {
        Employee e1=new Employee(1, "siri", 10000, "innovatech");
        Employee e2=new Employee(2, "ram", 200000, "Innovatech");
        e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();
    }
    
}

class Employee{
    int id;
    String name;
    float monthlySalary;
    static String companyName;
    Employee(int id, String name, float monthlySalary, String companyName){
        this.id=id;
        this.name=name;
        this.monthlySalary=monthlySalary;
        this.companyName=companyName;
    }

    float calculateAnnualSalary(){
        return this.monthlySalary*12;
    }

    void displayEmployeeDetails(){
        System.out.println(id+" "+name+" "+monthlySalary+" "+companyName+" "+calculateAnnualSalary());
    }
}