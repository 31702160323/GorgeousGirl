package cn.myproject.gorgeousgirl;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.myproject.gorgeousgirl.Utils.OKUtils;
import cn.myproject.gorgeousgirl.Utils.StatusBarUtil;
import cn.myproject.gorgeousgirl.data.DataBox;
import cn.myproject.gorgeousgirl.eventBus.ItemImgEventBus;
import cn.myproject.gorgeousgirl.view.recyclerview.LoadDataScrollController;
import cn.myproject.gorgeousgirl.view.recyclerview.StaggeredAdapter;
import cn.myproject.gorgeousgirl.view.ITestView;

public class MainActivity extends Activity implements ITestView, LoadDataScrollController.OnRecycleRefreshListener {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private StaggeredAdapter mAdapter;
    private LoadDataScrollController mController;
    private OKUtils mOKUtils;
    private final String URL = "https://www.mxnzp.com/api/image/girl/list/random";

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onItemGilde(ItemImgEventBus eventBus){
        if (eventBus != null){
            String url = eventBus.getUrl();
            if (!url.contains("https")) url = url.replace("http", "https");

            RequestOptions requestOptions = new RequestOptions().error(R.mipmap.ic_launcher);
            Glide.with(this)
                    .load(url)
                    .apply(requestOptions)
                    .into(eventBus.getHolder().img);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.statusBarLightMode(this);

        mSwipeRefreshLayout = findViewById(R.id.swipe);
        mSwipeRefreshLayout.setRefreshing(true);
//        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Toast.makeText(MainActivity.this, "下拉", Toast.LENGTH_SHORT).show();
//            }
//        });
        mRecyclerView = new RecyclerView(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mController = new LoadDataScrollController(this);

        /**
         * 设置监听
         */
        mRecyclerView.addOnScrollListener(mController);
        mSwipeRefreshLayout.addView(mRecyclerView);
        mSwipeRefreshLayout.setOnRefreshListener(mController);

        mOKUtils = OKUtils.getInstance(this);
        mOKUtils.get(URL);
    }

    @Override
    public void updateUI() {
        final int start = DataBox.getmList().size();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mRecyclerView.getAdapter() == null) {
                    mAdapter = StaggeredAdapter.getInstance(MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    if (start >= 20) {
                        mAdapter.notifyItemChanged(start - 10, start);
                    } else {
                        mAdapter.notifyDataSetChanged();
                    }
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void warningUI(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void refresh() {
        //刷新的接口调
        DataBox.getmList().clear();
        mOKUtils.get(URL);
        //        设置数据加载结束的监听状态
        mController.setLoadDataStatus(false);
    }

    @Override
    public void loadMore() {
        //加载更多的接口回调
//        pd.setMessage("正在刷新……");
//        pd.show();
        mOKUtils.get(URL);
//        设置数据加载结束的监听状态
        mController.setLoadDataStatus(false);
    }

    @Override
    public void stopGilde(boolean b) {
        if (b) {
            Log.e("GorgeousGirl","yc---initRecyclerView"+ "恢复Glide加载图片");
            Glide.with(this).resumeRequests();
        }else {
            Log.e("GorgeousGirl","yc---initRecyclerView"+"禁止Glide加载图片");
            Glide.with(this).pauseRequests();
        }
    }
}
