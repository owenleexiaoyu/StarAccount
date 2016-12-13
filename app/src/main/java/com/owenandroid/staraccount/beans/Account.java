package com.owenandroid.staraccount.beans;

import java.util.Date;

/**
 * Created by 啸宇 on 2016/12/4.
 */

public class Account {
    private String type;
    private double money;
    private String note;
    private Date  date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
