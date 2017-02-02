package com.example.nameapplicationrev2;

import android.graphics.drawable.Drawable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sebas on 31.01.2017.
 */
public class myAdapterTest {
    private int itemCount;
    private ArrayList<CreateList> mDataset;
    private ArrayList<MainActivity.T> newImgs = new ArrayList<>();



    @Before
    public void setUp() throws Exception {
        itemCount = 3;
        mDataset = new ArrayList<CreateList>();

        CreateList list1 = new CreateList();
        list1.setImage_ID(R.drawable.img1);
        list1.setImage_title("Seb");
        mDataset.add(list1);
        list1.setImage_ID(R.drawable.img2);
        list1.setImage_title("Dan");
        mDataset.add(list1);
        list1.setImage_ID(R.drawable.img3);
        list1.setImage_title("Fed");
        mDataset.add(list1);
    }

    @Test
    public void getItemCount() throws Exception {
        for (int i = itemCount; i > 0; i--){
            assertEquals(mDataset.size(), i);
            mDataset.remove(0);
        }

    }

}