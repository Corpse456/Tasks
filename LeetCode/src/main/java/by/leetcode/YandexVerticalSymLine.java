package by.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface YandexVerticalSymLine {

    boolean hasVerticalSymLine(Point[] points);
}

class YandexVerticalSymLineMy implements YandexVerticalSymLine {

    @Override
    public boolean hasVerticalSymLine(Point[] points) {
        Map<Integer, List<Integer>> lines = new HashMap<>();
        for (Point point : points) {
            lines.computeIfAbsent(point.y, k -> new ArrayList<>()).add(point.x);
        }

        Long rightSymLine = null;

        for (final List<Integer> xList : lines.values()) {
            xList.sort(Comparator.naturalOrder());
            for (int i = 0; i <= xList.size() / 2; i++) {
                long newSymLine = ((long) xList.get(i)) + xList.get(xList.size() - 1 - i);
                if (rightSymLine == null) {
                    rightSymLine = newSymLine;
                }
                if (newSymLine != rightSymLine) {
                    return false;
                }
            }
        }
        return true;

    }
}

class YandexVerticalSymLineOptimal implements YandexVerticalSymLine {

    private int minX = 0, maxX = 0;

    @Override
    public boolean hasVerticalSymLine(final Point[] points) {
        for (final Point point : points) {
            if (point.x > maxX) {
                maxX = point.x;
            }
            if (point.x < minX) {
                minX = point.x;
            }
            final var symLine = getSymLine();
        }
        //TODO realize next
        //line always between min and max
        return false;
    }

    private long getSymLine() {
        return (long) minX + maxX;
    }
}

@NoArgsConstructor
@AllArgsConstructor
class Point {

    int x, y;

    public static Point[] points(int... coordinates) {
        final var points = new Point[coordinates.length / 2];
        var pointIndex = 0;
        for (int i = 0; i < coordinates.length; i += 2) {
            points[pointIndex++] = new Point(coordinates[i], coordinates[i + 1]);
        }
        return points;
    }
}
