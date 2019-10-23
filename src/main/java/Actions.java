import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Actions {
    public static final List<Function<Integer, Integer>> FUNCTIONS = Arrays.asList(
            x -> x + 1,
            x -> 0,
            x -> x * 100,
            x -> x % 2,
            x -> x / 2
    );
}
