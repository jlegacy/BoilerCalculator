package com.example.jlegacy.boilercalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DrawFireTubesView extends View {

    private int screenW;
    private int screenH;
    private Context myContext;

    private float scale;


    private Paint whitePaint;
    private Paint redPaint;
    private Paint greenPaint;


    public DrawFireTubesView(Context context) {
        super(context);
        myContext = context;
        scale = myContext.getResources().getDisplayMetrics().density;
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.STROKE);
        whitePaint.setTextAlign(Paint.Align.LEFT);
        whitePaint.setTextSize(scale * 15);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);

        greenPaint = new Paint();
        greenPaint.setColor(Color.GREEN);

        View v = this;

        v.setBackgroundColor(Color.WHITE);

        v.invalidate();


    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        FireTubeObjectSingleton myInstance = FireTubeObjectSingleton.getInstance();

        int width = this.getWidth();
        int height = this.getHeight();

        //set Scale
        double scale = width / myInstance.diameterOfBoiler;

        //Draw Diameter
        canvas.drawCircle(width / 2, height / 2, (float) myInstance.diameterOfBoiler / 2 * (float) scale, redPaint);


        int xPosScale = width / 2;
        int yPosScale = height / 2;

        //Based on a 500 point grid//
        for (Point element : myInstance.points) {
            canvas.drawCircle(((float) element.x - 500) * (float) scale + xPosScale, ((float) element.y - 500) * (float) scale + yPosScale, (float) myInstance.diameterOfFiretube / 2 * (float) scale, greenPaint);
        }



        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (eventaction) {

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }


}
