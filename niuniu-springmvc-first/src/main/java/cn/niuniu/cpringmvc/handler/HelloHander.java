package cn.niuniu.cpringmvc.handler;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huanglijun on 2017/12/2.
 */
public class HelloHander implements Controller {

    /**
     * http://localhost:8080/niuniu
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");   //添加 视图的名称
        mv.addObject("msg","hi 妞妞!");  //添加 模型数据  (实际开发 都调后面逻辑返回的)
        return mv;
    }
}
