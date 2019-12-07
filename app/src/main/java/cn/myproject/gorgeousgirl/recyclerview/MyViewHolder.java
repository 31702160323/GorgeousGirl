package cn.myproject.gorgeousgirl.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.myproject.gorgeousgirl.R;
import cn.myproject.gorgeousgirl.view.ScaleImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public ScaleImageView img;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
    }
}
