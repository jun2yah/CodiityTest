package com.jun2yah.test;

import android.util.Log;

import java.util.Arrays;

public class Sort {

    private final String TAG = "Solution";

    /**
     * 버블 정렬
     * O(n^2)
     *
     * @param A
     * @return
     */
    public int[] bubbleSort(int[] A) {
        Log.d(TAG, "BubbleSort = " + Arrays.toString(A));

        int len = A.length;

        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len - i - 1; j++) {

                if (A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }

                Log.d(TAG, "BubbleSort = " + Arrays.toString(A));
            }
        }

        return A;
    }

    /**
     * 선택 정렬
     * O(n^2)
     *
     * @param A
     * @return
     */
    public int[] selectionSort(int[] A) {
        Log.d(TAG, "SelectionSort = " + Arrays.toString(A));

        int len = A.length;
        int min = 0;

        for (int i = 0; i < len; i++) {
            min = i;

            for (int j = i + 1; j < len; j++) {
                if (A[min] > A[j]) {
                    min = j;
                }
            }

            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;

            Log.d(TAG, "SelectionSort = " + Arrays.toString(A));
        }

        return A;
    }

    /**
     * 삽입정렬
     * O(n^2)
     *
     * @param A
     * @return
     */
    public int[] insertionSort(int[] A) {
        Log.d(TAG, "insertionSort = " + Arrays.toString(A));

        int len = A.length;

        for (int i = 1; i < len; i++) {
            int key = A[i];

            for (int j = i - 1; j >= 0; j--) {

                if (key < A[j]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;

                    Log.d(TAG, "insertionSort = " + Arrays.toString(A));
                }
            }
        }

        return A;
    }

}
