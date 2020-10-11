package leetcode.arrays;

import java.util.*;

public class MinArrowsToBurstBaloon {

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int arrow = 1; // if more than 0 balloons then atleast 1 arrow to start
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrow++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return arrow;
    }

    public static void main(String[] args) {

        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        findMinArrowShots(points);
    }


}
