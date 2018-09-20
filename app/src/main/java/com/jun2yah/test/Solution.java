package com.jun2yah.test;

import android.util.Log;

public class Solution {
    private final String TAG = "Solution";

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
        Log.d(TAG, "" + max);

        return max;
    }

//    public int[] solution2(int[] A, int K) {
//        // write your code in Java SE 8
//    }
}
