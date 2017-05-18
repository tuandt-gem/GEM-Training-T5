package gem.vn.uitask.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import gem.vn.uitask.R;

/**
 * Created by Lush on 5/18/2017.
 */

public class TimeTextView extends TextView {
    public TimeTextView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public TimeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public TimeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    public TimeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initFrom(context, attrs);
    }

    private void initFrom(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeTextView);
            int time = typedArray.getInt(R.styleable.TimeTextView_time, -1);
            typedArray.recycle();
            if (time != -1) {
                this.setText(String.format("%s", fromSecondsToTimeString(time)));
            }
        }
    }

    String fromSecondsToTimeString(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
