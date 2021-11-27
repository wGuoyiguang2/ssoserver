package com.sso.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.majiaxueyuan.sso.core.constans.Result;
import com.majiaxueyuan.sso.core.helper.TokenLoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:14
 **/

@RestController
@RequestMapping("/login")
public class LoginController {


    // org.springframework.core.env.Environment
    @Autowired
    Environment environment;



    /**
     * @program:
     * @description: 只需要做个登录，登录成功授权 token
     * @author: guoyiguang
     * @create: 2021-03-07 13:14
     **/
    @RequestMapping("/login")
    public String login(String username, String password) {

        // 校验用户名和密码


        // 颁发token
        if (username.equals("admin") && password.equals("123456")) {
            // 表示登录成功(表示数据库密码验证成功)
            JSONObject json = new JSONObject();
            json.put("username", username);
            json.put("role", new ArrayList<String>(Arrays.asList("admin", "normal")));
            // 设置过期时间
            // 加 天，小时，分钟，秒都有
            json.put("expireTime", LocalDateTime.now().plusMinutes(5L));


            // 生成Token时需要传递四个参数，用户唯一ID，用户名，其他信息（建议JSON，每次请求原样携带），加密盐 生成成功过后，返回Result，判断code=200时，data就是Token
            Result loginSuccess = TokenLoginHelper.loginSuccess(1L, username, json.toJSONString(), "token-salt");
            if (loginSuccess.getCode().equals(200)) {
                String token = loginSuccess.getData().toString();
                System.out.println(token);
                return "token:" + token;
            }
            return "登录失败";
        }
        return "failed";
    }






    @RequestMapping("/getBoyList3")
    public String  getBoyList3(){
        Map<String,String> para = new HashMap<String,String>();
        para.put("defaultProfiles",environment.getDefaultProfiles().toString()) ;
        para.put("env",environment.getProperty("server.port"));
        return JSON.toJSONString(para);
    }












}
