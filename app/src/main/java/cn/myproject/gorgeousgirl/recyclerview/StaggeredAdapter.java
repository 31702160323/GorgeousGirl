package cn.myproject.gorgeousgirl.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import cn.myproject.gorgeousgirl.R;
import cn.myproject.gorgeousgirl.Utils.dpTopx;
import cn.myproject.gorgeousgirl.data.DataBox;
import cn.myproject.gorgeousgirl.eventBus.ItemImgEventBus;

public class StaggeredAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private static StaggeredAdapter mStaggeredAdapter;
    private final int mItemWidth;
    private int width;
    private int height;
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
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        sizeStr = DataBox.getmList().get(i).getImageSize();
//        strings = sizeStr.split("x");
//        size = Float.parseFloat(strings[0])/ Float.parseFloat(strings[1]);
//        width = mItemWidth;
//        height = (int) (mItemWidth * size);
//        myViewHolder.img.measure(width, height);

        sizeStr = DataBox.getmList().get(i).getImageSize();
        strings = sizeStr.split("x");
        size = Float.parseFloat(strings[1])/ Float.parseFloat(strings[0]);
        myViewHolder.img.setScale(size);
        EventBus.getDefault().post(new ItemImgEventBus(myViewHolder, DataBox.getmList().get(i).getImageUrl()));
//        gildeLoadImage(myViewHolder, DataBox.getmList().get(i).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return DataBox.getmList().size();
    }

//    private void gildeLoadImage(final MyViewHolder holder, String url){
//        url = url.replace("http", "https");
//        url = url.replace("httpss", "https");
////        final String newUrl = url;
//
//        RequestOptions requestOptions = new RequestOptions().error(R.mipmap.ic_launcher);
//        Glide.with(mContext)
//                .load(url)
//                .apply(requestOptions)
//                .into(holder.img);
//
//
////        ProgressInterceptor.addListener(newUrl, new ProgressListener() {
////            @Override
////            public void onProgress(int progress) {
////                Log.d(TAG, "onProgress: " + progress);
////            }
////        });
////
////        SimpleTarget<Drawable> simpleTarge = new SimpleTarget<Drawable>() {
////            @Override
////            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
////                holder.img.setImageDrawable(resource);
////                holder.progressBar.setVisibility(View.GONE);
////                Log.d(TAG, "onResourceReady: ");
////                ProgressInterceptor.removeListener(newUrl);
////            }
////
////            @Override
////            public void onStart() {
////                super.onStart();
////                holder.progressBar.setVisibility(View.VISIBLE);
////                Log.d(TAG, "onStart: ");
////            }
////        };
////
////        GlideApp.with(mContext)
////                .load(newUrl)
////                .diskCacheStrategy(DiskCacheStrategy.NONE)
////                .skipMemoryCache(true)
////                .apply(requestOptions)
////                .into(simpleTarge);
//    }
}
