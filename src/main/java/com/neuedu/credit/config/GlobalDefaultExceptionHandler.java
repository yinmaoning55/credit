package com.neuedu.credit.config;

import com.neuedu.credit.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Created by elvin on 2018/9/20 9:55.
 * @Describe:
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request, Exception ex){
        logDefaultInfo(request);
        String msg = ExceptionUtil.getMessage(ex);
        logger.error(msg);
//        ex.printStackTrace();
        String result = "this is a  null Exception！！！";
        if (msg !=null ){
            result = msg.split("at")[0];
        }
        return  result;
    }



    private void logDefaultInfo(HttpServletRequest request) {
        String remoteAddr = null;
        if (request.getHeader("x-forwarded-for") == null) {
            remoteAddr = request.getRemoteAddr();
        } else {
            remoteAddr = request.getHeader("x-forwarded-for");
        }
        logger.info("Remote Address: " + remoteAddr );
        logger.info("Remote User: " + request.getRemoteUser());
        logger.info("App request: " + request.getRequestURI());
        logger.info("Request params: " + request.getQueryString());
    }

}
