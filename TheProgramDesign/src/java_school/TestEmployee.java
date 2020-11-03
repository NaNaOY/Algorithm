package java_school;

public class TestEmployee {
    public static void main(String[] args){
        Employee e1=new Employee("zhang","12345671",5000);
        Employee e2=new Employee(e1);
        Employee e3=new Employee();

        e1.showEmployee();
        e2.showEmployee();
        e3.showEmployee();
    }

}
