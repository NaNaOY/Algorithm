package java_school;

public class Manager extends Employee {
    private String responsibilities;
    public Manager(){
      //  super();
    }
    public Manager(String responsibilities){
        this.responsibilities=responsibilities;
    }
    public Manager(Manager manager){
        this(manager.getName(),manager.getPhoneNumber(),manager.salary,manager.responsibilities);

    }

    public Manager(Employee employee,String responsibilities){
      this(employee.getName(),employee.getPhoneNumber(),employee.salary,responsibilities);
    }

    public Manager(String name, String phone, double salar, String responsibilities) {
        super(name,phone,salar);
        this.setResponsibilities(responsibilities);
    }

    public void setResponsibilities(String responsibilities){
        this.responsibilities=responsibilities;
    }
    public String getResponsibilities(){
        return responsibilities;
    }
    public String toString() {
        return super.toString() + ";" + responsibilities;
    }
}

