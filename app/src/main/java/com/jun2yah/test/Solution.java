package com.jun2yah.test;

import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    private final String TAG = "Solution";

    /**
     * BinaryGap
     *
     * @param N
     * @return
     */
    public int solution1(int N) {
        // write your code in Java SE 8
        String binary = Integer.toBinaryString(N);

        int count = 0;
        int max = 0;

        for (int i = 0; i < binary.length(); i++) {
            if ("0".equals(String.valueOf(binary.charAt(i)))) {
                count++;
            }

            if ("1".equals(String.valueOf(binary.charAt(i)))) {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        Log.d(TAG, binary);

        return max;
    }

    /**
     * CyclicRotation
     *
     * @param A
     * @param K
     * @return
     */
    public int[] solution2_1(int[] A, int K) {
        // write your code in Java SE 8
        int[] a = new int[A.length];

        for (int i = 0; i < a.length; i++) {
            a[(i+K)%a.length] = A[i];
        }

        return a;
    }

    /**
     * OddOccurrencesInArray
     *
     * @param A
     * @return
     */
    public int solution2_2(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();

        for (int i: A) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }

        return set.iterator().next();
    }



    /**
     * PermMissingElem
     *
     * @param A
     * @return
     */
    public int solution3_1(int[] A) {
        // write your code in Java SE 8
        long N = A.length + 1;
        long total = N * (N + 1) / 2;

        for (int i: A) {
            total -= i;
        }

        return (int) total;
    }

    /**
     * FrogJmp
     *
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution3_2(int X, int Y, int D) {
        // write your code in Java SE 8
        int distance = Y - X;

        return distance%D == 0 ? distance/D : distance/D + 1;
    }

    /**
     * TapeEquilibrium
     *
     * @param A
     * @return
     */
    public int solution3_3(int[] A) {
        // write your code in Java SE 8
        int minDiff = 0;

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                num1 += A[j];
            }
            for (int k = i + 1; k < A.length; k++) {
                num2 += A[k];
            }

            int diff = Math.abs(num1 - num2);

            if (i == 0) {
                minDiff = diff;
            } else {
                if (minDiff > diff) {
                    minDiff = diff;
                }
            }

            num1 = 0;
            num2 = 0;
        }

        return minDiff;
    }

}
