package com.owenandroid.staraccount.datas;

import com.owenandroid.staraccount.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 啸宇 on 2016/12/5.
 */

public class TypeData {
    public static final String MAPKEY_ICON = "icon";
    public static final String MAPKEY_BGCOLOR = "bgcolor";
    public static final String MAPKEY_NAME = "name";
    public static final int out_iconId[] = {R.mipmap.common,R.mipmap.dinner,R.mipmap.traffic,R.mipmap.clothes,R.mipmap.lifestuff,
                                            R.mipmap.fun,R.mipmap.snack,R.mipmap.phonecost,R.mipmap.study,R.mipmap.doctor,
                                            R.mipmap.tour,R.mipmap.onlineshop};
    public static final int out_colorId[] = {R.color.colorCommon,R.color.colorDinner,R.color.colorTraffic,R.color.colorClothes,R.color.colorLifestuff,
                                            R.color.colorFun,R.color.colorSnack,R.color.colorPhonecast,R.color.colorStudy,R.color.colorDoctor,
                                            R.color.colorTour,R.color.colorOnlineshop};
    public static  final String out_typename[] = {"一般","用餐","交通","服饰","日用品",
                                                "娱乐","零食","话费","学习","医疗",
                                                "旅游","网购"};
    public static final int in_iconId[] = {R.mipmap.ordinary,R.mipmap.pay,R.mipmap.bonus,R.mipmap.halfjob,R.mipmap.redbag,
                                            R.mipmap.invent};
    public static final int in_colorId[] = {R.color.colorOdinary,R.color.colorPay,R.color.colorBonus,R.color.colorHalfjob,R.color.colorRedbag,
                                            R.color.colorInvent};
    public static  final String in_typename[] = {"一般","工资","奖金","兼职","红包",
                                                "投资"};
    public static List<Map<String,Object>> getOutTypeData(){
        List<Map<String, Object>> dataList = new ArrayList<>();
        for(int i = 0;i < out_iconId.length;i++){
            Map<String, Object> map = new HashMap<>();
            map.put(MAPKEY_ICON,out_iconId[i]);
            map.put(MAPKEY_BGCOLOR,out_colorId[i]);
            map.put(MAPKEY_NAME,out_typename[i]);
            dataList.add(map);
        }
        return dataList;
    }
    public static List<Map<String,Object>> getInTypeData(){
        List<Map<String, Object>> dataList = new ArrayList<>();
        for(int i = 0;i < in_iconId.length;i++){
            Map<String, Object> map = new HashMap<>();
            map.put(MAPKEY_ICON,in_iconId[i]);
            map.put(MAPKEY_BGCOLOR,in_colorId[i]);
            map.put(MAPKEY_NAME,in_typename[i]);
            dataList.add(map);
        }
        return dataList;
    }
}
