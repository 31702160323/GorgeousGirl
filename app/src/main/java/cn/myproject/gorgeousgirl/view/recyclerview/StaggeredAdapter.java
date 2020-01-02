package cn.myproject.gorgeousgirl.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import cn.myproject.gorgeousgirl.R;
import cn.myproject.gorgeousgirl.Utils.dpTopx;
import cn.myproject.gorgeousgirl.data.DataBox;
import cn.myproject.gorgeousgirl.eventBus.ItemImgEventBus;
import cn.myproject.gorgeousgirl.view.ImageFullDialog;
import cn.myproject.gorgeousgirl.view.ScaleImageView;

public class StaggeredAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private static StaggeredAdapter mStaggeredAdapter;
    private final int mItemWidth;
    private float size;
    private String[] strings;
    private String sizeStr;
    private static final String TAG = "StaggeredAdapter";

    public static StaggeredAdapter getInstance(Context mContext){
        if (mStaggeredAdapter == null) {
            mStaggeredAdapter = new StaggeredAdapter(mContext);
        }
        return mStaggeredAdapter;
    }

    public StaggeredAdapter(Context context) {
        this.mContext = context;
        mItemWidth = context.getResources().getDisplayMetrics().widthPixels / 2 - dpTopx.dip2px(mContext, 4.0f);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.list_card, null);
        final MyViewHolder holder = new MyViewHolder(mContext, view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.layout.removeView(holder.img);
                ImageFullDialog.showDialog(mContext, holder.img, new ImageFullDialog.FullToSmallListener() {
                    @Override
                    public void shutDialog(ScaleImageView imageView) {
                        holder.layout.addView(imageView);
                    }
                });
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        sizeStr = DataBox.getmList().get(i).getImageSize();
        strings = sizeStr.split("x");
        size = Float.parseFloat(strings[1])/ Float.parseFloat(strings[0]);
        myViewHolder.img.setScale(size);
        EventBus.getDefault().post(new ItemImgEventBus(myViewHolder, DataBox.getmList().get(i).getImageUrl()));
    }

    @Override
    public int getItemCount() {
        return DataBox.getmList().size();
    }
}
