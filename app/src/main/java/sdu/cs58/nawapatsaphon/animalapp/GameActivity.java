package sdu.cs58.nawapatsaphon.animalapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    //Explicit ประกาศตัวแปร
    Button btn1,btn2,btn3,btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer; //เล่นไฟล์เสียง
    int questionCount = 1; //ตัวแปรเก็บจำนวนข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>(); //เป็นชนิด  array สำหรับการสุ่มข้อคำถาม
    String answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //ผูก Element กับตัวเเปรบน JAVA
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        questionImageView=findViewById(R.id.imvQuestion);
        volumnImageButton=findViewById(R.id.imbVolumn);

        //เเสดงคำถามบนหน้าจอ
        for (int i=1; i<=questionCount; i++) {
            qID.add(i);
        }
        Collections.shuffle(qID); //กำหนดให้ Landom คำถาม
        setQuestion(qID.remove(0));
    }//end onCreate method

    private void setQuestion(int qID) { //ใช้สำหรับกำหนดข้อคำถามเเละเฉลยในเเต่ละข้อ
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("นก");
            choice.add("ม้า");
            choice.add("เเมว");
            choice.add("ยุง");
            Collections.shuffle(choice); //Ramdom  choice
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));
        }

    }//end setQuestion Method
        public void playSound(View View) {
            mediaPlayer.start();

        }// end playSound Method


}//end Class

