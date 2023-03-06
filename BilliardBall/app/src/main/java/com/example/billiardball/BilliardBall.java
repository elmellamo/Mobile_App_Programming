package com.example.billiardball;

/*
// step 1
public class BilliardBall extends View {
    private ShapeDrawable mDrawable;

    public BilliardBall(Context context) {
        super(context);

        int x = 0;
        int y = 0;
        int width = 100;
        int height = 100;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.RED);
        mDrawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        mDrawable.draw(canvas);
    }
}
*/

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

// step 2
public class BilliardBall extends View {
    private ShapeDrawable mDrawable;
    // private ShapeDrawable mDrawableRect;

    int x = 50;
    int y = 50;
    int width = 100;
    int height = 100;

    int cx, cy;

    int dir_x = 1;
    int dir_y = 1;

    int dx = 5;
    int dy = 15;

    int screen_width  = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;

    public BilliardBall(Context context) {
        super(context);

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.RED);

        // mDrawableRect = new ShapeDrawable(new RectShape());
    }

    protected void onDraw(Canvas canvas) {
        cx = x + width/2;
        cy = y + height/2;

        if (cx <= width/2)
            dir_x = 1;
        else if (cx >= screen_width - width/2)
            dir_x = -1;

        if (cy <= height/2)
            dir_y = 1;
        else if (cy >= screen_height - height/2)
            dir_y = -1;

        x += dir_x * dx;
        y += dir_y * dy;

        canvas.drawColor(Color.BLUE);

        /*
        mDrawableRect.getPaint().setColor(Color.BLUE);
        mDrawableRect.setBounds(100, 100, screen_width - 100, screen_height - 100);
        mDrawableRect.draw(canvas);
        */

        mDrawable.setBounds(x, y, x + width, y + height);
        mDrawable.draw(canvas);

        invalidate();
    }
}
