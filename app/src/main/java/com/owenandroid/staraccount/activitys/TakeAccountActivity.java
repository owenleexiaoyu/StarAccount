package com.owenandroid.staraccount.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.owenandroid.staraccount.R;

/**
 * Created by 啸宇 on 2016/12/3.
 */

public class TakeAccountActivity extends Activity implements View.OnClickListener{
    private int btnId[] = {R.id.ed_btn0,R.id.ed_btn1,R.id.ed_btn2,R.id.ed_btn3,
                            R.id.ed_btn4,R.id.ed_btn5,R.id.ed_btn6,R.id.ed_btn7,
                            R.id.ed_btn8,R.id.ed_btn9,R.id.ed_btnc,R.id.ed_btnadd,R.id.ed_btncut,R.id.ed_btnok};
    private Button[] edBtns;
    private TextView tvMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeaccountlayout);
        initView();
    }

    private void initView() {
        edBtns = new Button[btnId.length];
        tvMoney = (TextView) findViewById(R.id.ed_tv_money);
        for(int i = 0;i<edBtns.length;i++) {
            edBtns[i] = (Button) findViewById(btnId[i]);
            edBtns[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_btn1:
            case R.id.ed_btn2:
            case R.id.ed_btn3:
            case R.id.ed_btn4:
            case R.id.ed_btn5:
            case R.id.ed_btn6:
            case R.id.ed_btn7:
            case R.id.ed_btn8:
            case R.id.ed_btn9:

                break;
            case R.id.ed_btn0:
                break;
            case R.id.ed_btndot:
                break;
            case R.id.ed_btnc:
                break;
            case R.id.ed_btnadd:
                break;
            case R.id.ed_btncut:
                break;
            case R.id.ed_btnok:
                break;

        }
    }
}
