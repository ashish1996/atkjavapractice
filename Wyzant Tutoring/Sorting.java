import java.util.Comparator;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Vunya Srinivasa
 * @userid vsrinivasa8
 * @GTID 903192584
 * @version 1.0
 */
public class Sorting {

    /**
     * Implement cocktail sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        boolean swapped = true;
        int i = 0;
        int j = arr.length - 1;
        while (i < j && swapped) {
            swapped = false;
            for (int k = i; k < j; k++) {
                if (comparator.compare(arr[k], arr[k + 1]) > 0) {
                    T temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                    swapped = true;
                }
            }
            j--;
            if (swapped) {
                swapped = false;
                for (int k = j; k > i; k--) {
                    if (comparator.compare(arr[k], arr[k - 1]) < 0) {
                        T temp = arr[k];
                        arr[k] = arr[k - 1];
                        arr[k - 1] = temp;
                        swapped = true;
                    }
                }
            }
            i++;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable).
     *
     * See the PDF for more info on this sort.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("Can't sort a null array.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Can't compare data with null comparator");
        }
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            int index = i;
            while (index > 0 && comparator.compare(temp, arr[index - 1]) < 0) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = temp;
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     * Note that there may be duplicates in the array, but they may not
     * necessarily stay in the same relative order.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        int min;
        if (arr == null) {
            throw new IllegalArgumentException("Can't sort a null array.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Can't compare data with null comparator");
        }
        for (int j = 0; j < arr.length - 1; j++) {
            min = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (comparator.compare(arr[i], arr[min]) < 0) {
                    min = i;
                }
            }
            if (min != j) {
                T temp = arr[j];
                arr[j] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = r.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null) {
            throw new IllegalArgumentException("Can't sort a null array.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Can't compare data with null comparator");
        }
        if (rand == null) {
            throw new IllegalArgumentException("The random object is null.");
        }
        quickSort(arr, comparator, rand, 0, arr.length - 1);
    }

    private static <T> void quickSort(T[] arr, Comparator<T> comparator, Random rand, int start, int end) {
        int i = start;
        int j = end;
        int pivot = rand.nextInt(end - start) + start;
        T temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        start++;

        while (i <= j) {
            while (comparator.compare(arr[i], arr[pivot]) < 0) {
                i++;
            }
            while (comparator.compare(arr[j], arr[pivot]) > 0) {
                j--;
            }
            if (i <= j) {
                T temp2 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp2;
                i++;
                j--;
            } else {
                T temp3 = arr[pivot];
                arr[pivot] = arr[j];
                arr[j] = temp3;
            }
        }
        if (start < j) {
            quickSort(arr, comparator, rand, start, j);
        }
        if (i < end) {
            quickSort(arr, comparator, rand, i, end);
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("Can't sort a null array.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Can't compare data with null comparator");
        }
        T[] temp = (T[]) new Object[arr.length];
        mergeHelper(arr, comparator, 0, arr.length - 1, temp);
    }

    private static <T> void mergeHelper(T[] arr, Comparator<T> comparator,
                                        int first, int last, T[] temp) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeHelper(arr, comparator, first, middle, temp);
            mergeHelper(arr, comparator, middle + 1, last, temp);
            merge(arr, comparator, first, middle, last, temp);
        }
    }

    private static <T> void merge(T[] arr, Comparator<T> comparator,
                                  int first, int mid, int last,T[] temp) {
        int i = first;
        int j = mid + 1;
        int k = first;

        while (i <= mid && j <= last) {
            if (comparator.compare(arr[i], arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= last) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = first; k <= last; k++) {
            arr[k] = temp[k];
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Any duplicates in the array should be in the same relative position after
     * sorting as they were before sorting. (stable)
     *
     * Do NOT use {@code Math.pow()} in your sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Can't sort a null array.");
        }
        java.util.Queue<Integer>[] buckets = new java.util.Queue[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new java.util.LinkedList<>();
        }
        int maxDigits = 0;
        int temp = 0;
        for (int item: arr) {
            int digit = item % 10;
            buckets[digit + 9].add(item);
            while (item != 0) {
                item /= 10;
                temp++;
                if (temp > maxDigits) {
                    maxDigits = temp;
                }
            }
        }
        int index = 0;
        for (java.util.Queue<Integer> bucket: buckets) {
            while (!bucket.isEmpty()) {
                arr[index++] = bucket.remove();
            }
        }
        int expo = 1;
        while (maxDigits >= 1) {
            expo++;
            for (int item: arr) {
                int digit = (item / 10 ^ expo) % 10;
                buckets[digit + 9].add(item);
            }
            for (java.util.Queue<Integer> bucket: buckets) {
                while (!bucket.isEmpty() && index < arr.length) {
                    arr[index++] = bucket.remove();
                }
            }
            maxDigits--;
        }
    }
}
