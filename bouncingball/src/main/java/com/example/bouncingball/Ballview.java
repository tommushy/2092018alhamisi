package com.example.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class Ballview extends android.support.v7.widget.AppCompatTextView {

    private  Paint paint;
    private class Ball{
        int x = 5 , y = 5 ;
        int rad = 40;
        int dx = 5, dy = 5 ;

    }

    private Ball ball;


    public Ballview(Context context){
        super(context);

        ball = new Ball();
        paint = new Paint();
        paint.setColor(Color.RED);

        ballMover()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(integers -> invalidate())
                .subscribe();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(ball.x,ball.y,ball.rad,paint );
    }
    public Flowable<Integer[]> ballMover(){
        return Flowable.create(emitter -> {
            while(true) {
                if (ball.x < 0) ball.dx = 5;
                if (ball.x >= getWidth()) ball.dx = -5;
                if (ball.y < 0) ball.dy = 5;
                if (ball.y >= getHeight()) ball.dy = -5;

                ball.x += ball.dx;
                ball.y += ball.dy;
                Thread.sleep(50);
                emitter.onNext(new Integer[]{ball.x, ball.y});

            }


        }, BackpressureStrategy.BUFFER);


    }
}
