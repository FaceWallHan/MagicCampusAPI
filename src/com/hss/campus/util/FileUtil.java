package com.hss.campus.util;

import com.hss.campus.entity.ImageResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

public class FileUtil {

    public static ImageResponse receiveData(HttpServletRequest request,String path){
        ImageResponse imageHeader=new ImageResponse();
        if (ServletFileUpload.isMultipartContent(request)){

            //创建FileItemFactory工厂实现类
            FileItemFactory factory=new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFiLeUpLoad类
            ServletFileUpload sfu = new ServletFileUpload(factory);
            sfu.setSizeMax(1024*1024*10);
            //解析上传的数据，得到每一个表单项FileItem
            try {
                List<FileItem> list = sfu.parseRequest(request);
                //循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem item : list) {
                    if (!item.isFormField()){
                        //普通表单项
//                        if (!"id".equals(item.getFieldName())){
//                            break;
//                        }
//                        imageHeader.setId(Integer.parseInt(item.getString("UTF-8")));
//                    }else {
                        //getName获取文件名
                        //扩展名
                        String suffix = item.getName().substring(item.getName().lastIndexOf("."));
                        //新文件名称 :用户ID + 时间毫秒值  + 扩展名
                        String newFileName =  "" +new Date().getTime() + suffix;
                        imageHeader.setFileName(newFileName);
                        item.write(new File("C:\\apache-tomcat-9.0.45-windows-x64\\apache-tomcat-9.0.45\\webapps\\image\\"+path+newFileName));
                       // item.write(new File("D:\\Study\\Campus\\Image\\"+path+newFileName));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imageHeader;
    }
}
