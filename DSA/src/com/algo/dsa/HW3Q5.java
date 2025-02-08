package com.algo.dsa;
import java.util.*;

public class HW3Q5 {

//    public static int[] findLargestSubarray(int[] nums) {
//        return findLargestSubarray(nums, 0, nums.length - 1);
//    }
//
//    private static int[] findLargestSubarray(int[] nums, int left, int right) {
//        // Base case: single element is always a valid subarray
//        if (left == right) {
//            return new int[]{left, right};
//        }
//
//        // Divide the array into two halves
//        int mid = (left + right) / 2;
//
//        // Recursively find the largest valid subarray in the left and right halves
//        int[] leftResult = findLargestSubarray(nums, left, mid);
//        int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//        // Find the largest valid subarray that crosses the midpoint
//        int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//        // Return the longest valid subarray among the left, right, and crossing subarrays
//        return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//    }
//
//    private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//        // Expand to the left starting from the mid
//        int leftMin = nums[mid], leftMax = nums[mid];
//        int bestLeft = mid;
//
//        for (int i = mid; i >= left; i--) {
//            leftMin = Math.min(leftMin, nums[i]);
//            leftMax = Math.max(leftMax, nums[i]);
//
//            if (allElementsWithinRange(nums, i, mid, leftMin, leftMax)) {
//                bestLeft = i;
//            } else {
//                break;  // Stop expanding if condition is violated
//            }
//        }
//
//        // Expand to the right starting from mid + 1
//        int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//        int bestRight = mid + 1;
//
//        for (int j = mid + 1; j <= right; j++) {
//            rightMin = Math.min(rightMin, nums[j]);
//            rightMax = Math.max(rightMax, nums[j]);
//
//            if (allElementsWithinRange(nums, mid + 1, j, rightMin, rightMax)) {
//                bestRight = j;
//            } else {
//                break;  // Stop expanding if condition is violated
//            }
//        }
//
//        // Return the subarray from bestLeft to bestRight
//        return new int[]{bestLeft, bestRight};
//    }
//
//    private static boolean allElementsWithinRange(int[] nums, int start, int end, int min, int max) {
//        for (int i = start; i <= end; i++) {
//            if (nums[i] < min || nums[i] > max) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//        int leftLength = leftResult[1] - leftResult[0];
//        int rightLength = rightResult[1] - rightResult[0];
//        int crossLength = crossResult[1] - crossResult[0];
//
//        // Compare the lengths of the three subarrays and return the longest one
//        if (leftLength >= rightLength && leftLength >= crossLength) {
//            return leftResult;
//        } else if (rightLength >= leftLength && rightLength >= crossLength) {
//            return rightResult;
//        } else {
//            return crossResult;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 = {8, 1, 3, 4, 7};
//        int[] result1 = findLargestSubarray(nums1);
//        System.out.println("Result for array [8, 1, 3, 4, 7]: [" + nums1[result1[0]] + ", " + nums1[result1[1]] + "]");
//
//        int[] nums2 = {2, 6, 5, 4, 9, 8};
//        int[] result2 = findLargestSubarray(nums2);
//        System.out.println("Result for array [2, 6, 5, 4, 9, 8]: [" + nums2[result2[0]] + ", " + nums2[result2[1]] + "]");
//    }

//        public static int[] findLargestSubarray(int[] nums) {
//            return findLargestSubarray(nums, 0, nums.length - 1);
//        }
//
//        private static int[] findLargestSubarray(int[] nums, int left, int right) {
//            // Base case: single element is always a valid subarray
//            if (left == right) {
//                return new int[]{left, right};
//            }
//
//            // Divide the array into two halves
//            int mid = (left + right) / 2;
//
//            // Recursively find the largest valid subarray in the left and right halves
//            int[] leftResult = findLargestSubarray(nums, left, mid);
//            int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//            // Find the largest valid subarray that crosses the midpoint
//            int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//            // Return the longest valid subarray among the left, right, and crossing subarrays
//            return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//        }
//
//        private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//            // Initialize min and max for the left half (starting from mid)
//            int leftMin = nums[mid], leftMax = nums[mid];
//            int bestLeft = mid;
//
//            for (int i = mid; i >= left; i--) {
//                leftMin = Math.min(leftMin, nums[i]);
//                leftMax = Math.max(leftMax, nums[i]);
//
//                // Check if the current subarray is valid
//                if (leftMax - leftMin == mid - i) {
//                    bestLeft = i;
//                } else {
//                    break; // No point in expanding further if the subarray becomes invalid
//                }
//            }
//
//            // Initialize min and max for the right half (starting from mid + 1)
//            int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//            int bestRight = mid + 1;
//
//            for (int j = mid + 1; j <= right; j++) {
//                rightMin = Math.min(rightMin, nums[j]);
//                rightMax = Math.max(rightMax, nums[j]);
//
//                // Check if the current subarray is valid
//                if (rightMax - rightMin == j - (mid + 1)) {
//                    bestRight = j;
//                } else {
//                    break; // Stop if the subarray becomes invalid
//                }
//            }
//
//            // Return the subarray from bestLeft to bestRight
//            return new int[]{bestLeft, bestRight};
//        }
//
//        private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//            int leftLength = leftResult[1] - leftResult[0] + 1;
//            int rightLength = rightResult[1] - rightResult[0] + 1;
//            int crossLength = crossResult[1] - crossResult[0] + 1;
//
//            // Compare the lengths of the three subarrays and return the longest one
//            if (leftLength >= rightLength && leftLength >= crossLength) {
//                return leftResult;
//            } else if (rightLength >= leftLength && rightLength >= crossLength) {
//                return rightResult;
//            } else {
//                return crossResult;
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] nums1 = {8, 1, 3, 4, 7};
//            int[] result1 = findLargestSubarray(nums1);
//            System.out.println("Result for array [8, 1, 3, 4, 7]: " + Arrays.toString(Arrays.copyOfRange(nums1, result1[0], result1[1] + 1)));
//
//            int[] nums2 = {2, 6, 5, 4, 9, 8};
//            int[] result2 = findLargestSubarray(nums2);
//            System.out.println("Result for array [2, 6, 5, 4, 9, 8]: " + Arrays.toString(Arrays.copyOfRange(nums2, result2[0], result2[1] + 1)));
//        }

//        public static int[] findLargestSubarray(int[] nums) {
//            return findLargestSubarray(nums, 0, nums.length - 1);
//        }
//
//        private static int[] findLargestSubarray(int[] nums, int left, int right) {
//            // Base case: single element is always a valid subarray
//            if (left == right) {
//                return new int[]{left, right};
//            }
//
//            // Divide the array into two halves
//            int mid = (left + right) / 2;
//
//            // Recursively find the largest valid subarray in the left and right halves
//            int[] leftResult = findLargestSubarray(nums, left, mid);
//            int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//            // Find the largest valid subarray that crosses the midpoint
//            int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//            // Return the longest valid subarray among the left, right, and crossing subarrays
//            return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//        }
//
//        private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//            int leftMin = nums[mid], leftMax = nums[mid];
//            int bestLeft = mid;
//
//            // Find the largest valid left subarray from mid to left
//            for (int i = mid; i >= left; i--) {
//                leftMin = Math.min(leftMin, nums[i]);
//                leftMax = Math.max(leftMax, nums[i]);
//
//                if (containsAllInRange(nums, i, mid, leftMin, leftMax)) {
//                    bestLeft = i;
//                } else {
//                    break; // If the subarray is invalid, stop expanding
//                }
//            }
//
//            int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//            int bestRight = mid + 1;
//
//            // Find the largest valid right subarray from mid+1 to right
//            for (int j = mid + 1; j <= right; j++) {
//                rightMin = Math.min(rightMin, nums[j]);
//                rightMax = Math.max(rightMax, nums[j]);
//
//                if (containsAllInRange(nums, mid + 1, j, rightMin, rightMax)) {
//                    bestRight = j;
//                } else {
//                    break; // If the subarray is invalid, stop expanding
//                }
//            }
//
//            // Return the subarray that spans from bestLeft to bestRight
//            return new int[]{bestLeft, bestRight};
//        }
//
//        // Helper function to check if all numbers between min and max are present in the subarray
//        private static boolean containsAllInRange(int[] nums, int start, int end, int min, int max) {
//            boolean[] seen = new boolean[max - min + 1]; // Create a boolean array to mark numbers in the range
//            for (int i = start; i <= end; i++) {
//                if (nums[i] < min || nums[i] > max) {
//                    return false;
//                }
//                seen[nums[i] - min] = true; // Mark the number as seen
//            }
//            // Ensure all numbers between min and max are present
//            for (boolean b : seen) {
//                if (!b) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        // Helper function to return the subarray with the maximum length
//        private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//            int leftLength = leftResult[1] - leftResult[0] + 1;
//            int rightLength = rightResult[1] - rightResult[0] + 1;
//            int crossLength = crossResult[1] - crossResult[0] + 1;
//
//            if (leftLength >= rightLength && leftLength >= crossLength) {
//                return leftResult;
//            } else if (rightLength >= leftLength && rightLength >= crossLength) {
//                return rightResult;
//            } else {
//                return crossResult;
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] nums1 = {8, 1, 3, 4, 7};
//            int[] result1 = findLargestSubarray(nums1);
//            System.out.println("Result for array [8, 1, 3, 4, 7]: " + Arrays.toString(Arrays.copyOfRange(nums1, result1[0], result1[1] + 1)));
//
//            int[] nums2 = {2, 6, 5, 4, 9, 8};
//            int[] result2 = findLargestSubarray(nums2);
//            System.out.println("Result for array [2, 6, 5, 4, 9, 8]: " + Arrays.toString(Arrays.copyOfRange(nums2, result2[0], result2[1] + 1)));
//        }


//        public static int[] findLargestSubarray(int[] nums) {
//            return findLargestSubarray(nums, 0, nums.length - 1);
//        }
//
//        private static int[] findLargestSubarray(int[] nums, int left, int right) {
//            // Base case: single element is always a valid subarray
//            if (left == right) {
//                return new int[]{left, right};
//            }
//
//            // Divide the array into two halves
//            int mid = (left + right) / 2;
//
//            // Recursively find the largest valid subarray in the left and right halves
//            int[] leftResult = findLargestSubarray(nums, left, mid);
//            int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//            // Find the largest valid subarray that crosses the midpoint
//            int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//            // Return the longest valid subarray among the left, right, and crossing subarrays
//            return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//        }
//
//        private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//            // Initialize min and max for the left half (starting from mid)
//            int leftMin = nums[mid], leftMax = nums[mid];
//            int bestLeft = mid;
//
//            HashSet<Integer> leftSet = new HashSet<>(); // Set to track elements
//            leftSet.add(nums[mid]);
//
//            for (int i = mid; i >= left; i--) {
//                leftMin = Math.min(leftMin, nums[i]);
//                leftMax = Math.max(leftMax, nums[i]);
//                leftSet.add(nums[i]);
//
//                // Check if all elements between leftMin and leftMax are present
//                if (containsAll(leftSet, leftMin, leftMax)) {
//                    bestLeft = i;
//                } else {
//                    break; // If invalid, stop expanding
//                }
//            }
//
//            // Initialize min and max for the right half (starting from mid + 1)
//            int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//            int bestRight = mid + 1;
//
//            HashSet<Integer> rightSet = new HashSet<>();
//            rightSet.add(nums[mid + 1]);
//
//            for (int j = mid + 1; j <= right; j++) {
//                rightMin = Math.min(rightMin, nums[j]);
//                rightMax = Math.max(rightMax, nums[j]);
//                rightSet.add(nums[j]);
//
//                // Check if all elements between rightMin and rightMax are present
//                if (containsAll(rightSet, rightMin, rightMax)) {
//                    bestRight = j;
//                } else {
//                    break; // If invalid, stop expanding
//                }
//            }
//
//            // Return the subarray from bestLeft to bestRight
//            return new int[]{bestLeft, bestRight};
//        }
//
//        // Helper function to check if all integers between min and max are in the set
//        private static boolean containsAll(HashSet<Integer> set, int min, int max) {
//            for (int i = min; i <= max; i++) {
//                if (!set.contains(i)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        // Helper function to return the subarray with the maximum length
//        private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//            int leftLength = leftResult[1] - leftResult[0] + 1;
//            int rightLength = rightResult[1] - rightResult[0] + 1;
//            int crossLength = crossResult[1] - crossResult[0] + 1;
//
//            if (leftLength >= rightLength && leftLength >= crossLength) {
//                return leftResult;
//            } else if (rightLength >= leftLength && rightLength >= crossLength) {
//                return rightResult;
//            } else {
//                return crossResult;
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] nums1 = {8, 1, 3, 4, 7};
//            int[] result1 = findLargestSubarray(nums1);
//            System.out.println("Result for array [8, 1, 3, 4, 7]: " + Arrays.toString(Arrays.copyOfRange(nums1, result1[0], result1[1] + 1)));
//
//            int[] nums2 = {2, 6, 5, 4, 9, 8};
//            int[] result2 = findLargestSubarray(nums2);
//            System.out.println("Result for array [2, 6, 5, 4, 9, 8]: " + Arrays.toString(Arrays.copyOfRange(nums2, result2[0], result2[1] + 1)));
//        }

//    public static int[] findLargestSubarray(int[] nums) {
//        return findLargestSubarray(nums, 0, nums.length - 1);
//    }
//
//    private static int[] findLargestSubarray(int[] nums, int left, int right) {
//        // Base case: single element is always a valid subarray
//        if (left == right) {
//            return new int[]{left, right};
//        }
//
//        // Divide the array into two halves
//        int mid = (left + right) / 2;
//
//        // Recursively find the largest valid subarray in the left and right halves
//        int[] leftResult = findLargestSubarray(nums, left, mid);
//        int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//        // Find the largest valid subarray that crosses the midpoint
//        int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//        // Return the longest valid subarray among the left, right, and crossing subarrays
//        return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//    }
//
//    private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//        // Expand to the left starting from the mid
//        int leftMin = nums[mid], leftMax = nums[mid];
//        int bestLeft = mid;
//
//        for (int i = mid; i >= left; i--) {
//            leftMin = Math.min(leftMin, nums[i]);
//            leftMax = Math.max(leftMax, nums[i]);
//
//            if (allElementsWithinRange(nums, i, mid, leftMin, leftMax)) {
//                bestLeft = i;
//            } else {
//                break;  // Stop expanding if condition is violated
//            }
//        }
//
//        // Expand to the right starting from mid + 1
//        int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//        int bestRight = mid + 1;
//
//        for (int j = mid + 1; j <= right; j++) {
//            rightMin = Math.min(rightMin, nums[j]);
//            rightMax = Math.max(rightMax, nums[j]);
//
//            if (allElementsWithinRange(nums, mid + 1, j, rightMin, rightMax)) {
//                bestRight = j;
//            } else {
//                break;  // Stop expanding if condition is violated
//            }
//        }
//
//        if (rightMin < rightMax && leftMin < leftMax) {
//            return new int[]{bestLeft, bestRight};
//        }
//        return new int[]{-1, -1};
//
//    }
//
//    private static boolean allElementsWithinRange(int[] nums, int start, int end, int min, int max) {
//        for (int i = start; i <= end; i++) {
//            if (nums[i] < min || nums[i] > max) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//        int leftLength = leftResult[1] - leftResult[0];
//        int rightLength = rightResult[1] - rightResult[0];
//        int crossLength = crossResult[1] - crossResult[0];
//
//        // Compare the lengths of the three subarrays and return the longest one
//        if (leftLength >= rightLength && leftLength >= crossLength) {
//            return leftResult;
//        } else if (rightLength >= leftLength && rightLength >= crossLength) {
//            return rightResult;
//        } else {
//            return crossResult;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 = {8, 1, 3, 4, 7};
//        int[] result1 = findLargestSubarray(nums1);
//        System.out.println("Result for array [8, 1, 3, 4, 7]: [" + nums1[result1[0]] + ", " + nums1[result1[1]] + "]");
//
//        int[] nums2 = {2, 6, 5, 4, 9, 8};
//        int[] result2 = findLargestSubarray(nums2);
//        System.out.println("Result for array [2, 6, 5, 4, 9, 8]: [" + nums2[result2[0]] + ", " + nums2[result2[1]] + "]");
//    }


//    import java.util.Arrays;
//
//    public class LargestValidSubarray {

//        public static int[] findLargestSubarray(int[] nums) {
//            return findLargestSubarray(nums, 0, nums.length - 1);
//        }
//
//        private static int[] findLargestSubarray(int[] nums, int left, int right) {
//            // Base case: single element is always a valid subarray
//            if (left == right) {
//                return new int[]{left, right};
//            }
//
//            // Divide the array into two halves
//            int mid = (left + right) / 2;
//
//            // Recursively find the largest valid subarray in the left and right halves
//            int[] leftResult = findLargestSubarray(nums, left, mid);
//            int[] rightResult = findLargestSubarray(nums, mid + 1, right);
//
//            // Find the largest valid subarray that crosses the midpoint
//            int[] crossResult = findCrossingSubarray(nums, left, mid, right);
//
//            // Return the longest valid subarray among the left, right, and crossing subarrays
//            return getMaxSubarray(nums, leftResult, rightResult, crossResult);
//        }
//
//        private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
//            // Expand to the left starting from mid
//            int leftMin = nums[mid], leftMax = nums[mid];
//            int bestLeft = mid;
//
//            for (int i = mid; i >= left; i--) {
//                leftMin = Math.min(leftMin, nums[i]);
//                leftMax = Math.max(leftMax, nums[i]);
//
//                if (leftMin < leftMax && allElementsWithinRange(nums, i, mid, leftMin, leftMax)) {
//                    bestLeft = i;
//                } else {
//                    break;  // Stop expanding if condition is violated
//                }
//            }
//
//            // Expand to the right starting from mid + 1
//            int rightMin = nums[mid + 1], rightMax = nums[mid + 1];
//            int bestRight = mid + 1;
//
//            for (int j = mid + 1; j <= right; j++) {
//                rightMin = Math.min(rightMin, nums[j]);
//                rightMax = Math.max(rightMax, nums[j]);
//
//                if (rightMin < rightMax && allElementsWithinRange(nums, mid + 1, j, rightMin, rightMax)) {
//                    bestRight = j;
//                } else {
//                    break;  // Stop expanding if condition is violated
//                }
//            }
//
//            // Return the subarray from bestLeft to bestRight
//            return new int[]{bestLeft, bestRight};
//        }
//
//        private static boolean allElementsWithinRange(int[] nums, int start, int end, int min, int max) {
//            for (int i = start; i <= end; i++) {
//                if (nums[i] < min || nums[i] > max) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
//            int leftLength = leftResult[1] - leftResult[0];
//            int rightLength = rightResult[1] - rightResult[0];
//            int crossLength = crossResult[1] - crossResult[0];
//
//            // Compare the lengths of the three subarrays and return the longest one
//            if (leftLength >= rightLength && leftLength >= crossLength) {
//                return leftResult;
//            } else if (rightLength >= leftLength && rightLength >= crossLength) {
//                return rightResult;
//            } else {
//                return crossResult;
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] nums1 = {8, 1, 3, 4, 7};
//            int[] result1 = findLargestSubarray(nums1);
//            System.out.println("Result for array [8, 1, 3, 4, 7]: " + Arrays.toString(Arrays.copyOfRange(nums1, result1[0], result1[1] + 1)));
//
//            int[] nums2 = {2, 6, 5, 4, 9, 8};
//            int[] result2 = findLargestSubarray(nums2);
//            System.out.println("Result for array [2, 6, 5, 4, 9, 8]: " + Arrays.toString(Arrays.copyOfRange(nums2, result2[0], result2[1] + 1)));
//        }

//



        public static int[] findLargestSubarray(int[] nums, int left, int right) {
            // Base case: if the subarray contains fewer than 2 elements, no valid subarray can be found.
            if (left >= right) {
                return new int[]{-1, -1};
            }

            // Divide: Find the mid-point of the current subarray.
            int mid = (left + right) / 2;

            // Conquer: Recursively find the largest subarray in the left and right halves.
            int[] leftResult = findLargestSubarray(nums, left, mid);
            int[] rightResult = findLargestSubarray(nums, mid + 1, right);

            // Combine: Check if there's a valid "crossing" subarray that spans both halves.
            int[] crossResult = findCrossingSubarray(nums, left, mid, right);

            // Return the largest valid subarray between the three results.
            return getMaxSubarray(nums, leftResult, rightResult, crossResult);
        }

        // Find the "crossing" subarray that spans both halves of the current array.
        private static int[] findCrossingSubarray(int[] nums, int left, int mid, int right) {
            int bestLeft = -1;
            int bestRight = -1;

            // Find the leftmost valid index in the left half.
            for (int i = left; i <= mid; i++) {
                // Find the rightmost valid index in the right half.
                for (int j = right; j > mid; j--) {
                    // Ensure nums[i] < nums[j] and all elements between i and j are between nums[i] and nums[j].
                    if (nums[i] < nums[j] && isValidSubarray(nums, i, j)) {
                        bestLeft = i;
                        bestRight = j;
                        break;  // Since we want the rightmost valid subarray, break after finding it.
                    }
                }
                if (bestLeft != -1) break;  // Stop early once a valid subarray is found.
            }

            // If a valid subarray is found, return its indices. Otherwise, return [-1, -1].
            return bestLeft != -1 ? new int[]{bestLeft, bestRight} : new int[]{-1, -1};
        }

        // Check if all elements between indices `L` and `R` are within the range nums[L] < nums[i] < nums[R].
        private static boolean isValidSubarray(int[] nums, int L, int R) {
            for (int i = L + 1; i < R; i++) {
                if (nums[i] <= nums[L] || nums[i] >= nums[R]) {
                    return false;
                }
            }
            return true;
        }

        // Compare three subarrays and return the largest one (in terms of length).
        private static int[] getMaxSubarray(int[] nums, int[] leftResult, int[] rightResult, int[] crossResult) {
            int leftLength = leftResult[1] - leftResult[0];
            int rightLength = rightResult[1] - rightResult[0];
            int crossLength = crossResult[1] - crossResult[0];

            if (leftResult[0] == -1) leftLength = -1;  // Invalid subarray.
            if (rightResult[0] == -1) rightLength = -1;  // Invalid subarray.
            if (crossResult[0] == -1) crossLength = -1;  // Invalid subarray.

            if (leftLength >= rightLength && leftLength >= crossLength) {
                return leftResult;
            } else if (rightLength >= leftLength && rightLength >= crossLength) {
                return rightResult;
            } else {
                return crossResult;
            }
        }

        public static void main(String[] args) {
            int[] nums = {8, 1, 3, 4, 7};
//            int[] nums = {2, 6, 5, 4, 9, 8};
//            int[] nums = {9, 7, 8, 10, 3, 0};
            int[] result = findLargestSubarray(nums, 0, nums.length - 1);
            if (result[0] != -1 && result[1] != -1) {
                System.out.println("Largest subarray: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
            } else {
                System.out.println("No valid subarray found.");
            }
        }





//    public static void main(String[] args) {
//        int[] nums = {8, 1, 3, 4, 7};
//        int[] result = findLargestSubarray(nums, 0, nums.length - 1);
//        System.out.println("Result for array [8, 1, 3, 4, 7]: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
//
//        int[] nums1 = {2, 6, 5, 4, 9, 8};
//        int[] result1 = findLargestSubarray(nums1, 0, nums1.length - 1);
//        System.out.println("Result for array [2, 6, 5, 4, 9, 8]: [" + nums1[result1[0]] + ", " + nums1[result1[1]] + "]");
//
//        int[] nums2 = {1, 2, 7, 6, 5, 4};
//        int[] result2 = findLargestSubarray(nums2, 0, nums2.length - 1);
//        System.out.println("Result for array [1, 2, 7, 6, 5, 4]: [" + nums2[result2[0]] + ", " + nums2[result2[1]] + "]");
//
//        int[] nums3 = {1, 3, 5, 8, 9};
//        int[] result3 = findLargestSubarray(nums3, 0, nums3.length - 1);
//        System.out.println("Result for array [1, 3, 5, 8, 9]: [" + nums3[result3[0]] + ", " + nums3[result3[1]] + "]");
//
//        int[] nums4 = {1, 7, 3, 4};
//        int[] result4 = findLargestSubarray(nums4, 0, nums4.length - 1);
//        System.out.println("Result for array [1, 7, 3, 4]: [" + nums4[result4[0]] + ", " + nums4[result4[1]] + "]");
//
//        int[] nums5 = {1, 2, 6, 5, 0};
//        int[] result5 = findLargestSubarray(nums5, 0, nums5.length - 1);
//        System.out.println("Result for array [1, 2, 6, 5, 0]: [" + nums5[result5[0]] + ", " + nums5[result5[1]] + "]");
//    }


}
