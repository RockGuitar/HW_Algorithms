package ru.skypro;

public class Main {

    public static void main(String[] args) {
        StringListRealisation myArray = new StringListRealisation(7);
        System.out.println(myArray.toString());
        myArray.add("Amogus");
        myArray.add("Sus");
        System.out.println(myArray.toString());
        myArray.add(0, "less");
        System.out.println(myArray.toString());
        System.out.println("myArray.isEmpty() = " + myArray.isEmpty());
        myArray.set(5, "MOGUS");
        System.out.println(myArray.toString());
        myArray.add(5, "here");
        System.out.println(myArray.toString());
        System.out.println("myArray.size() = " + myArray.size());
        myArray.add("Gay");
        System.out.println(myArray.toString());
        System.out.println("myArray.size() = " + myArray.size());
        myArray.set(0, "sss");
        System.out.println(myArray.toString());
        System.out.println("myArray.size() = " + myArray.size());
        myArray.add(3,"pepe");
        System.out.println(myArray.toString());
        myArray.remove(2);
        System.out.println(myArray.toString());
        String[] newArray = myArray.toArray();
        StringListRealisation otherArr = myArray;
        System.out.println(otherArr.toString());
        System.out.println("myArray.equals(newArray) = " + myArray.equals(otherArr));

    }
}
