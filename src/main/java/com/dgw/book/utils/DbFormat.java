package com.dgw.book.utils;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DbFormat {

    public static void  format(HttpServletResponse resp, Object object){
        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        try {
            resp.getWriter().println(JSONObject.toJSONString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
