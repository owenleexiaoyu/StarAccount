package com.owenandroid.staraccount.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.owenandroid.staraccount.R;
import com.owenandroid.staraccount.datas.TypeData;
import com.owenandroid.staraccount.widgets.CircleImageView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 啸宇 on 2016/12/3.
 */

public class TakeAccountActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int btnId[] = {R.id.ed_btn0, R.id.ed_btn1, R.id.ed_btn2, R.id.ed_btn3,
            R.id.ed_btn4, R.id.ed_btn5, R.id.ed_btn6, R.id.ed_btn7,
            R.id.ed_btn8, R.id.ed_btn9, R.id.ed_btndot, R.id.ed_btnc, R.id.ed_btncut, R.id.ed_btnok};
    private Button[] edBtns;
    private TextView tvMoney;
    private String money;
    private RadioButton radioIn, radioOut;
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private List<View> viewList;
    private GridView inGridView, outGridView;
    private SimpleAdapter inAdapter, outAdapter;
    private LinearLayout topbar;
    private ImageView typeicon;
    private CircleImageView typecolor;
    private TextView typename,tvNote;
    private LinearLayout writenote;
    private Button btn_choose_date;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeaccountlayout);
        initView();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initView() {
        edBtns = new Button[btnId.length];
        btn_choose_date = (Button) findViewById(R.id.choose_date);
        btn_choose_date.setOnClickListener(this);
        tvNote = (TextView) findViewById(R.id.tv_note);
        tvMoney = (TextView) findViewById(R.id.ed_tv_money);
        radioIn = (RadioButton) findViewById(R.id.ed_radio_in);
        radioOut = (RadioButton) findViewById(R.id.ed_radio_out);
        radioIn.setOnCheckedChangeListener(this);
        radioOut.setOnCheckedChangeListener(this);
        writenote = (LinearLayout) findViewById(R.id.writenote);
        writenote.setOnClickListener(this);
        for (int i = 0; i < edBtns.length; i++) {
            edBtns[i] = (Button) findViewById(btnId[i]);
            edBtns[i].setOnClickListener(this);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewList = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        View inView = inflater.inflate(R.layout.view_item, null);
        View outView = inflater.inflate(R.layout.view_item, null);
        inGridView = (GridView) inView.findViewById(R.id.type_grid);
        outGridView = (GridView) outView.findViewById(R.id.type_grid);
        inAdapter = new SimpleAdapter(this, TypeData.getInTypeData(), R.layout.type_item,
                new String[]{TypeData.MAPKEY_ICON, TypeData.MAPKEY_BGCOLOR, TypeData.MAPKEY_NAME},
                new int[]{R.id.type_item_img, R.id.type_item_colorbgimg, R.id.type_item_text});
        outAdapter = new SimpleAdapter(this, TypeData.getOutTypeData(), R.layout.type_item,
                new String[]{TypeData.MAPKEY_ICON, TypeData.MAPKEY_BGCOLOR, TypeData.MAPKEY_NAME},
                new int[]{R.id.type_item_img, R.id.type_item_colorbgimg, R.id.type_item_text});
        inGridView.setAdapter(inAdapter);
        outGridView.setAdapter(outAdapter);
        topbar = (LinearLayout) findViewById(R.id.topbar);
        typecolor = (CircleImageView) findViewById(R.id.ed_type_bgcolor);
        typeicon = (ImageView) findViewById(R.id.ed_type_icon);
        typename = (TextView) findViewById(R.id.ed_type_name);
        inGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                topbar.setBackgroundResource(TypeData.in_colorId[position]);
                typeicon.setImageResource(TypeData.in_iconId[position]);
                typecolor.setImageResource(TypeData.in_colorId[position]);
                typename.setText(TypeData.in_typename[position]);
            }
        });
        outGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                topbar.setBackgroundResource(TypeData.out_colorId[position]);
                typeicon.setImageResource(TypeData.out_iconId[position]);
                typecolor.setImageResource(TypeData.out_colorId[position]);
                typename.setText(TypeData.out_typename[position]);
            }
        });
        viewList.add(inView);
        viewList.add(outView);
        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    radioIn.setChecked(true);
                    radioOut.setChecked(false);
                    topbar.setBackgroundResource(TypeData.in_colorId[0]);
                    typeicon.setImageResource(TypeData.in_iconId[0]);
                    typecolor.setImageResource(TypeData.in_colorId[0]);
                    typename.setText(TypeData.in_typename[0]);
                } else if (position == 1) {
                    radioIn.setChecked(false);
                    radioOut.setChecked(true);
                    topbar.setBackgroundResource(TypeData.out_colorId[0]);
                    typeicon.setImageResource(TypeData.out_iconId[0]);
                    typecolor.setImageResource(TypeData.out_colorId[0]);
                    typename.setText(TypeData.out_typename[0]);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_btn0:
            case R.id.ed_btn1:
            case R.id.ed_btn2:
            case R.id.ed_btn3:
            case R.id.ed_btn4:
            case R.id.ed_btn5:
            case R.id.ed_btn6:
            case R.id.ed_btn7:
            case R.id.ed_btn8:
            case R.id.ed_btn9:
                money = tvMoney.getText().toString();
                Button btn = (Button) v;
                money += btn.getText().toString();
                tvMoney.setText(money);
                break;
            case R.id.ed_btndot:
                money = tvMoney.getText().toString();
                btn = (Button) v;
                if (money == null || "".equals(money))
                    tvMoney.setText("0.");
                else if (money.contains("."))
                    return;
                else {
                    money += btn.getText().toString();
                    tvMoney.setText(money);
                }
                break;
            case R.id.ed_btnc:
                tvMoney.setText("");
                break;
            case R.id.ed_btncut:
                money = tvMoney.getText().toString();
                if (money == null || "".equals(money))
                    return;
                else {
                    String str = money.substring(0, money.length() - 1);
                    tvMoney.setText(str);
                }
                break;
            case R.id.ed_btnok:
                money = tvMoney.getText().toString();
                if (money == null || "".equals(money))
                    Toast.makeText(TakeAccountActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(TakeAccountActivity.this, radioIn.isChecked() ? "收入>" + typename.getText().toString() + ":￥" + tvMoney.getText().toString() :
                            "支出>" + typename.getText().toString() + ":￥" + tvMoney.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.writenote:
                //编写收入和支出的备注
                AlertDialog.Builder builder = new AlertDialog.Builder(TakeAccountActivity.this);
                LayoutInflater inflater = LayoutInflater.from(TakeAccountActivity.this);
                View noteView = inflater.inflate(R.layout.notelayout, null);
                final EditText note = (EditText) noteView.findViewById(R.id.note_ed);
                Button btn_cancel = (Button) noteView.findViewById(R.id.note_btn_cancel);
                Button btn_done = (Button) noteView.findViewById(R.id.note_btn_done);
                builder.setView(noteView);
                final AlertDialog dialog = builder.create();
                dialog.show();
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btn_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String notes = note.getText().toString();
                        if(notes == null || "".equals(notes)){
                            Toast.makeText(TakeAccountActivity.this,"你还没写备注哦",Toast.LENGTH_SHORT).show();
                        }else {
                            tvNote.setText(notes);
                            dialog.dismiss();
                        }
                    }
                });
                break;
            case R.id.choose_date:
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(TakeAccountActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                },2016,11,9);
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.ed_radio_in:
                if (isChecked) {
                    //切换到收入界面
                    viewPager.setCurrentItem(0);
                    radioIn.setChecked(true);
                    radioOut.setChecked(false);
                    topbar.setBackgroundResource(TypeData.in_colorId[0]);
                    typeicon.setImageResource(TypeData.in_iconId[0]);
                    typecolor.setImageResource(TypeData.in_colorId[0]);
                    typename.setText(TypeData.in_typename[0]);
                }
                break;
            case R.id.ed_radio_out:
                if (isChecked) {
                    //切换到支出界面
                    viewPager.setCurrentItem(viewList.size() - 1);
                    radioIn.setChecked(false);
                    radioOut.setChecked(true);
                    topbar.setBackgroundResource(TypeData.out_colorId[0]);
                    typeicon.setImageResource(TypeData.out_iconId[0]);
                    typecolor.setImageResource(TypeData.out_colorId[0]);
                    typename.setText(TypeData.out_typename[0]);
                }
                break;
        }
    }

    public void back(View view) {
        finish();
    }
    public void choooseDate(View v){

    }
}
