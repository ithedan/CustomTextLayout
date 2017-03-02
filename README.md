###最近项目要开发一个新版本，发现项目中许多布局大致都相同改动不大，并且布局中代码量非常之多不好阅读，针对项目相关内容进行了封装。
###实现思路：
####通过继承RelativeLayout实现动态添加所需要的控件，TextView  ImageView  View 一共封装了8个控件 leftImg reightImg leftTv rightTv centerTv leftTopTv leftBottomTv bottomLine 根据需要动态添加AddView(View) 通过LayoutParams.addRule()设置控件的位置，LayoutParams.setMargins()设置大小进行所需控件的控制实现以下效果：

![customtextlayout.png](http://upload-images.jianshu.io/upload_images/3523210-f6b36142aba97e0e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
####下面看看自定义控件中几个主要方法
####添加ImageView(通过判断布局是是否设置了leftImg属性进行添加图片，增加图片的点击回调事件)
````
  //左边图片初始化
        if (leftImgRes != null) {
            initLeftImg();
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
````
####添加TextView
````
   //左边文字初始化
        if (!TextUtils.isEmpty(leftTvString)) {
            initLeftTv();
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
````
####代码中设置TextView的公共方法
````
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
````
####只需搞懂这三个方法，你也可以根据自己的项目需求定义自己需要的组合控件
####使用方法
#####xml(根据自己需要的属性自定义)
````
            <com.dengxiao.customtextlayout.CustomTextView
                android:layout_width="match_parent"
                android:layout_height="55dp"
                android:background="#ffffff"
                app:bottomLineHeight="1dp"
                app:bottomLineShow="true"
                app:bottomcolor="#eeeeee"
                app:centerTvColor="#000"
                app:centerTvSize="18sp"
                app:centerTvString="标题"
                app:leftImg="@drawable/btn_back_pressed"
                app:leftImgHeight="40dp"
                app:leftImgMarginleft="5dp"
                app:leftImgWight="40dp"
                app:leftTvColor="@color/colorAccent"
                app:leftTvMarginleft="5dp"
                app:leftTvSize="18sp"
                app:leftTvString="左边"
                app:rightImg="@drawable/btn_forward_pressed"
                app:rightImgHeight="50dp"
                app:rightImgMarginright="10dp"
                app:rightImgWidht="50dp"
                app:rightTvColor="#52adff"
                app:rightTvMarginright="10dp"
                app:rightTvSize="19sp"
                app:rightTvString="右边" />
````
####activity.java
````
  customTextView1.setLeftImg(getResources().getDrawable(R.drawable.ic_search))
                .setRightImg(getResources().getDrawable(R.drawable.icon_portrait))
                .setLeftTv("代码添加","#c95fdc")
                .setRightTv("代码添加","#4be1c3")
                .setCenterTv("代码",null)
                .setLeftTopTv("上",null)
                .setLeftBottomTv("下",null)
                .setBottomLine("#1587e7")
                .setCustomTvBackground("#4dacff");

        customTextView1.setOnTextViewClickListener(new CustomTextView.OnTextViewClickListener(){
            @Override
            public void OnLeftImgClick() {
                Toast.makeText(MainActivity.this,"左边图片",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnRightImgClick() {
                Toast.makeText(MainActivity.this,"右边图片",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnTextViewClick() {
                Toast.makeText(MainActivity.this,"布局",Toast.LENGTH_SHORT).show();
            }
        });
````
####完整代码就不贴了，，如果需要点击https://github.com/ithedan/CustomTextLayout
####如有什么问题，敬请提出，十分感谢！希望越来越好，谢谢！如果喜欢，还请点击start，喜欢支持一下了，谢谢O(∩_∩)O~
