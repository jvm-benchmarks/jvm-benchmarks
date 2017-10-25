package com.jvm.benchmark.collections;

import java.util.ArrayList;

public class JavaList {
    private final ArrayList<Integer> arrayList;

    public JavaList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }
}
