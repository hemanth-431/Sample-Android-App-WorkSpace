package com.example.facerecognisation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.microsoft.projectoxford.emotion.contract.FaceRectangle;

public class imageadapter {


    public static Bitmap bitmap(Bitmap bitmap, FaceRectangle faceRectangle,String status)
    {
        Bitmap bitmap1=bitmap.copy(Bitmap.Config.ARGB_8888,true);
        Canvas canvas=new Canvas(bitmap1);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);
        canvas.drawRect(faceRectangle.left,faceRectangle.top,faceRectangle.left+faceRectangle.width,faceRectangle.top+faceRectangle.height,paint);
int Cx=faceRectangle.left+faceRectangle.width;
int Cy=faceRectangle.top+faceRectangle.height;
draw(canvas,50,Cx/2+Cx/5,Cy+70,Color.WHITE,status);
return bitmap;
    }

    private static void draw(Canvas canvas, int textsize, int cx,int cy, int color, String status) {

Paint paint=new Paint();
paint.setAntiAlias(true);
paint.setStyle(Paint.Style.FILL);
paint.setColor(color);
paint.setTextSize(textsize);
canvas.drawText(status,cx,cy,paint);
    }
}
