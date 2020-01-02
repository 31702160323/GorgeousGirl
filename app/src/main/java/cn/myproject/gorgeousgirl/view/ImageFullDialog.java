package cn.myproject.gorgeousgirl.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.RelativeLayout;

import cn.myproject.gorgeousgirl.R;

public class ImageFullDialog extends Dialog {

    private static ImageFullDialog ImageFullDialog;
    private RelativeLayout layout;
    private ScaleImageView mImg;
    private FullToSmallListener mListener;

    public ImageFullDialog(Context context) {
        super(context, android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        layout.removeView(mImg);
        mListener.shutDialog(mImg);
    }

    public static void showDialog(Context context, ScaleImageView img, FullToSmallListener listener) {
        ImageFullDialog = new ImageFullDialog(context);
        ImageFullDialog.initDialog(img, listener);
        ImageFullDialog.show();
    }

    private void initDialog(ScaleImageView img, FullToSmallListener listener){
        mListener = listener;
        mImg = img;
        setContentView(R.layout.dialog_video_layout);
        layout = findViewById(R.id.root_view);
        layout.addView(mImg);
    }

    public interface FullToSmallListener {
        void shutDialog(ScaleImageView imageView);//关闭dialog回调
    }
}
