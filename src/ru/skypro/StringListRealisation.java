package ru.skypro;

import ru.skypro.Exceptions.ArrayIsFullException;
import ru.skypro.Exceptions.IndexOutOfArrayLengthException;
import ru.skypro.Exceptions.ItemNotFoundException;
import ru.skypro.Exceptions.ParameterIsNullException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringListRealisation implements StringList{
    public int arrayLength;
    public int arraySize;
    public final String defaultString = "###";
    public String[] arrayStr;
    public StringListRealisation(int arrayLength){
        this.arrayLength = arrayLength;
        this.arraySize = 0;
        this.arrayStr = new String[arrayLength];
        Arrays.fill(arrayStr,defaultString);
    }

    @Override
    public String toString () {
        return "Contents of your array: " + Arrays.toString(arrayStr);
    }

    public String add( String item){
        if (arraySize>=arrayLength){
            throw new ArrayIsFullException();
        }else if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        boolean addCheck = false;
        for (int i = 0; i < arrayLength-1; i++) {
            if(arrayStr[i]==defaultString){
                arrayStr[i]=item;
                arraySize++;
                addCheck=true;
                break;
            }
        }
        if(!addCheck){
            throw new ArrayIsFullException();
        }
        return item;
    }
    public String add(int index, String item){
        if (index>=arrayLength){
            throw new IndexOutOfArrayLengthException();
        }
        else if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        boolean moveCheck = false;
        for (int i = index; i < arrayLength -1; i++) {
            if(arrayStr[i+1]==defaultString){
                for (int j = i+1; j >index; j--) {
                    arrayStr[j]=arrayStr[j-1];
                }
                arrayStr[index] = item;
                arraySize++;
                moveCheck = true;
                break;
            }else{
                continue;
            }
        }
        if(!moveCheck){
            throw new ArrayIsFullException();
        }
        return item;
    }
    public String set(int index, String item){
        if (index>=arrayLength){
            throw new IndexOutOfArrayLengthException();
        }
        else if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        if(arrayStr[index]==defaultString){
            arraySize++;
        }
        arrayStr[index] = item;
        return item;
    }
    public String remove(String item){
        if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        boolean found = false;
        for (int i = 0; i < arrayLength-1; i++) {
            if (arrayStr[i]==item){
                found = true;
                arrayStr[i] = defaultString;
                arraySize--;
            }
        }
        if(!found){
            throw new ItemNotFoundException();
        }
        return item;
    }
    public String remove ( int index ) {
        if (arrayStr[index] == defaultString) {
            throw new ItemNotFoundException();
        } else {
            String deletedString = arrayStr[index];
            arrayStr[index] = defaultString;
            arraySize--;
            return deletedString;
        }
    }
    public boolean contains(String item){
        if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        boolean contains = false;
        for (int i = 0; i < arrayLength-1; i++) {
            if(arrayStr[i]==item){
                contains=true;
            }
        }
        return contains;
    }
    public int indexOf(String item){
        if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        int searchIndex =-1;
        for (int i = 0; i < arrayLength-1; i++) {
            if(arrayStr[i]==item){
                searchIndex = i;
            }
        }
        return searchIndex;
    }
    public int lastIndexOf(String item){
        if(item==defaultString|item==null){
            throw new ParameterIsNullException();
        }
        int searchIndex =-1;
        for (int i = arrayLength -1; i > -1; i--) {
            if(arrayStr[i]==item){
                searchIndex = i;
            }
        }
        return searchIndex;
    }
    public String get(int index){
        if (index>=arrayLength){
            throw new IndexOutOfArrayLengthException();
        }
        return arrayStr[index];
    }
    public void clear(){
        for (int i = 0; i < arrayLength-1; i++) {
            arrayStr[i]=defaultString;
        }
        arraySize=0;
    }
    public int size (){
        return arraySize;
    };
    public boolean isEmpty (){
        if(arraySize==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean equals ( StringList otherList ){
        if(otherList==null){
            throw new ParameterIsNullException();
        }
        return Arrays.equals(arrayStr,otherList.toArray());
    }
    public String[] toArray(){
        return Arrays.copyOf(arrayStr,arrayLength);
    }
}
