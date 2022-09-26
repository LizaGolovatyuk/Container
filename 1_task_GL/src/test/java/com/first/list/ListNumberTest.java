package com.first.list;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ListNumberTest {
    ListNumber<Double> list1 =new ListNumber<Double>();

    @org.junit.Before
    public void setNumber()throws Exception{

        list1.addNumber(6.0,1);
        list1.addNumber(3.0, 1);
        list1.addNumber(5.0, 2);
        list1.addNumber(2.0, 4);

    }

    @org.junit.Test
    public void addNumber_NotCorrect() {
        boolean tmp=list1.addNumber(6.0, 7);
        Assert.assertEquals(tmp,false);
    }

    @org.junit.Test
    public void addNumber() {
        String result1=list1.print();
        String result2=" 3.0 5.0 6.0 2.0 ";
        Assert.assertEquals(result1,result2);
    }

    @org.junit.Test
    public void deleteNumber_NotCorrect() {
        boolean tmp=list1.deleteNumber(7);
        Assert.assertEquals(tmp,false);
    }

    @org.junit.Test
    public void deleteNumber() {
        list1.deleteNumber(1);
        list1.deleteNumber(2);
        list1.deleteNumber(2);
        String result1=list1.print();
        String result2=" 5.0 ";
        Assert.assertEquals(result1,result2);
    }

    @org.junit.Test
    public void getElem_NotCorrect() {
        Assert.assertEquals(list1.getElem(7),null);
    }

    @org.junit.Test
    public void getElem() {
        String result1="";
        result1+=list1.getElem(1);
        result1+=list1.getElem(3);
        result1+=list1.getElem(4);
        String result2="6.05.02.0";
    }
}