package com.first.list;

import org.junit.jupiter.api.Test;

public class ListNumber <T> {
    protected Numbers <T> head;
    protected Numbers <T> tail;
    protected int size;


    public ListNumber () {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    protected Numbers<T> GetHead()
    {
        return head;
    }
    protected Numbers <T> findBeforePlace(Numbers <T> pNumbers, int place) {
        Numbers<T> p = null;
        Numbers<T> p1 = pNumbers;
        int place_find = 1;
        if(place<=size+1 && place!=1) {
            while (p1.next != null && place_find < place) {
                place_find++;
                p = p1;
                p1 = p1.next;
            }
            if (p1.next == null && place_find != place) p=p1;
        }
        return p;
    }

    protected void addToHead(T new_x) {
        Numbers<T> p = new Numbers(new_x);
        p.x = new_x;
        p.next = head;
        head = p;
        if(head.next==null) tail=head;
    }

    protected void addAfterTail(T new_x) {
        Numbers<T> p = new Numbers(new_x);
        p.x = new_x;
        tail.next = p;
        tail = p;
    }

    protected void addAfterListNumber(T new_x, Numbers <T> pNumbers) {
        if (pNumbers == tail) addAfterTail(new_x);
        else {
            Numbers<T> p = new Numbers(new_x);
            p.x = new_x;
            p.next = pNumbers.next;
            pNumbers.next = p;
        }
    }

   @Test
    public boolean addNumber(T new_x, int place) {
        if (place <= size+1) {
            if (!isEmpty()) {
                Numbers<T> p = findBeforePlace(head, place);

                if (p == null) {
                    addToHead(new_x);
                } else {

                    addAfterListNumber(new_x, p);

                }
            } else addToHead(new_x);
            size++;
            return true;
        }
        return false;
    }

    protected void deleteFromHead() {
        if (!isEmpty()) {
            if (head == tail) {
                head = null;
                tail = null;

            } else {
                Numbers p = head;
                head = p.next;
                p.next = null;
                p = null;
            }
        }

    }

    protected void deleteAfterListNumber(Numbers <T> pNumbers) {
        Numbers<T> p = pNumbers.next;
        if (p == tail) {
            pNumbers.next = null;
            tail = pNumbers;
        }
        if (p != null) {
            pNumbers.next = p.next;
            p.next = null;
            p = null;
        }
    }

    @Test
    public boolean deleteNumber(int place) {
        if (place <= size ) {
            Numbers<T> p = findBeforePlace(head, place);
            if (p == null)
                deleteFromHead();
            else deleteAfterListNumber(p);

            size--;
            return true;
        }
        return false;
    }

    @Test
    public T getElem(int place) {
        T elem;
        if (place <= size) {
            Numbers<T> p = findBeforePlace(head, place);
            if (p == null) elem = head.x;
            else elem = p.next.x;
            return elem;
        }
        return null;
    }

    public String print() {
        String result=" ";
        if (!isEmpty()) {
            Numbers<T> p = head;
            while (p != null) {
                result=result+p.x+" ";
                p = p.next;
            }
        } else System.out.println("Набор пуст!");
        return result;
    }
}
