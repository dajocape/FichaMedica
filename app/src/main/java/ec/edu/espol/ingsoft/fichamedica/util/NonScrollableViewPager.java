package ec.edu.espol.ingsoft.fichamedica.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ViewPager customizado para inhabilitar el side scrolling
 */

public class NonScrollableViewPager extends ViewPager {

    public NonScrollableViewPager(Context context) {
        super(context);
    }
    public NonScrollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override public boolean onInterceptTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        return false;
    }
    @Override public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages return false;
        return false;
    }
}

