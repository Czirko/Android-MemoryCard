package com.example.memories.model;

import android.widget.Button;

public class Card {
   public Button btn;
   public String pic;

    public Card(String pic) {
        this.pic = pic;
    }

    public Card() {
    }

    public void writeBtn(){
        btn.setText(pic);

    }

}
