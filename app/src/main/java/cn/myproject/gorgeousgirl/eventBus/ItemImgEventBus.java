package cn.myproject.gorgeousgirl.eventBus;

import cn.myproject.gorgeousgirl.view.recyclerview.MyViewHolder;

public class ItemImgEventBus {
    private MyViewHolder holder;
    private String url;

    public ItemImgEventBus(MyViewHolder holder, String url) {
        this.holder = holder;
        this.url = url;
    }

    public MyViewHolder getHolder() {
        return holder;
    }

    public String getUrl() {
        return url;
    }
}
