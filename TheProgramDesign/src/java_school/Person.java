package java_school;

public class Person {
    private String name;
    private String phoneNumber;
    public Person(String name,String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
    public Person(Person person){
        this(person.getName(),person.getPhoneNumber());
    }
    public Person(){
        //super();
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String toString(){
        String s;
        s=name+":"+phoneNumber;
        return s;
    }
}
