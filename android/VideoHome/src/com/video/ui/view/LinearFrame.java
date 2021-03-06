package com.video.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.video.ui.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinearFrame extends FrameLayout {

	Context mContext;
	int[] rowOffset         = new int[2];
	static  int DIVIDE_SIZE = 6;
	List<WeakReference<View>> mViewList = new ArrayList<WeakReference<View>>();
	HashMap<View, WeakReference<MirrorItemView>> mViewMirrorMap = new HashMap<View, WeakReference<MirrorItemView>>();
    private static int ITEM_V_WIDTH  = -1;

	public LinearFrame(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public LinearFrame(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}


	private void init(){
        if(ITEM_V_WIDTH == -1){
            DIVIDE_SIZE        = getResources().getDimensionPixelSize(R.dimen.ITEM_DIVIDE_SIZE);
        }
        setClipChildren(false);
        setClipToPadding(false);
	}

	public View getItemView(int index){
		if(index>=mViewList.size()) return null;
		return mViewList.get(index).get();
	}

    public void clearItems(){
        removeAllViews();
        rowOffset[1]=rowOffset[0]=0;
        mViewList.clear();
        mViewMirrorMap.clear();
    }

    public View addItemView(View child, int width, int height, int leftPadding, int midPadding){
        child.setFocusable(true);
        mViewList.add(new WeakReference<View>(child));
        View result = child;

        LayoutParams flp = new LayoutParams(width, height);
        flp.leftMargin = rowOffset[0] + leftPadding;
        flp.topMargin   = getPaddingTop();
        flp.rightMargin = getPaddingRight();
        addView(child,flp);

        rowOffset[0]+=width + midPadding;
        return result;
    }

    public View addItemView(View child, int width, int height, int padding){
        return addItemView(child, width, height, padding, padding);
	}

    public View addItemViewPort(View child, int width, int height, int padding){
        child.setFocusable(true);
        mViewList.add(new WeakReference<View>(child));
        View result = child;

        LayoutParams flp = new LayoutParams(width, height);
        flp.leftMargin  = getPaddingLeft();
        flp.topMargin   = getPaddingTop() + rowOffset[0] + padding;
        flp.rightMargin = getPaddingRight();
        addView(child,flp);

        rowOffset[0]+=height + padding;
        return result;
    }
}
