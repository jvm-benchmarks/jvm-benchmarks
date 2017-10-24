package org.foreignexchange.benchmark.map;

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

import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
public class JavaListJavaBenchmark {
    private JavaList javaList;
    private int value;

    @Setup
    public void setUp() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);

        value = 0;

        javaList = new JavaList(arrayList);
    }

    @Benchmark
    public ArrayList<Integer> arrayList_Add() {
        value++;
        javaList.getArrayList().add(value);

        return javaList.getArrayList();
    }

    @Benchmark
    public ArrayList<Integer> arrayList_Add_NewArrayListAndAdd() {
        value++;
        ArrayList<Integer> arrayList = new ArrayList<>(javaList.getArrayList());
        arrayList.add(value);

        return arrayList;
    }

    @Benchmark
    public Integer arrayList_Get() {
        return javaList.getArrayList().get(value);
    }
}
