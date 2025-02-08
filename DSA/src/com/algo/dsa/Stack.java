package com.algo.dsa;

import java.util.ArrayList;
import java.util.List;

class StackClass {
    // implement stack using array
    // push(), pop(), peek(), isEmpty()

    private List<Integer> lst;
    public StackClass() {
        this.lst = new ArrayList<>();
    }

    public void push(int x) {
        lst.add(x);
        System.out.println("Pushed Element: " + lst.get(lst.size() - 1));
    }

    public int pop() {
        return lst.remove(lst.size() - 1);
    }
    public int peek() {
        return lst.get(lst.size() - 1);
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }
}

public class Stack {
    public static void main(String[] args) {

        StackClass s = new StackClass();
        s.push(12);
        s.push(20);
        s.push(133);
        System.out.println(s.pop());
        System.out.println(s.peek());
        s.push(10);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());


    }
}
