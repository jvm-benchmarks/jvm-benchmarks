package com.jvm.benchmark.collections;

import com.jvm.benchmark.time.NanoClock;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.time.Instant;
import java.util.HashMap;
import java.util.TreeMap;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
public class JavaMapJavaBenchmark {
    private JavaMap javaMap;
    private Instant now;

    @Setup
    public void setUp() {
        now = NanoClock.getInstance().instant();
        HashMap<Instant, String> hashMap = new HashMap<>();
        hashMap.put(now, "initial");

        TreeMap<Instant, String> treeMap = new TreeMap<>();
        treeMap.put(now, "initial");

        javaMap = new JavaMap(hashMap, treeMap);
    }

    @Benchmark
    public HashMap<Instant, String> hashMap_Put() {
        javaMap.getHashMap().put(NanoClock.getInstance().instant(), "description");

        return javaMap.getHashMap();
    }

    @Benchmark
    public HashMap<Instant, String> hashMap_Put_NewMapAndPut() {
        HashMap<Instant, String> hashMap = new HashMap<>(javaMap.getHashMap());
        hashMap.put(NanoClock.getInstance().instant(), "description");

        return hashMap;
    }

    @Benchmark
    public TreeMap<Instant, String> treeMap_Put() {
        javaMap.getTreeMap().put(NanoClock.getInstance().instant(), "description");

        return javaMap.getTreeMap();
    }

    @Benchmark
    public TreeMap<Instant, String> treeMap_Put_NewMapAndPut() {
        TreeMap<Instant, String> map = new TreeMap<>(javaMap.getHashMap());
        map.put(NanoClock.getInstance().instant(), "description");

        return map;
    }

    @Benchmark
    public String hashMap_Get() {
        return javaMap.getHashMap().get(now);
    }

    @Benchmark
    public String treeMap_Get() {
        return javaMap.getTreeMap().get(now);
    }
}
