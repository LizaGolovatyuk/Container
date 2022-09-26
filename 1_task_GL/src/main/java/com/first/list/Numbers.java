package com.first.list;

public class Numbers <T> {
    public T x;
    protected Numbers <T> next;

    protected Numbers() {};
    public Numbers (T new_x) { x=new_x; next=null;};
}
