package com.jun2yah.test;

import android.util.Log;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private final String TAG = "Solution";

    public int solutionA(String S) {
        // write your code in Java SE 8

        String sub;
        int length = S.length();
        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                sub = S.substring(i, i + j);
                subStrings.add(sub);
            }
        }

        Pattern p = Pattern.compile("([0-9])");
        Iterator iterator = subStrings.iterator();
        int maxLength = 0;
        int subLength = 0;

        while (iterator.hasNext()) {
            String temp = (String) iterator.next();
            boolean hasUppercase = !temp.equals(temp.toLowerCase());

            Matcher m = p.matcher(temp);
            if (m.find() || !hasUppercase) {
                iterator.remove();
            } else {
                subLength = temp.length();
                if (subLength > maxLength) {
                    maxLength = subLength;
                }
            }
        }

        if (maxLength == 0) {
            return -1;
        }

        return maxLength;
    }

    public int solutionB(int A, int B) {
        // write your code in Java SE 8

        int C;

        if ((A < 0 || A > 100000000) || (B < 0 || B > 100000000)) {
            return -1;
        }

        String sA = String.valueOf(A);
        String sB = String.valueOf(B);
        StringBuilder sC = new StringBuilder();

        for (int i = 0; i < sA.length() || i < sB.length(); i++) {
            if (i < sA.length()) {
                sC.append(sA.charAt(i));
            }
            if (i < sB.length()) {
                sC.append(sB.charAt(i));
            }
        }

        C = Integer.valueOf(sC.toString());

        if (C > 100000000) {
            return -1;
        }

        return C;
    }

    public int solutionC(String S) {
        // write your code in Java SE 8

        int len = S.length();
        int open[] = new int[len + 1];
        int close[] = new int[len + 1];
        int K = -1;

        open[0] = 0;
        close[len] = 0;

        if (S.charAt(0) == '(') {
            open[1] = 1;
        }

        if (S.charAt(len - 1) == ')') {
            close[len - 1] = 1;
        }

        for (int i = 1; i < len; i++) {
            if (S.charAt(i) == '(')
                open[i + 1] = open[i] + 1;
            else
                open[i + 1] = open[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            if (S.charAt(i) == ')')
                close[i] = close[i + 1] + 1;
            else
                close[i] = close[i + 1];
        }

        if (open[len] == 0) {
            return len;
        }

        if (close[0] == 0) {
            return 0;
        }

        for (int i = 0; i <= len; i++) {
            if (open[i] == close[i]) {
                K = i;
            }
        }

        return K;
    }


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
            a[(i + K) % a.length] = A[i];
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

        for (int i : A) {
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

        for (int i : A) {
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

        return distance % D == 0 ? distance / D : distance / D + 1;
    }

    /**
     * TapeEquilibrium
     *
     * @param A
     * @return
     */
    public int solution3_3(int[] A) {
        // write your code in Java SE 8
        int sumFront = 0;
        int sumLast = 0;

        for (int i : A) {
            sumLast += i;
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {
            sumFront += A[i - 1];
            sumLast -= A[i - 1];

            int diff = Math.abs(sumFront - sumLast);

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    /**
     * PermCheck
     *
     * @param A
     * @return
     */
    public int solution4_1(int[] A) {
        // write your code in Java SE 8
        Set<Integer> num = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] > A.length) {
                return 0;
            }

            if (num.contains(A[i])) {
                return 0;
            }

            num.add(A[i]);
        }

        return 1;
    }

    /**
     * FrogRiverOne
     *
     * @param X
     * @param A
     * @return
     */
    public int solution(int X, int[] A) {
        // write your code in Java SE 8

        return 0;
    }
}
