package org.practice.javaFundas.miscellaneous;

//Properties of Immutable Class:

//1. State of immutable object can not be modified after construction, any modification should result in new immutable object.
//2. All fields of Immutable class should be final.
//3. Object must be properly constructed i.e. object reference must not leak during construction process.
//4. Object should be final in order to restrict sub-class for altering immutability of parent class.

import java.util.Hashtable;

public class MyImmutable {
    private final String name;
    private final String mobile;
    //Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();

    public  MyImmutable(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName(){
        return name;
    }

    public String getMobile(){
        return mobile;
    }

    @Override
    public boolean equals(Object ob) {
        if(ob == this) {
            return true;
        }

        if(!(ob instanceof MyImmutable)) {
            return false;
        }

        MyImmutable o = (MyImmutable)ob;
        return o.name == name && o.mobile == mobile;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + mobile.hashCode();
        return result;
    }
}
