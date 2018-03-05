package com.example.g2048.Component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.g2048.Setting.Config;

/**
 * Created by Administrator on 2018/3/1.
 */

public class GameItem extends FrameLayout {
    private int mCardShowNum;
    private LayoutParams mParams;
    private TextView mTvNum;

    /**
     * 设置要显示的数字
     * @param context
     * @param cardShowNum
     */
    public GameItem(Context context, int cardShowNum) {
        super(context);
        this.mCardShowNum = cardShowNum;
        // 初始化Item
        initCardItem();
    }

    /**
     * 初始化Item，根据数字设置相应的颜色
     */
    private void initCardItem() {
        // 设置面板背景色，是由Frame拼起来的
        setBackgroundColor(Color.GRAY);
        // 新建一个TextView并设置好数字颜色
        mTvNum = new TextView(getContext());
        setNum(mCardShowNum);
        // 修改5*5时，字体太大
        int gameLines = Config.mSp.getInt(Config.KEY_GAME_LINES, 4);
        if (gameLines == 4) {
            mTvNum.setTextSize(35);
        } else if (gameLines == 5) {
            mTvNum.setTextSize(25);
        } else {
            mTvNum.setTextSize(20);
        }
        // 字体设置为粗体
        TextPaint tp = mTvNum.getPaint();
        tp.setFakeBoldText(true);
        // 设置为居中显示
        mTvNum.setGravity(Gravity.CENTER);
        // 设置边距
        mParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mParams.setMargins(5, 5, 5, 5);
        addView(mTvNum, mParams);
    }

    public View getItemView() {
        return mTvNum;
    }

    public int getNum() {
        return mCardShowNum;
    }

    public void setNum(int num) {
        this.mCardShowNum = num;
        if (num == 0) {
            mTvNum.setText("");
        } else {
            mTvNum.setText("" + num);
        }
        // 设置这一小块文字的背景颜色
        switch (num) {
            case 0:
                mTvNum.setBackgroundColor(0x00000000);
                break;
            case 2:
                mTvNum.setBackgroundColor(0xffeee5db);
                break;
            case 4:
                mTvNum.setBackgroundColor(0xffeee0ca);
                break;
            case 8:
                mTvNum.setBackgroundColor(0xfff2c17a);
                break;
            case 16:
                mTvNum.setBackgroundColor(0xfff59667);
                break;
            case 32:
                mTvNum.setBackgroundColor(0xfff68c6f);
                break;
            case 64:
                mTvNum.setBackgroundColor(0xfff66e3c);
                break;
            case 128:
                mTvNum.setBackgroundColor(0xffedcf74);
                break;
            case 256:
                mTvNum.setBackgroundColor(0xffedcc64);
                break;
            case 512:
                mTvNum.setBackgroundColor(0xffedc854);
                break;
            case 1024:
                mTvNum.setBackgroundColor(0xffedc54f);
                break;
            case 2048:
                mTvNum.setBackgroundColor(0xffedc32e);
                break;
            default:
                mTvNum.setBackgroundColor(0xff3c4a34);
                break;
        }
    }
}
