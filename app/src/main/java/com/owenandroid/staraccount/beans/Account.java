package com.owenandroid.staraccount.beans;

import androidx.annotation.NonNull;

import org.litepal.crud.DataSupport;

/**
 * Created by 啸宇 on 2016/12/4.
 */

public class Account extends DataSupport implements Comparable{
    public static final int ACCOUNT_TYPE_OUT = 1;//支出
    public static final int ACCOUNT_TYPE_IN = 2;//收入
    private int type;//种类（支出或收入）
    private int nameIndex;//账目名称（学习等等）
    private double money;//钱数
    private String note;//备注
    private String  date;//日期
    private int bookId;//该账目所在的账本的id

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Account account = (Account) o;
        return account.date.compareTo(date);
    }

}
