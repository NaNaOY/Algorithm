package java_school;

public class Test {
    public static void main(String[] atgs){
        Manager m1=new Manager();
        Manager m2=new Manager("wang","8812345678",8000,"经理");
        Manager m3=new Manager(m2);
        Employee e=new Employee("zhang","12345678971",5000);
        Employee m4=new Manager(e,"副经理");
        Employee[] emp={m1,m2,m3,e,m4};
        for(Employee em:emp){
            em.showEmployee();
        }

    }
}
