package com.example.nameapplicationrev2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sebas on 02.02.2017.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class learningActivityTest {

    @Rule
    public ActivityTestRule learningActivityTestRule = new ActivityTestRule(LearningActivity.class);

    private Button btnExit;
    private Button btnGuess;
    private TextView scoreView;
    private EditText userInput;
    private ImageView img;
    private String score;
    private int intScore = 0;
    private LearningActivity lActivity;
    private String[] nameList = {"Sebastian","Daniel","Fedme"};
    private HashMap<Integer, LearningActivity.imgAndAns> map = new HashMap<>();

    @Before
    public void setUp() throws Exception{

        lActivity = (LearningActivity) learningActivityTestRule.getActivity();


        btnExit = (Button) lActivity.findViewById(R.id.menuBtn);
        btnGuess = (Button) lActivity.findViewById(R.id.guessBtn);
        scoreView = (TextView) lActivity.findViewById(R.id.score);
        score = scoreView.getText().toString();
        userInput = (EditText) lActivity.findViewById(R.id.guessText);
        map = LearningActivity.imgAndAnsHashMap;
        img = (ImageView) lActivity.findViewById(R.id.imageView2);
    }

    @Test
    public void inputFieldTest(){
        assertEquals("", userInput.getText().toString());
        //userInput.setText(nameList[0]);
        //assertEquals(nameList[0], userInput.getText().toString());
    }

    //Checks that the score is counted correctly
    @UiThreadTest
    public void guessesTest(){
        int tmp = 0;
        for (int i = 0; i < 100; i++) {
            userInput.setText(nameList[tmp]);
            btnGuess.performClick();
            if(nameList[0].equals(lActivity.right_ans)) {
                intScore++;
                assertEquals(intScore, lActivity.score);
            }
            if(tmp == 2)
                tmp = 0;
            else
                tmp++;
        }
        assertEquals(intScore, lActivity.score);
    }
    //Check that there are atleast three imgs being shown.
    @UiThreadTest
    public void ranTest(){
        int numImgs = 0;
        Drawable[] occured = new Drawable[3];

        for(int i = 0; i < 100; i++){
            btnGuess.performClick();
            if(occured.length == 0){
                occured[0] = img.getDrawable();
            } else if (occured.length < 3){
                Drawable newImg = img.getDrawable();
                boolean found = false;
                for(int r = 0; r < 3; r++){
                    if(occured[r] != null && occured[r] == newImg){
                        found = true;
                    }
                }
                if(found) occured[occured.length] = newImg;
            } else {
                i = 100;
            }
        }
        assertEquals(occured.length, 3);

    }
    //Test if the buttons work.
    @UiThreadTest
    public void btnTest(){
        assertEquals(btnExit.callOnClick(), true);
        assertEquals(btnGuess.callOnClick(), true);
    }
}
