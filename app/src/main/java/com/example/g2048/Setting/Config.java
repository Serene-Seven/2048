package com.example.g2048.Setting;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/3/1.
 */

public class Config extends Application {

    // SP对象
    public static SharedPreferences mSp;
    // 游戏目标分数
    public static int mGameGoal;
    // GameView行列数
    public static int mGameLines;
    // Item宽
    public static int mItemWidth;
    // 记录分数
    public static int SCORE = 0;
    // 记录最高记录
    //public static int mGameRecod;
    // Item高
    public static int mItemHeight;

    public static String SP_HIGH_SCORE = "SP_HIGHSCORE";
    public static String KEY_HIGH_SCORE = "KEY_HighScore";
    public static String KEY_GAME_LINES = "KEY_GAMELINES";
    public static String KEY_GAME_GOAL = "KEY_GameGoal";

    @Override
    public void onCreate() {
        super.onCreate();
        // 从缓存中读取游戏配置信息
        mSp = getSharedPreferences(SP_HIGH_SCORE, 0);
        mGameLines = mSp.getInt(KEY_GAME_LINES, 4);
        mGameGoal = mSp.getInt(KEY_GAME_GOAL, 2048);
        //mGameRecod = mSp.getInt(KEY_HIGH_SCORE, 0);
        mItemWidth = 0;
        mItemHeight = 0;
    }
}