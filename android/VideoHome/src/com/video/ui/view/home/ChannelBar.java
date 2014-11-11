package com.video.ui.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.video.ui.R;

/**
 * Created by liuhuadong on 11/11/14.
 */
public class ChannelBar extends RelativeLayout {
    public ChannelBar(Context context) {
        super(context, null, 0);
    }
    public ChannelBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ChannelBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.channel_bar, this);
        addView(view);
    }
}