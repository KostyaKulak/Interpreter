import java.util.HashMap;
import java.util.Map;

public class TypeTranspiler {
    private static final Map<String, String> TYPE_DICT = new HashMap<>();
    private static final String SIMPLE_TYPE = "[a-zA-Z]+";
    private static final String SIMPLE_TYPE_PARAMETRIZED = SIMPLE_TYPE + "\\<((" + SIMPLE_TYPE + ")|)\\>";

    static {
        TYPE_DICT.put("Int", "Integer");
        TYPE_DICT.put("*", "?");
        TYPE_DICT.put("out ", "? extends ");
        TYPE_DICT.put("in ", "? super ");
    }

    public TypeTranspiler(String s) {
        // Your code here!
    }

    public String transpile() {
        // Your code here too!
        return null;
    }
}