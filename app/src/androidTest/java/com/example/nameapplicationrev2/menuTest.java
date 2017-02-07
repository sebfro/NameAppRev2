package com.example.nameapplicationrev2;

import android.app.Activity;
import android.content.Intent;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

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
    private boolean bool = true;

    @Before
    public void setUp() throws Exception{

        mActivity = (MainActivity) mainActivityTestRule.getActivity();

        btnList[0] = (Button) mActivity.findViewById(R.id.listNamesBtn);
        btnList[1] = (Button) mActivity.findViewById(R.id.addImageBtn);
        btnList[2] = (Button) mActivity.findViewById(R.id.playBtn);
        btnList[3] = (Button) mActivity.findViewById(R.id.galleryBtn);

    }

    @Test
    public void nothing(){

    }

    @UiThreadTest
    public void btnTesting(){
        for (Button b : btnList){
            assertEquals(b.callOnClick(), bool);
        }

    }



    @UiThreadTest
    public void startNameList(){
        btnList[0].performClick();
        RecyclerView rV = (RecyclerView) mActivity.findViewById(R.id.list_recycler_view);
        ImageView iV = (ImageView) mActivity.findViewById(R.id.img);
        TextView tV = (TextView) mActivity.findViewById(R.id.name);
        assertEquals((rV != null), true);
        assertEquals((tV != null), true);
        assertEquals((iV != null), true);

        btnList[1].performClick();
        EditText eT = (EditText) mActivity.findViewById(R.id.userInput);
        Button btn = (Button) mActivity.findViewById(R.id.button2);
        assertEquals((btn != null), true);
        assertEquals((eT != null), true);


        btnList[2].performClick();
        btn = (Button) mActivity.findViewById(R.id.guessBtn);
        Button btn2 = (Button) mActivity.findViewById(R.id.menuBtn);
        tV = (TextView) mActivity.findViewById(R.id.score);
        assertEquals((btn != null), true);
        assertEquals((btn2 != null), true);
        assertEquals((tV != null), true);

        btnList[3].performClick();
        rV = (RecyclerView) mActivity.findViewById(R.id.list_recycler_view);
        iV = (ImageView) mActivity.findViewById(R.id.images);
        assertEquals((rV != null), true);
        assertEquals((iV != null), true);
    }

    @UiThreadTest
    public void startLearningMode(){
        btnList[2].performClick();
        Button btn = (Button) mActivity.findViewById(R.id.guessBtn);
    }


}
