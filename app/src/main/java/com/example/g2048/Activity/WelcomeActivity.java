package com.example.g2048.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.g2048.Support.ImageViewRound;
import com.example.g2048.Support.JumpingSpan;
import com.example.g2048.R;

public class WelcomeActivity extends AppCompatActivity {

    private ImageViewRound imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome);
        initViews();
        handler.sendEmptyMessageDelayed(0,2000);
    }

    /**
     * 初始化Views
     */
    private void initViews(){
        imageView =(ImageViewRound)findViewById(R.id.imageView);
        imageView.setType(ImageViewRound.TYPE_ROUND);
        imageView.setRoundRadius(80);//矩形凹行大小
        // 从第一个字符串到最后一个字符串波浪式循环跳动
        final TextView textView = (TextView) findViewById(R.id.textView);
        SpannableStringBuilder sbb = new SpannableStringBuilder(textView.getText());
        //buildSingleSpan(sbb);
        buildWavingSpans(sbb, textView);
        textView.setText(sbb);
    }

    private JumpingSpan[] buildWavingSpans(SpannableStringBuilder sbb, TextView tv) {
        JumpingSpan[] spans;
        int loopDuration = 2100;
        int startPos = 0;//textview字体的开始位置
        int endPos = tv.getText().length();//结束位置
        int waveCharDelay = loopDuration / (3 * (endPos - startPos));//每个字体延迟的时间
        spans = new JumpingSpan[endPos - startPos];
        for (int pos = startPos; pos < endPos; pos++) {//设置每个字体的jumpingspan
            JumpingSpan jumpingBean =
                    new JumpingSpan(tv, loopDuration, pos - startPos, waveCharDelay, 0.65f);
            sbb.setSpan(jumpingBean, pos, pos + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spans[pos - startPos] = jumpingBean;
        }
        return spans;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            getHome();
            super.handleMessage(msg);
        }
    };

    public void getHome(){
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
