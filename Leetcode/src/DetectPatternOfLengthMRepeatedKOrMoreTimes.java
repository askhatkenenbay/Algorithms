public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    /*
    1566. Detect Pattern of Length M Repeated K or More Times
    Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.
    A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping.
    A pattern is defined by its length and the number of repetitions.
    Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        for (int i = 0; i + m < arr.length; i++) {
            count = arr[i] == arr[i + m] ? count + 1 : 0;
            if (count == (k - 1) * m)
                return true;
        }
        return false;
    }
}
