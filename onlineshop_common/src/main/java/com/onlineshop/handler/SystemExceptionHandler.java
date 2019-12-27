package com.onlineshop.handler;

import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.exception.CommonException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author CrystalLight
 * @Date 2019/12/19 8:57
 * @Version 1.0
 * @Description 拦截捕获异常
 **/
@ControllerAdvice
public class SystemExceptionHandler {


    /**
     * 处理自定义异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Result catchCommonException(HttpServletRequest request, HttpServletResponse response, CommonException e) {

        Result result = new Result(e.getResultCode());
        return result;
    }

    /**
     * 处理未登陆异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    public Result catchUnauthenticatedException(HttpServletRequest request, HttpServletResponse response, UnauthenticatedException e) {
        Result result = new Result(ResultCode.UNAUTHENTICATED);
        return result;
    }

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, AuthorizationException e) {
        return new Result(ResultCode.UNAUTHORISE);
    }


    /**
     * 处理未授权异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e) {

        Result result = new Result(ResultCode.SERVER_ERROR);
        return result;
    }

}
