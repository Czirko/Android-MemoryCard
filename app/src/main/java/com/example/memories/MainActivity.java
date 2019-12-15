package com.example.memories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.memories.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Button> buttons;
    List<Card> cards;
    Button btn;
    Button btnStart;
    int stepCounter;
    int foundIndex;
    TextView tvScore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons=new ArrayList<>();
        cards=new ArrayList<>();
        tvScore=findViewById(R.id.tvScore);
        btnStart=findViewById(R.id.btnStart);
        newGame();







    }



    public void newGame(){
        addAlButtonToList();
        cardToList();
        btnToCard();
        stepCounter=0;
        btnStart.setVisibility(View.VISIBLE);
        addAlButtonToList();




    }

    public void btnToCard(){
        Random ran = new Random();
        int index=12;
        for (Card c:cards
             ) {
            btn=buttons.get(ran.nextInt(index));
           c.btn=btn;
           setTextVisible(btn);
           buttons.remove(btn);
           c.writeBtn();
           index--;
        }



    }

    public void cardToList(){
        Card c = new Card("O");
        cards.add(c);
        Card a = new Card("O");
        cards.add(a);
        Card s = new Card("X");
        cards.add(s);
        Card d = new Card("X");
        cards.add(d);
        Card f = new Card("Y");
        cards.add(f);
        Card g = new Card("Y");
        cards.add(g);
        Card q = new Card("H");
        cards.add(q);
        Card t = new Card("H");
        cards.add(t);

        Card u = new Card("L");
        cards.add(u);
        Card p = new Card("L");
        cards.add(p);
        Card l = new Card("E");
        cards.add(l);
        Card r = new Card("E");
        cards.add(r);


    }



    public void addAlButtonToList(){
        btn=(Button)findViewById(R.id.a1);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.a2);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.a3);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.b1);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.b2);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.b3);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.c1);

        buttons.add(btn);
        btn=(Button)findViewById(R.id.c2);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.c3);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.a4);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.b4);
        buttons.add(btn);
        btn=(Button)findViewById(R.id.c4);
        buttons.add(btn);
    }

    List<Button> opened=new ArrayList<>();


    public void click(View view) {
        stepCounter++;
        tvScore.setText(stepCounter+"");

        Button clicked=(Button) view;

        if(clicked.getTextSize()==0) {
           setTextVisible(clicked);
            opened.add(clicked);

            if (opened.size() == 2) {

                checkPair(clicked);
            }
        }
    }

    public void waitA(int i ){

        //Tread t = new Thread();
                try {
                    Thread.sleep(i); //1000 milliseconds is one second.
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                // TODO
            }
    private void setTextInvisible(Button b){
        b.setTextSize(0);
    }
    private void setTextVisible(Button b){
        b.setTextSize(60);
    }

    private void checkPair(Button cl) {


        if(!opened.get(0).getText().equals(opened.get(1).getText())){
            waitA(500)
            ;
            for (Button b: opened){
                setTextInvisible(b);
            }
        }else{
            foundIndex+=2;
        }

        if(foundIndex>=12){
            Toast.makeText(this,"Congrat",Toast.LENGTH_LONG).show();
            waitA(3000);
            newGame();
        }
        opened.clear();
    }

    public void start(View view) {

        for (Button but:buttons
             ) {setTextInvisible(but);

        }
        btnStart.setVisibility(View.INVISIBLE);
    }
}
