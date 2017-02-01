package com.example.nameapplicationrev2;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.example.nameapplicationrev2.R.drawable.img1;
import static org.junit.Assert.*;

/**
 * Created by sebas on 31.01.2017.
 */
public class CreateListTest {
    private CreateList list = new CreateList();
    private ArrayList<CreateList> createListArrayList = new ArrayList<>();
    private String[] nameList = {"seb", "dan", "fed","per","ole"};
    private Integer[] imgList = {R.drawable.img1, R.drawable.img2, R.drawable.img3, 123, 567};

    private final String DEBUG_TAG = "Error";

    @Before
    public void setUp() throws Exception {
        list.setImage_ID(imgList[0]);
        list.setImage_title(nameList[0]);
        createListArrayList.add(list);

        CreateList list1 = new CreateList();
        list1.setImage_ID(imgList[1]);
        list1.setImage_title(nameList[1]);
        createListArrayList.add(list1);

        CreateList list2 = new CreateList();
        list2.setImage_ID(imgList[2]);
        list2.setImage_title(nameList[2]);
        createListArrayList.add(list2);
    }

    @Test
    public void getImage_title() throws Exception {
        assertEquals(createListArrayList.get(0).getImage_title(), nameList[0]);
        assertEquals(createListArrayList.get(1).getImage_title(), nameList[1]);
        assertEquals(createListArrayList.get(2).getImage_title(), nameList[2]);


    }

    @Test
    public void setImage_title() throws Exception {
        list.setImage_title(nameList[3]);
        assertEquals(list.getImage_title(), nameList[3]);
        list.setImage_title(nameList[4]);
        assertEquals(list.getImage_title(), nameList[4]);
    }

    @Test
    public void getImage_ID() throws Exception {
        assertEquals(createListArrayList.get(0).getImage_ID(), imgList[0]);
        assertEquals(createListArrayList.get(1).getImage_ID(), imgList[1]);
        assertEquals(createListArrayList.get(2).getImage_ID(), imgList[2]);

    }

    @Test
    public void setImage_ID() throws Exception {
        list.setImage_ID(imgList[3]);
        assertEquals(list.getImage_ID(), imgList[3]);
        list.setImage_ID(imgList[4]);
        assertEquals(list.getImage_ID(), imgList[4]);
    }

}