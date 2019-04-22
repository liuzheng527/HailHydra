package com.yeqiu.hailhaydra.activity;

import android.os.Looper;
import android.view.View;
import android.widget.Button;

import com.yeqiu.hailhaydra.R;
import com.yeqiu.hydra.thread.ThreadUtil;
import com.yeqiu.hydra.utils.LogUtils;


/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2018/8/15
 * @describe：
 * @fix：
 */
public class ThreadActivity extends BaseActivity {

    private Button thread;


    @Override
    protected Object getContentView() {
        return R.layout.activity_thread;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {


        thread = (Button) findViewById(R.id.thread);


        thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread();
            }
        });


    }

    @Override
    protected void initListener() {

    }

    private void thread() {


        ThreadUtil.runOnChildThread(new Runnable() {
            @Override
            public void run() {

                setText();
            }
        });

    }

    private void setText() {

        if (Looper.myLooper() == Looper.getMainLooper()) {
            thread.setText("当前在主线程");
            LogUtils.i("当前在主线程");
        } else {
            LogUtils.i("当前在子线程");

            ThreadUtil.runOnMainThread(new Runnable() {
                @Override
                public void run() {
                    thread.setText("当前在子线程");
                }
            });


        }
    }

    @Override
    public void onClick(View v) {

    }
}
