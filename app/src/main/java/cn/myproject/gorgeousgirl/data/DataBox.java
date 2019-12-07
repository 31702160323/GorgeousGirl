package cn.myproject.gorgeousgirl.data;

import java.util.ArrayList;
import java.util.List;

public class DataBox {
    private static List<JsonData.DataBean> mList = new ArrayList<>();

    public static List<JsonData.DataBean> getmList() {
        return mList;
    }

    public static void setmList(List<JsonData.DataBean> list) {
        mList.addAll(list);
    }
}
