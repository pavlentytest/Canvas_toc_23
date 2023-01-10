package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED); // цвет маркера
        //paint.setColor(Color.parseColor("#00ff00"));
        // rgb -
        // cmyk -
        paint.setAntiAlias(true); // сглаживание
        paint.setStrokeWidth(10); // толщина маркера
        paint.setStyle(Paint.Style.STROKE); // стиль заливки
        int y = getHeight()/2;
        int x = getWidth()/2;
        canvas.drawColor(Color.BLUE); // цвет фона
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(x,y,150,paint);
      //  canvas.drawLine(100,100, 200, 200, paint);
        // public Rect(int left, int top, int right, int bottom)
        Log.d("RRR","height:"+getHeight()+", width:"+getWidth());
        //Rect rect = new Rect(20, 60, 500, 300);
       // canvas.drawRect(rect, paint);
        RectF rect = new RectF(20, 60, 500, 300);
        canvas.drawOval(rect, paint);
        paint.setTextSize(100);
        canvas.drawText("Samsung IT School",200,500,paint);

        float rotate_center_x = 200; //центр поворота холста по оси X
        float rotate_center_y = 200; // центр поворота холста по оси Y
        float rotate_angle = 45; //угол поворота

        // поворачиваем холст
        canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);
        paint.setColor(Color.RED);
        canvas.drawText("Happy New Year",0,450,paint);
        canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);


        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.football);
        canvas.drawBitmap(image, x - image.getWidth(), y - image.getHeight(), paint);

        Path path = new Path();
        path.moveTo(100,100);
        path.lineTo(200,300);
        path.lineTo(600,600);
        canvas.drawPath(path,paint);
    }
}
