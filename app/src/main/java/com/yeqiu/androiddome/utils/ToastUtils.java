package com.yeqiu.androiddome.utils;

import android.content.Context;
import android.widget.Toast;

import static android.R.attr.duration;

/**
 * @author ye
 * @date 2018/3/21
 * @desc 防止重复点击的toast 根据时间判断 2秒内不显示相同内容
 */
public class ToastUtils {

    private static String oldMsg;
    private static long time;

    public static void showToast(Context context, String msg) {
        if (!msg.equals(oldMsg)) { // 当显示的内容不一样时，即断定为不是同一个Toast
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            time = System.currentTimeMillis();
        } else {
            // 显示内容一样时，只有间隔时间大于2秒时才显示
            if (System.currentTimeMillis() - time > 2000) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            }
        }
        oldMsg = msg;
    }

}
