package com.jun2yah.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jun2yah.test.codiitytest.R;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Solution";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Solution solution = new Solution();

        int result1 = solution.solution1(561892);
        Log.d(TAG, "result1 = " + result1);

        int[] result2_1 = solution.solution2_1(new int[]{3, 8, 9, 7, 6}, 3);
        Log.d(TAG, "result2_1 = " + Arrays.toString(result2_1));

        int result2_2 = solution.solution2_2(new int[]{3, 8, 9, 7, 6});
        Log.d(TAG, "result2_2 = " + result2_2);

        int result3_3 = solution.solution3_3(new int[]{3, 1, 2, 4, 3});
        Log.d(TAG, "result3_3 = " + result3_3);

    }
}
