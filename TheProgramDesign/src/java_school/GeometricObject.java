package java_school;
import java.util.Date;
public abstract class GeometricObject {
    private  String color;
    private  boolean filled;
    private  Date dateCreated;
    protected GeometricObject(){
        this("white",false);
    }
    protected GeometricObject(String color,boolean filled){
        dateCreated=new Date();
        this.color=color;
        this.filled=filled;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setFilled(boolean filled){
        this.filled=false;
    }
    public String getColor(){
        return color;
    }
    public boolean isFilled(){
        return filled;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public String toString(){
        String str="";
        str="\ncreated on"+dateCreated+"\ncolor:"+color+"\nfilled:"+filled;
        return str;
    }
    public void print(){
        System.out.println(toString());
    }
    public abstract  double getArea();
    public abstract  double getPerimeter();
}
