import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    public static List<Point> closestPair(List<Point> points) {
        List<PointExt> pointExts = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                pointExts.add(new PointExt(i, j, Math.sqrt(Math.pow(points.get(i).x - points.get(j).x, 2) + Math.pow(points.get(i).y - points.get(j).y, 2))));
            }
        }
        double min = pointExts.stream()
                .min(Comparator.comparingDouble(o -> o.d))
                .map(pointExt -> pointExt.d)
                .orElse(Double.MAX_VALUE);
        return pointExts.stream()
                .filter(pointExt -> pointExt.d == min)
                .flatMap(pointExt -> {
                    List<Point> p = new ArrayList<>();
                    p.add(points.get((int) pointExt.x));
                    p.add(points.get((int) pointExt.y));
                    return p.stream();
                })
                .collect(Collectors.toList());

    }

    private static class PointExt extends Point {
        private double d;

        public PointExt(double x, double y, double d) {
            super(x, y);
            this.d = d;
        }
    }
}