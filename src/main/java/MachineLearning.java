import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MachineLearning {
    private Map<Integer, Integer> commands = new HashMap<>();
    int currentCommand = 0;
    List<Integer> indices = Arrays.asList(0, 1, 2, 3, 4);
    private Map<Integer, Integer> results = new HashMap<>();
    int lastCommand;


    public int command(int cmd, int num) {
        int result;
        lastCommand = cmd;
        result = Actions.FUNCTIONS.get(commands.getOrDefault(lastCommand, indices.get(currentCommand))).apply(num);
        return result;
    }

    public void response(boolean result) {
        if (result) {
            results.put(lastCommand, results.getOrDefault(lastCommand, 0) + 1);
            if (results.getOrDefault(lastCommand, 0) > results.get(getByValue(commands, lastCommand)))
                commands.putIfAbsent(lastCommand, indices.get(currentCommand));
            indices.remove(lastCommand);
            indices.sort(Integer::compareTo);
        } else {
            results.remove(lastCommand);
            commands.remove(lastCommand);
            indices.add(lastCommand);
            indices.sort(Integer::compareTo);
            currentCommand++;
            if (currentCommand > indices.size()) {
                currentCommand = 0;
            }
        }
    }

    private <T> Integer getByValue(Map<T, Integer> map, Integer value) {
        return map.entrySet().stream()
                .filter(e -> e.getKey().equals(value))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(-1);
    }

}
