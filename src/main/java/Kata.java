import java.util.*;
import java.util.stream.Collectors;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {
        Map<Double, List<Point>> pointMap = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point iPoint = points.get(i);
                Point jPoint = points.get(j);
                double d = Math.sqrt(Math.pow(iPoint.x - jPoint.x, 2) + Math.pow(iPoint.y - jPoint.y, 2));
                List<Point> pointList = pointMap.getOrDefault(d, new ArrayList<>());
                pointList.addAll(Arrays.asList(iPoint, jPoint));
                pointMap.put(d, pointList);
            }
        }
        double min = pointMap.keySet().stream().min(Comparator.naturalOrder()).orElse(Double.MAX_VALUE);
        return pointMap.entrySet()
                .stream()
                .filter(pointExt -> pointExt.getKey() == min)
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }
}