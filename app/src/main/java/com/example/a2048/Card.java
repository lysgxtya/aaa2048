package com.example.a2048;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {
    public Card(Context context){
        super(context);
        setNumber(0);
        label=new TextView(getContext());//初始化
        label.setTextSize(64);
        LayoutParams lp=new LayoutParams(-1,-1);
        addView(label,lp);
    }
    private int number=0;
    public int getNumber(){

        return number;
    }
    public void setNumber(int number){
        this.number=number;
        label.setText(number+"");
    }
    public boolean equals(Card a){  //判断用于合成的两张卡片是否相同,相同即可相加
        return getNumber()==a.getNumber();
    }
    private TextView label;//最后需要呈现文字
}
