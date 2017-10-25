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
import scala.Tuple2;
import scala.collection.SortedMap;
import scala.collection.immutable.HashMap;
import scala.collection.immutable.Map;
import scala.collection.immutable.TreeMap;
import scala.math.Ordering;

import java.time.Instant;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(5)
public class ScalaMapJavaBenchmark {
    private ScalaMap scalaMap;
    private Instant now;

    @Setup
    public void setUp() {
        now = NanoClock.now();
        HashMap<Instant, String> map = new scala.collection.immutable.HashMap<>();
        map = map.$plus(new Tuple2<>(now, "initial"));

        TreeMap<Instant, String> sortedMap = new scala.collection.immutable.TreeMap<>(new Ordering<Instant>() {
            @Override
            public int compare(Instant x, Instant y) {
                return x.compareTo(y);
            }
        });
        sortedMap = sortedMap.$plus(new Tuple2<>(now, "initial"));

        scalaMap = new ScalaMap(map, sortedMap);
    }

    @Benchmark
    public Map<Instant, String> hashMap_Put() {
        return scalaMap.getHashMap().$plus(new Tuple2<>(NanoClock.getInstance().instant(), "description"));
    }


    @Benchmark
    public SortedMap<Instant, String> treeMap_Put() {
        return scalaMap.getTreeMap().$plus(new Tuple2<>(NanoClock.getInstance().instant(), "description"));
    }

    @Benchmark
    public String hashMap_Get() {
        return scalaMap.getHashMap().apply(now);
    }

    @Benchmark
    public String treeMap_Get() {
        return scalaMap.getTreeMap().apply(now);
    }
}
