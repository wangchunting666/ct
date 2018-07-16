package com.ct.mybatis.web.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Herdsric-M-003 on 2018/1/30.
 */
@ControllerAdvice
public class ErrorsController {
    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView defaultErrorHandler1(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("/error/404");
        return mav;
    }
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler2(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("/error/404");
        return mav;
    }
}
