package com.niuniu.springnvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanglijun on 2017/12/2.
 */
@RequestMapping("second")
@Controller
public class SecondController {

    /**
     * http://localhost:8080/second/test
     * @return
     */
    @RequestMapping(value = "test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("second");
        mv.addObject("message","SecondCtroller 传递的值");
        return mv;
    }
}
