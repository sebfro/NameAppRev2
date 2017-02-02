package com.example.nameapplicationrev2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class LearningActivity extends AppCompatActivity {

    public final static String MESSAGE = "Du fylte ikke inn!";
    public int score = 0;
    String right_ans = "";
    public int num = 0;
    public static HashMap<Integer, imgAndAns> imgAndAnsHashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);


        imgAndAnsHashMap.put(1,new imgAndAns("sebastian", R.drawable.img1));
        imgAndAnsHashMap.put(2,new imgAndAns("daniel", R.drawable.img2));
        imgAndAnsHashMap.put(3,new imgAndAns("fedme", R.drawable.img3));

        setImage();

    }

    public void setImage() {
        Random rand = new Random();
        num = rand.nextInt(3) + 1;

        ImageView image = (ImageView) findViewById(R.id.imageView2);
        EditText editText = (EditText) findViewById(R.id.guessText);
        editText.setText("");

        image.setImageResource(imgAndAnsHashMap.get(num).getImg());
        right_ans = imgAndAnsHashMap.get(num).getAns();

    }


    public void mainMenu(View v) {

        Intent intent = new Intent(this, DisplayScoreActivity.class);
        TextView tw = (TextView) findViewById(R.id.score);
        String message = tw.getText().toString();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }

    public void guess (View v) {
        ImageView i = (ImageView) findViewById(R.id.imageView2);
        EditText editText = (EditText) findViewById(R.id.guessText);
        String answer = editText.getText().toString().toLowerCase();


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "";

        if(answer.equals(right_ans)) {
            text = "You guessed correct";
            score++;
            updateScore(score);

        } else {
            text = "The correct answer was: " + right_ans;

        }

        Toast.makeText(context, text, duration).show();
        setImage();
    }

    public void updateScore(int score) {
        TextView tw = (TextView)findViewById(R.id.score);
        tw.setText("Score: " + score);
    }

    public class imgAndAns{
        private String ans;
        private Integer img;
        public imgAndAns(String ans, Integer img){
            this.ans = ans;
            this.img = img;
        }
        public int getImg(){return img;}
        public String getAns(){return ans;}
        public void setImg(Integer img){this.img = img;}
        public void setAns(String ans){this.ans = ans;}
    }
}
