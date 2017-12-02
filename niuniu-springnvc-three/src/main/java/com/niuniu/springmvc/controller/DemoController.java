package com.niuniu.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.niuniu.springmvc.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huanglijun on 2017/12/2.
 */
@RequestMapping(value = "demo")
@Controller
public class DemoController {

    /**
     * http://localhost:8080/demo/test1?name=ppdai&number=1234
     * http://localhost:8080/demo/test1?name=ppdai
     * @param name
     * @param number
     * @return
     */
    @RequestMapping(value = "test1")
    public ModelAndView test1(@RequestParam(value = "name")String name,
                              @RequestParam(value = "number",required = false,defaultValue = "0")Long number){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "name=" + name + " number=" + number;
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * http://localhost:8080/demo/test2/shanghai?name=ppdai
     * http://localhost:8080/demo/test2/shanghai
     * @param param
     * @param name
     * @return
     */
    @RequestMapping(value = "test2/{param}")
    public ModelAndView test2(@PathVariable(value = "param")String param,
            @RequestParam(value = "name",required = false,defaultValue = "niuniu")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "param=" + param + " name=" + name;
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * http://localhost:8080/demo/test3/niuniu/18
     * @param param
     * @param number
     * @return
     */
    @RequestMapping(value = "test3/{param}/{number}")
    public ModelAndView test3(@PathVariable(value = "param")String param,
                              @PathVariable(value = "number")Long number){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "param=" + param + " number=" + number;
        mv.addObject("msg",data);
        return mv;
    }


    /**
     * http://localhost:8080/demo/test4/XXX/number?username=niuniu
     * @param name
     * @return
     */
    @RequestMapping(value = "test4/*/number")
    public ModelAndView test4(@RequestParam(value = "username")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "name=" + name;
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * 没有写RequestMethod 默认支持GET POST都可以
     * http://localhost:8080/demo/test5/XXX/number?name=niuniu
     * http://localhost:8080/demo/test5/XXX/YYY/number?name=niuniu
     * http://localhost:8080/demo/test5/XXX/YYY/ZZZ/number?name=niuniu
     * @param username
     * @return
     */
    @RequestMapping(value = "test5/**/number")
    public ModelAndView test5(@RequestParam(value = "name")String username){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "username=" + username;
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * 只能是post请求方式
     * http://localhost:8080/demo/test6?param=niuniu
     * 请求的body体{"key":"123"} (application/json 类型数据) 或者 56456 (text文本类型数据)
     * @param param
     * @return
     */
    @RequestMapping(value = "test6",method = RequestMethod.POST)
    public ModelAndView test6(@RequestParam(value = "param")String param,
                              @RequestBody String receive){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "param=" + param + " receive=" + receive;
        mv.addObject("msg",data);
        return mv;
    }


    /**
     * http://localhost:8080/demo/test7
     * (设置请求类型 可以让接口更安全)
     * @return
     */
    @RequestMapping(value = "test7",method = {RequestMethod.POST,RequestMethod.PUT})
    public ModelAndView test7(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "post或者put请求才能进来";
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * http://localhost:8080/demo/test8
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "test8")
    public ModelAndView test8(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        StringBuilder sb = new StringBuilder();
        sb.append("request:" + request).append("<br>");
        sb.append("response:" + response).append("<br>");
        sb.append("session:" + session);

        request.setAttribute("requestData","我在Request中");

        mv.addObject("msg",sb.toString());
        return mv;
    }

    /**
     * 获取浏览器的cookie值
     * http://localhost:8080/demo/test9
     * @param JSESSIONID
     * @return
     */
    @RequestMapping(value = "test9")
    public ModelAndView test9(@CookieValue(value = "JSESSIONID")String JSESSIONID){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "JSESSIONID = " + JSESSIONID;
        mv.addObject("msg",data);
        return mv;
    }

    /**
     * 请求参数直接映射到对象中
     * http://localhost:8080/demo/test10?id=1&username=niuniu&age=18
     * @param user
     * @return
     */
    @RequestMapping(value = "test10")
    public ModelAndView test10(User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "user = " + JSONObject.toJSONString(user);
        mv.addObject("msg",data);
        return mv;
    }


    /** (bug中)
     * http://localhost:8080/demo/test11
     * {"age":18,"id":1,"username":"niuniu"}
     * @param user2
     * @return
     */
    @RequestMapping(value = "test11", method = { RequestMethod.POST}, produces={"application/json"})
    public ModelAndView test11(@RequestBody User user2){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        String data = "user2 = " + JSONObject.toJSONString(user2);
        mv.addObject("msg",data);
        return mv;
    }


    /**
     * (bug中)
     * 页面form表单提交
     * @param name
     * @param age
     * @param income
     * @param isMarried
     * @param interests
     */
    @RequestMapping(value = "test12")
    @ResponseStatus(value = HttpStatus.OK)
    public void test11(String name,
                               Integer age,
                               Double income,
                               Boolean isMarried,
                               String[] interests){
        StringBuilder sb = new StringBuilder();
        sb.append("姓名:" + name).append("年龄:" + age).append("收入:" + income).append("是否结婚:" + isMarried).append("兴趣爱好:" + interests.toString());
    }


}
