package com.niuniu.springnvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanglijun on 2017/12/2.
 */
@RequestMapping(value = "third")
@Controller
public class Third {

    /**
     * http://localhost:8080/third/hi?Username=niuniu
     * @param name
     * @return
     */
    @RequestMapping(value = "hi")
    public ModelAndView three(@RequestParam(value = "Username")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("three");
        mv.addObject("name",name);
        return mv;
    }
}
