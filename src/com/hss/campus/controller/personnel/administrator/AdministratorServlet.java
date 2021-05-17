package com.hss.campus.controller.personnel.administrator;

import com.hss.campus.controller.BaseServlet;
import com.hss.campus.entity.Administrator;
import com.hss.campus.service.AdministratorService;
import com.hss.campus.service.impl.AdministratorServiceImpl;
import com.hss.campus.util.OtherUtil;
import com.hss.campus.util.Response;
import com.hss.campus.util.ResultCode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//管理员登录
@WebServlet(urlPatterns = "/postAdministratorLogin")
public class AdministratorServlet extends BaseServlet {
    private AdministratorService administratorService=new AdministratorServiceImpl();

    @Override
    public Response operatingGet(HttpServletRequest request) {
        Response<Administrator> resp=new Response<>();
        Administrator administrator = getEntity(Administrator.class);
        Integer id=administrator.getId();
        String password=administrator.getPassword();
        if (id != null && password !=null){
            Administrator login=administratorService.login(administrator.getId(),administrator.getPassword());
            if (login!=null){
                login.setAvatar(OtherUtil.IP_ADDRESS +login.getAvatar());
                resp.setData(login);
                resp.setCode(ResultCode.SUCCESS.code());
                resp.setStatus(ResultCode.SUCCESS.status());
            }else {
                resp.setCode(ResultCode.USER_LOGIN_ERROR.code());
                resp.setStatus(ResultCode.USER_LOGIN_ERROR.status());
            }
        }else {
            resp.setCode(ResultCode.USER_LOGIN_ERROR.code());
            resp.setStatus(ResultCode.USER_LOGIN_ERROR.status());
        }
        return resp;
    }

    @Override
    public boolean isGet() {
        return false;
    }
}
