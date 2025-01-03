package leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class P_1496 {

    public boolean isPathCrossing(String path) {

        int x = 0, y = 0;
        Set<Point> point = new HashSet<>();
        point.add(new Point(0, 0));

        for (char c : path.toCharArray()) {

            if (c == 'N') x++;
            else if (c == 'S') x--;
            else if (c == 'E') y++;
            else if (c == 'W') y--;

            Point currentPoint = new Point(x, y);

            if (point.contains(currentPoint)) {
                return true;
            }

            point.add(currentPoint);
        }

        return false;
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
