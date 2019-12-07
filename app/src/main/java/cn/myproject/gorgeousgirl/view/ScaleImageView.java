package cn.myproject.gorgeousgirl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 按比例缩放的ImageView
 * 用于图片按比例缩放（宽度填满，高度自适应）
 * 注：如果不指定宽度，则默认填满屏幕。
 */
public class ScaleImageView extends android.support.v7.widget.AppCompatImageView {

    private float scale;
    private static final String TAG = "ScaleImageView";

    public ScaleImageView(Context context) {
        super(context);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Drawable drawable = getDrawable();
//        if (drawable != null) {
//            int width = MeasureSpec.getSize(widthMeasureSpec);//高度根据宽度计算而得
//            int height = (int) Math.ceil((float) width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
//            setMeasuredDimension(width, height);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
        if (scale > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);
            if (width > 0){
                height = (int) ((float)width * scale);
            }
            Log.e(TAG, "width: " + width + "height: " + height);
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}