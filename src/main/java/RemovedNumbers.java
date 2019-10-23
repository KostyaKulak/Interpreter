import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        long sum = LongStream.rangeClosed(1, n).parallel().sum();
        return LongStream.rangeClosed(n / 2 - 1, n)
                .parallel()
                .mapToObj(i -> getLongs(i, n, sum))
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingLong((List<Long> o) -> o.get(0)).thenComparingLong(o -> o.get(1)))
                .map(RemovedNumbers::toArray)
                .collect(Collectors.toList());
    }

    private static List<List<Long>> getLongs(long i, long j) {
        return Arrays.asList(Arrays.asList(i, j), Arrays.asList(j, i));
    }

    private static CopyOnWriteArrayList<List<Long>> getLongs(long i, long n, long sum) {
        return LongStream.rangeClosed(i, n)
                .parallel()
                .filter(j -> i * j == sum - i - j)
                .mapToObj(j -> getLongs(i, j))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    private static long[] toArray(List<Long> longs) {
        long[] a = new long[longs.size()];
        IntStream.range(0, a.length).forEach(i -> a[i] = longs.get(i));
        return a;
    }
}