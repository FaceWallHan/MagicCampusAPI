package com.hss.campus.util;

import com.hss.campus.entity.Administrator;
import com.hss.campus.entity.Announcement;
import com.hss.campus.service.AdministratorService;
import com.hss.campus.service.impl.AdministratorServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

public class OtherUtil {
    public static final String IP_ADDRESS = "http://39.101.165.25:8080/";
    //订单状态
    public static final String[] REPAIR_STATUS=new String[]{"已报修","已受理","已派工","已完工","已评价","维修中"};
    //维修进度
    public static final String[] REPAIR_SCHEDULE=new String[]{"受理","派工","签到","已完工","已评价"};
    public static final String[] REPAIR_WORKER_STATUS=new String[]{"维修中","等待中"};
    public static String cutImageUrl(String url) {
        String response = "";
        String[] split = url.split("/");
        if (split.length == 6) {
            response = split[3] + "/" + split[4] + "/" + split[5];
        }
        return response;
    }

    public static List<Announcement> updateImageUrl(List<Announcement> list) {
        for (int i = 0; i < list.size(); i++) {
            Announcement announcement = list.get(i);
            announcement.setImage((OtherUtil.IP_ADDRESS + announcement.getImage()));
            list.set(i, announcement);
        }
        return list;
    }
    private static int existStatusArray(String status){
        int index=-1;
        List<String> list =  Arrays.asList(REPAIR_STATUS);
        if (list.contains(status)){
            index=list.indexOf(status);
        }
        return index;
    }
    public static boolean  existWorkerArray(String status){
        List<String> list =  Arrays.asList(REPAIR_WORKER_STATUS);
        return list.contains(status);
    }

    public static String getNowTime(String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format, Locale.CHINA);
        Date date=new Date(System.currentTimeMillis());
        return sdf.format(date);
    }
}
