package grokkingpatterns.mergeinterval;

import java.util.ArrayList;
import java.util.List;

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();

        int startA = 0, startB = 0;
        int endA = arr1.length, endB = arr2.length;

        while (startA < endA && startB < endB) {

            Interval a = arr1[startA];
            Interval b = arr2[startB];

            if (a.end >= b.start) {
                int end = Math.min(a.end, b.end);
                int start = Math.max(a.start, b.start);
                Interval common = new Interval(start, end);
                intervalsIntersection.add(common);
                if (common.end >= a.end) {
                    startA++;
                }
                if (common.end >= b.end) {
                    startB++;
                }

            } else {
                if (a.start < b.start) {
                    startA++;
                } else {
                    startB++;
                }

            }
        }


        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}

