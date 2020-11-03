package java_school;

public class Employee extends Person {
    private  int employeeId;
    public static int count=0;
    protected double salary;
    public Employee(String name,String phoneNumber,double salary){
        super(name,phoneNumber);
        this.salary=salary;
        count++;
        employeeId=count;
    }
    public Employee(Employee employee){
        this(employee.getName(),employee.getPhoneNumber(),employee.salary);
    }
    public Employee(){
        this("none","12345678",3000.0);
    }

    public int getEmployeeId(){
        return employeeId;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void showEmployee(){
        System.out.println(toString());
    }
    public String toString(){
        String s;
        s=employeeId+";"+super.toString()+";"+salary;
        return s;
    }
}
