package com.dengxiao.customtextlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.left;

/**
 * Created by Dengxiao on 2016/12/8.
 */

public class CustomTextView extends RelativeLayout {

    //文字
    private String leftTvString;//左边文字
    private String rightTvString;//右边文字
    private String centerTvString;//中间文字
    private String leftTopTvString;//左上文字
    private String leftBottomTvString;//左下文字
    private int leftTvSize;//左边文字大小
    private int rightTvSize;//右边文字大小
    private int centerTvSize;//中间文字大小
    private int leftTopTvSize;//左上文字大小
    private int leftBottomTvSize;//左下文字大小
    private int leftTvMarginleft;//左边文字左边距
    private int rightTvMarginright;//右边文字右边距
    private int leftTopTvColor;//左上文字颜色
    private int leftBottomTvColor;//左下文字颜色
    private int leftTvColor;//左边文字颜色
    private int rightTvColor;//右边文字颜色
    private int centerTvColor;//中间文字颜色

    //图片
    private Drawable rightImgRes;//右边图片资源
    private Drawable leftImgRes;//左边图片资源
    private int leftImgWidht;//左边图片宽带
    private int leftImgHeight;//左边图片高度
    private int rightImgWidht;//右边图片宽带
    private int rightImgHeight;//右边图片高度
    private int leftImgMarginleft;//左边图片左边距
    private int rightImgMarginright;//右边图片右边距
    private int centerTVMarginleft;//中间文字左边距
    private int leftTopTvMarginTop;//左上文字上边距
    private int leftTopTvMarginleft;//左上文字左边就
    private int leftBottomTvMarginleft;//左下文字左边距
    private int leftButtomTvMarginBottom;//左下文字下边距
    //下划线margin
    private int bottomLineMargin;
    private boolean bottomLineShow;
    private int bottomLineHeight;
    private int bottomcolor;

    //一些默认属性
    private int defaultTvColor = 0xFF373737;//文字默认颜色
    private TextView leftTv, centerTv, rightTv,leftTopTv,leftBottomTv;
    private ImageView leftIV, rightIV;
    private View bottomView;
    private Context mContext;


    private OnTextViewClickListener OnTextViewClickListener;

    public CustomTextView setOnTextViewClickListener(OnTextViewClickListener listener) {
        this.OnTextViewClickListener = listener;
        return this;
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initAttr(attrs);
        initLayout();
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OnTextViewClickListener != null) {
                    OnTextViewClickListener.OnTextViewClick();
                }
            }
        });
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        leftTvString = typedArray.getString(R.styleable.CustomTextView_leftTvString);
        rightTvString = typedArray.getString(R.styleable.CustomTextView_rightTvString);
        centerTvString = typedArray.getString(R.styleable.CustomTextView_centerTvString);
        leftTopTvString = typedArray.getString(R.styleable.CustomTextView_leftTopTvString);
        leftBottomTvString = typedArray.getString(R.styleable.CustomTextView_leftBottomTvString);
        leftTvSize = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftTvSize, 16);
        rightTvSize = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_rightTvSize, 16);
        centerTvSize = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_centerTvSize, 16);
        leftImgRes = typedArray.getDrawable(R.styleable.CustomTextView_leftImg);
        rightImgRes = typedArray.getDrawable(R.styleable.CustomTextView_rightImg);
        leftTvColor = typedArray.getColor(R.styleable.CustomTextView_leftTvColor, defaultTvColor);
        rightTvColor = typedArray.getColor(R.styleable.CustomTextView_rightTvColor, defaultTvColor);
        centerTvColor = typedArray.getColor(R.styleable.CustomTextView_centerTvColor, defaultTvColor);
        leftImgWidht = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftImgWight, 0);
        leftImgHeight = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftImgHeight, 0);
        rightImgWidht = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_rightImgWidht, 0);
        rightImgHeight = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_rightImgHeight, 0);
        leftTvMarginleft = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftTvMarginleft, 0);
        rightTvMarginright = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_rightTvMarginright, 0);
        leftImgMarginleft = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftImgMarginleft, 0);
        rightImgMarginright = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_rightImgMarginright, 0);
        bottomLineMargin = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_bottomLineMargin, 0);
        bottomLineShow = typedArray.getBoolean(R.styleable.CustomTextView_bottomLineShow, false);
        bottomLineHeight = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_bottomLineHeight, 1);
        bottomcolor = typedArray.getColor(R.styleable.CustomTextView_bottomcolor, defaultTvColor);
        centerTVMarginleft = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_centerTVMarginleft, 0);
        leftTopTvMarginTop = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftTopTvMarginTop, 0);
        leftTopTvMarginleft = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftTopTvMarginleft, 0);
        leftBottomTvMarginleft = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftBottomTvMarginleft, 0);
        leftButtomTvMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftButtomTvMarginBottom, 0);
        leftTopTvSize = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftTopTvSize, 16);
        leftBottomTvSize = typedArray.getDimensionPixelOffset(R.styleable.CustomTextView_leftBottomTvSize, 16);
        leftTopTvColor = typedArray.getColor(R.styleable.CustomTextView_leftTopTvColor, defaultTvColor);
        leftBottomTvColor = typedArray.getColor(R.styleable.CustomTextView_leftBottomTvColor, defaultTvColor);

        typedArray.recycle();
    }

    private void initLayout() {
        //左边图片初始化
        if (leftImgRes != null) {
            initLeftImg();
        }
        //左边文字初始化
        if (!TextUtils.isEmpty(leftTvString)) {
            initLeftTv();
        }
        //中间文字初始化
        if (!TextUtils.isEmpty(centerTvString)) {
            initCenterTv();
        }
        //左上文字初始化
        if(!TextUtils.isEmpty(leftTopTvString)){
            initLeftTopTv();
        }
        //左下文字初始化
        if(!TextUtils.isEmpty(leftBottomTvString)){
            initLeftBottomTv();
        }

        //右边图片初始化
        if (rightImgRes != null) {
            initRightImg();
        }
        //右边的文字初始
        if (!TextUtils.isEmpty(rightTvString)) {
            initRightTv();
        }
        //下边线初始化
        if (bottomLineShow) {
            initBottomLine();
        }
    }

    //以下是设置字体和图片的属性，，为了适配最好不要动态设置与数字有关的属性
    //代码设置左边文字
    public CustomTextView setLeftTv(String tvStr, String tvColor) {
        leftTvString = TextUtils.isEmpty(tvStr) ? leftTvString : tvStr;
        leftTvColor = TextUtils.isEmpty(tvColor) ? leftTvColor : Color.parseColor(tvColor);
        if (leftTv == null) {
            initLeftTv();
        } else {
            leftTv.setText(leftTvString);
            leftTv.setTextColor(leftTvColor);
        }
        return this;
    }

    //代码设置右边文字
    public CustomTextView setRightTv(String tvStr, String tvColor) {
        rightTvString = TextUtils.isEmpty(tvStr) ? rightTvString : tvStr;
        rightTvColor = TextUtils.isEmpty(tvColor) ? rightTvColor : Color.parseColor(tvColor);
        if (rightTv == null) {
            initRightTv();
        } else {
            rightTv.setText(rightTvString);
            rightTv.setTextColor(rightTvColor);
        }

        return this;
    }

    //代码设置中间文字
    public CustomTextView setCenterTv(String tvStr, String tvColor) {
        centerTvString = TextUtils.isEmpty(tvStr) ? centerTvString : tvStr;
        centerTvColor = TextUtils.isEmpty(tvColor) ? centerTvColor : Color.parseColor(tvColor);
        if (centerTv == null) {
            initCenterTv();
        } else {
            centerTv.setText(centerTvString);
            centerTv.setTextColor(centerTvColor);
        }
        return this;
    }

    //代码设置左上文字颜色
    public CustomTextView setLeftTopTv(String tvStr,String tvColor){
        leftTopTvString=TextUtils.isEmpty(tvStr)?leftTopTvString:tvStr;
        leftTopTvColor=TextUtils.isEmpty(tvColor)?leftTopTvColor:Color.parseColor(tvColor);
        if(leftTopTv==null){
            initLeftTopTv();
        }else{
            leftTopTv.setTextColor(leftTopTvColor);
            leftTopTv.setText(leftTopTvString);
        }
        return this;
    }
    //代码设置左下文字颜色
    public CustomTextView setLeftBottomTv(String tvStr,String tvColor){
        leftBottomTvString=TextUtils.isEmpty(tvStr)?leftBottomTvString:tvStr;
        leftBottomTvColor=TextUtils.isEmpty(tvColor)?leftBottomTvColor:Color.parseColor(tvColor);
        if(leftBottomTv==null){
            initLeftBottomTv();
        }else{
            leftBottomTv.setTextColor(leftBottomTvColor);
            leftBottomTv.setText(leftBottomTvString);
        }
        return this;
    }


    //代码设置布局背景颜色
    public CustomTextView setCustomTvBackground(String strColor){
        CustomTextView.this.setBackgroundColor(Color.parseColor(strColor));
        return this;
    }


    //代码设置左边图片
    public CustomTextView setLeftImg(Drawable icRes) {
        leftImgRes = icRes;
        if (leftIV == null) {
            initLeftImg();
        } else {
            leftIV.setImageDrawable(leftImgRes);
        }
        return this;
    }

    //代码设置右边图片
    public CustomTextView setRightImg(Drawable icRes) {
        rightImgRes = icRes;
        if (rightIV == null) {
            initRightImg();
        } else {
            rightIV.setImageDrawable(rightImgRes);
        }
        return this;
    }

    //设置下划线
    public CustomTextView setBottomLine(String color) {
        bottomcolor = TextUtils.isEmpty(color) ? bottomcolor : Color.parseColor(color);
        if (bottomView == null) {
            initBottomLine();
        } else {
            bottomView.setBackgroundColor(bottomcolor);
        }
        return this;
    }

    private void initLeftImg() {
        leftIV = new ImageView(mContext);
        int width = leftImgWidht != 0 ? leftImgWidht : LayoutParams.WRAP_CONTENT;
        int height = leftImgHeight != 0 ? leftImgHeight : LayoutParams.WRAP_CONTENT;
        LayoutParams leftImgParams = new LayoutParams(width, height);
        leftImgParams.addRule(ALIGN_PARENT_LEFT, TRUE);
        leftImgParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        leftImgParams.setMargins(leftImgMarginleft, 0, 0, 0);
        leftIV.setScaleType(ImageView.ScaleType.FIT_XY);
        leftIV.setId(R.id.leftImg);
        leftIV.setLayoutParams(leftImgParams);
        leftIV.setImageDrawable(leftImgRes);
        leftIV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OnTextViewClickListener != null) {
                    OnTextViewClickListener.OnLeftImgClick();
                }
            }
        });
        addView(leftIV);
    }

    private void initLeftTv() {
        leftTv = new TextView(mContext);
        LayoutParams leftTvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftTvParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        leftTvParams.addRule(RelativeLayout.RIGHT_OF, R.id.leftImg);
        leftTvParams.setMargins(leftTvMarginleft, 0, 0, 0);
        leftTv.setLayoutParams(leftTvParams);
        leftTv.setTextColor(leftTvColor);
        leftTv.setId(R.id.leftTv);
        leftTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTvSize);
        leftTv.setText(leftTvString);
        addView(leftTv);
    }

    private void initCenterTv() {
        centerTv = new TextView(mContext);
        LayoutParams centerTvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        centerTvParams.addRule(centerTVMarginleft != 0 && !TextUtils.isEmpty(leftTvString) ? RelativeLayout.RIGHT_OF : RelativeLayout.CENTER_IN_PARENT, centerTVMarginleft != 0 && !TextUtils.isEmpty(leftTvString) ? R.id.leftTv : TRUE);
        centerTvParams.addRule(RelativeLayout.CENTER_VERTICAL);
        centerTvParams.setMargins(centerTVMarginleft, 0, 0, 0);
        centerTv.setLayoutParams(centerTvParams);
        centerTv.setTextColor(centerTvColor);
        centerTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, centerTvSize);
        centerTv.setText(centerTvString);
        addView(centerTv);
    }

    private void initLeftTopTv(){
        leftTopTv=new TextView(mContext);
        LayoutParams leftTopTvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftTopTvParams.addRule(RelativeLayout.RIGHT_OF, R.id.leftImg);
        leftTopTvParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,TRUE);
        leftTopTvParams.setMargins(leftTopTvMarginleft,leftTopTvMarginTop,0,0);
        leftTopTv.setLayoutParams(leftTopTvParams);
        leftTopTv.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftTopTvSize);
        leftTopTv.setTextColor(leftTopTvColor);
        leftTopTv.setText(leftTopTvString);
        addView(leftTopTv);
    }

    private void initLeftBottomTv(){
        leftBottomTv=new TextView(mContext);
        LayoutParams leftBottomTvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftBottomTvParams.addRule(RelativeLayout.RIGHT_OF, R.id.leftImg);
        leftBottomTvParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,TRUE);
        leftBottomTvParams.setMargins(leftBottomTvMarginleft,0,0,leftButtomTvMarginBottom);
        leftBottomTv.setLayoutParams(leftBottomTvParams);
        leftBottomTv.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftBottomTvSize);
        leftBottomTv.setTextColor(leftBottomTvColor);
        leftBottomTv.setText(leftBottomTvString);
        addView(leftBottomTv);
    }


    private void initRightImg() {
        rightIV = new ImageView(mContext);
        int width = rightImgWidht != 0 ? rightImgWidht : LayoutParams.WRAP_CONTENT;
        int height = rightImgHeight != 0 ? rightImgHeight : LayoutParams.WRAP_CONTENT;
        LayoutParams rightIVParams = new LayoutParams(width, height);
        rightIVParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        rightIVParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        rightIVParams.setMargins(0, 0, rightImgMarginright, 0);
        rightIV.setScaleType(ImageView.ScaleType.FIT_XY);
        rightIV.setId(R.id.rightImg);
        rightIV.setLayoutParams(rightIVParams);
        rightIV.setImageDrawable(rightImgRes);
        rightIV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OnTextViewClickListener != null) {
                    OnTextViewClickListener.OnRightImgClick();
                }
            }
        });
        addView(rightIV);

    }

    private void initRightTv() {
        rightTv = new TextView(mContext);
        LayoutParams rightTvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightTvParams.addRule(rightImgRes != null ? RelativeLayout.LEFT_OF : RelativeLayout.ALIGN_PARENT_RIGHT, rightImgRes != null ? R.id.rightImg : TRUE);
        rightTvParams.addRule(RelativeLayout.CENTER_VERTICAL);
        rightTvParams.setMargins(0, 0, rightTvMarginright, 0);
        rightTv.setLayoutParams(rightTvParams);
        rightTv.setTextColor(rightTvColor);
        rightTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTvSize);
        rightTv.setText(rightTvString);
        rightTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OnTextViewClickListener != null) {
                    OnTextViewClickListener.OnRightTvClick();
                }
            }
        });

        addView(rightTv);
    }

    private void initBottomLine() {
        bottomView = new View(mContext);
        LayoutParams bottomParams = new LayoutParams(LayoutParams.WRAP_CONTENT, bottomLineHeight);
        bottomParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, TRUE);
        bottomParams.setMargins(bottomLineMargin, 0, bottomLineMargin, 0);
        bottomView.setLayoutParams(bottomParams);
        bottomView.setBackgroundColor(bottomcolor);
        addView(bottomView);
    }

    //点击事件接口
    public static class OnTextViewClickListener {
        public void OnLeftImgClick() {
        }

        public void OnRightImgClick() {
        }

        public void OnTextViewClick() {
        }

        public void OnRightTvClick() {

        }

    }


}
