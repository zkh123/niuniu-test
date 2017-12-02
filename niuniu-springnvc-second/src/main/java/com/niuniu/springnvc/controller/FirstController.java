package com.niuniu.springnvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanglijun on 2017/12/2.
 */

@Controller  //标记其为一个handler对象
public class FirstController {

    /**
     * http://localhost:8080/abc
     * @return
     */
    @RequestMapping("abc")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","默认 + 注解形式配置");
        return mv;
    }
}
