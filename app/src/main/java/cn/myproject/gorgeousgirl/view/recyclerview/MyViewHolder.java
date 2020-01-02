package cn.myproject.gorgeousgirl.view.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.myproject.gorgeousgirl.R;
import cn.myproject.gorgeousgirl.view.ScaleImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ScaleImageView img;
    public LinearLayout layout;

    public MyViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        img = new ScaleImageView(context);
        img.setBackgroundColor(Color.WHITE);
        layout = itemView.findViewById(R.id.list_card);
        layout.addView(img);
    }
}
