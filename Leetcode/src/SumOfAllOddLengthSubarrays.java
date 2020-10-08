public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        /* for i-th node, how many times this node appeared for sub arrays of different lengths
         * the number of sub arrays that starts at node i - numOfStart
         * the number of sub arrays that ends at node i - numOfEnd
         * total number = numOfStart * numOfEnd
         * the number of sub arrays of odd length: total/2 if total is even, total/2 + 1 if total is odd
         */

        int numOfStart, numOfEnd, total;

        int length = arr.length;
        int sum = 0;

        /* from the way we calculate how many times an element appeared actually demonstrated that the i-th node
         * and the length-i-1 node actually have the same total number
         * this can be used to effectively reduce half of the calculation cost
         * however the time complexity will still be O(n)
         * plus we need to have additional parts to handle the case if length of array is odd
         * -- the one in the middle should be calculated separately as it doesn't have a symmetric partner
         * this lengthen the code and lose the clarity of code logic
         * so, just keep the simple things down
         */
        for (int i = 0; i < length; i++) {

            // sub array of length n, n+i <= length -> count n
            numOfStart = length - i;
            // sub array of length n, n <= i + 1 -> count n
            numOfEnd = i + 1;

            total = numOfStart * numOfEnd;
            if (total % 2 == 0) {
                sum += total / 2 * arr[i];
            } else {
                sum += (total / 2 + 1) * arr[i];
            }
        }

        return sum;
    }
}
