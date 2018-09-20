package com.jun2yah.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jun2yah.test.codiitytest.R;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Solution";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Solution solution = new Solution();

        int result = solution.solution1(561892);
        Log.d(TAG, "solution1 = " + result);

    }
}
