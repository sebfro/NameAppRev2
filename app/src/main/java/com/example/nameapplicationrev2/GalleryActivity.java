package com.example.nameapplicationrev2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MainActivity.T> drawableArrayList;

    private ArrayList<String> image_titles = new ArrayList<String>();

    private ArrayList<Integer> image_ids = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        drawableArrayList = MainActivity.drawableArrayList;

        image_titles.add("Sebastian");
        image_titles.add("Daniel");
        image_titles.add("Fedme");

        image_ids.add(R.drawable.img1);
        image_ids.add(R.drawable.img2);
        image_ids.add(R.drawable.img3);

        //Use this if changes in content do not change the layout size of the recyclerview
        mRecyclerView.setHasFixedSize(true);

        //Use a linear layout manager
        mLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<CreateList> createLists = prepareData();

        //specify an adapter
        mAdapter = new myAdapter(getApplicationContext(), createLists, drawableArrayList);
        mRecyclerView.setAdapter(mAdapter);

    }



    private ArrayList<CreateList> prepareData(){
        ArrayList<CreateList> images = new ArrayList<>();
        for(int i = 0; i < image_ids.size(); i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles.get(i));
            createList.setImage_ID(image_ids.get(i));
            images.add(createList);
        }
        return images;
    }
}
