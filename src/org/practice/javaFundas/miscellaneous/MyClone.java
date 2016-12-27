package org.practice.javaFundas.miscellaneous;

/**
 * Created by priyasingh on 11/2/15.
 */
public class MyClone implements Cloneable{
    private String color;

    public MyClone(String c){
        this.color = c;
    }

    public String getColor() {
        return color;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
       return super.clone();
    }

    public static void main(String args[]) {
        MyClone ob = new MyClone("RED");
        MyClone ob1;
        try {
            ob1 = (MyClone)ob.clone();
            System.out.println(ob+" "+ob1);
            System.out.println(ob.getColor()+" "+ob1.getColor());
        } catch(CloneNotSupportedException e)  {
            System.out.println("Cloneable must be implemented");
        }
    }
}
