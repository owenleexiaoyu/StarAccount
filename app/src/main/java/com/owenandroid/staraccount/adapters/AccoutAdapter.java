package com.owenandroid.staraccount.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.owenandroid.staraccount.R;
import com.owenandroid.staraccount.beans.Account;
import com.owenandroid.staraccount.datas.TypeData;
import com.owenandroid.staraccount.widgets.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */

public class AccoutAdapter extends BaseAdapter {
    private List<Account> mDataList;
    private Context mContext;
    public AccoutAdapter(List<Account> dataList,Context context){
        this.mDataList = dataList;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.account_list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.item_time);
            viewHolder.tvInNameMoney = (TextView) convertView.findViewById(R.id.item_in_name_money);
            viewHolder.tvOutNameMoney = (TextView) convertView.findViewById(R.id.item_out_name_money);
            viewHolder.tvInNote = (TextView) convertView.findViewById(R.id.item_in_note);
            viewHolder.tvOutNote = (TextView) convertView.findViewById(R.id.item_out_note);
            viewHolder.ciIcong = (CircleImageView) convertView.findViewById(R.id.item_icon_bg);
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.item_icon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Account account = mDataList.get(position);

        viewHolder.tvTime.setText(account.getDate());
        if(position > 0 && account.getDate().equals(mDataList.get(position -1).getDate())){
            viewHolder.tvTime.setVisibility(View.GONE);
        }
        if (account.getType() == Account.ACCOUNT_TYPE_IN){
            viewHolder.tvInNameMoney.setText(TypeData.in_typename[account.getNameIndex()]
                    +" "+ account.getMoney()+"元");
            viewHolder.tvOutNameMoney.setText("");
            viewHolder.tvInNote.setText(account.getNote());
            if(TextUtils.isEmpty(account.getNote())){
                viewHolder.tvInNote.setVisibility(View.GONE);
            }
            viewHolder.tvOutNote.setText("");
            viewHolder.ivIcon.setImageResource(TypeData.in_iconId[account.getNameIndex()]);
            viewHolder.ciIcong.setImageResource(TypeData.in_colorId[account.getNameIndex()]);
        }else{
            viewHolder.tvOutNameMoney.setText(TypeData.out_typename[account.getNameIndex()]
                    +" "+ account.getMoney()+"元");
            viewHolder.tvInNameMoney.setText("");
            viewHolder.tvOutNote.setText(account.getNote());
            if(TextUtils.isEmpty(account.getNote())){
                viewHolder.tvOutNote.setVisibility(View.GONE);
            }
            viewHolder.tvInNote.setText("");
            viewHolder.ivIcon.setImageResource(TypeData.out_iconId[account.getNameIndex()]);
            viewHolder.ciIcong.setImageResource(TypeData.out_colorId[account.getNameIndex()]);
        }
        return convertView;
    }
    class ViewHolder{
        public TextView tvTime;
        public TextView tvInNameMoney;
        public TextView tvOutNameMoney;
        public TextView tvInNote;
        public TextView tvOutNote;
        public CircleImageView ciIcong;
        public ImageView ivIcon;
    }

}
