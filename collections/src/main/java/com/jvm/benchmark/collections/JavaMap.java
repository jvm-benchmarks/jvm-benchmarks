package com.jvm.benchmark.collections;

import java.time.Instant;
import java.util.HashMap;
import java.util.TreeMap;

public class JavaMap {
    private final HashMap<Instant, String> hashMap;
    private final TreeMap<Instant, String> treeMap;

    public JavaMap(HashMap<Instant, String> hashMap, TreeMap<Instant, String> treeMap) {
        this.hashMap = hashMap;
        this.treeMap = treeMap;
    }

    public HashMap<Instant, String> getHashMap() {
        return hashMap;
    }

    public TreeMap<Instant, String> getTreeMap() {
        return treeMap;
    }
}
