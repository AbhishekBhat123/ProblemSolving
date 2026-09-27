class Solution {
    private boolean check(int[] arr, int i, boolean increasing) {
        if (i == arr.length - 1) {
            return !increasing;
        }

        if (increasing) {
            if (arr[i] < arr[i + 1]) {
                return check(arr, i + 1, true);
            }

            if (arr[i] > arr[i + 1]) {
                return check(arr, i + 1, false);
            }

            return false;
        }

        if (arr[i] > arr[i + 1]) {
            return check(arr, i + 1, false);
        }

        return false;
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1]) {
            return false;
        }

        return check(arr, 0, true);
    }
}
