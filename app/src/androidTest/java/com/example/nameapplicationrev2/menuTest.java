package com.example.nameapplicationrev2;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;


import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by sebas on 02.02.2017.
 */



@RunWith(AndroidJUnit4.class)
public class menuTest  {

    @Rule
    public ActivityTestRule mainActivityTestRule = new ActivityTestRule(MainActivity.class);

    private Button btn;
    private Button[] btnList = new Button[4];
    private MainActivity mActivity;

    @Before
    protected void setUp() throws Exception{

        mActivity = (MainActivity) mainActivityTestRule.getActivity();

        btnList[0] = (Button) mActivity.findViewById(R.id.addImageBtn);
        btnList[1] = (Button) mActivity.findViewById(R.id.listNamesBtn);
        btnList[2] = (Button) mActivity.findViewById(R.id.playBtn);
        btnList[3] = (Button) mActivity.findViewById(R.id.galleryBtn);

    }


}
