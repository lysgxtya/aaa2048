package com.example.a2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class GameView extends GridLayout {
    public GameView(Context context, AttributeSet attrs){
        super(context,attrs);
        initGameView();
    }
    public GameView(Context context){
        super(context);
        initGameView();
    }
    public GameView(Context context, AttributeSet attrs,int defStyles){
        super(context,attrs,defStyles);
        initGameView();
    }
    private void initGameView(){
       setOnTouchListener(new View.OnTouchListener(){
           private  float startX,startY,offsetX,offsetY;//用户手势,X水平，Y垂直

           public boolean onTouch(View v, MotionEvent event){
               switch (event.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       startX=event.getX();
                       startY=event.getY();
                       break;
                   case  MotionEvent.ACTION_UP:
                       offsetX=event.getX()-startX;
                       offsetY=event.getY()-startY;
                       if(Math.abs(offsetX)>Math.abs(offsetY)){//水平方向大于垂直方向
                           if (offsetX<-5){//             用户意图往左，允许一定误差
                               huadongleft();
                           }
                           else if (offsetX > 5) {   //向右
                               huadongright();
                           }
                       }
                       else {

                            if (offsetY > 5) {   //向上
                               huadongup();
                           }
                             else if (offsetY<-5){//             向下
                               huadongdown();
                           }

                       }

                       break;

               }
               return true;
           }
       });

    }
    protected void onSizeChanged(int w,int h,int oldw,int oidh){//卡片动态适应手机的宽和高
        super.onSizeChanged(w,h,oldw,oidh);
        int cardWidth=(Math.min(w,h)-15)/4;//得出每一张卡片的宽高
        addCards(cardWidth,cardWidth);
    }

    private void addCards(int cardwidth,int cardheight){//添加卡片
        Card c;
        for(int y=0;y<4;y++){    //4列
            for(int x=0;x<4;x++){  //4行
                 c=new Card(getContext());
                 c.setNumber(2);
                 addView(c,cardwidth,cardheight);
            }
        }
    }
    private void huadongleft(){

    }
    private void huadongright(){

    }
    private void huadongup(){

    }
    private void huadongdown(){

    }
}
