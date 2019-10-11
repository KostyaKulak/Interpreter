import java.util.HashMap;
import java.util.Map;

public class MachineLearning {
    private Map<Integer, Integer> commands = new HashMap<>();
    int currentCommand = 0;
    int lastCommand;


    public int command(int cmd, int num) {
        int result;
        lastCommand = cmd;
        result = Actions.FUNCTIONS.get(commands.getOrDefault(lastCommand, currentCommand)).apply(num);
        return result;
    }

    public void response(boolean result) {
        if (result) {
            commands.putIfAbsent(lastCommand, currentCommand);
        } else {
            currentCommand++;
            if (currentCommand > 4) {
                currentCommand = 0;
            }
        }
    }

}
