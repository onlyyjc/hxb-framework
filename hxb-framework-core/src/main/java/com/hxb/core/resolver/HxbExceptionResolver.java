package com.hxb.core.resolver;

import com.hxb.core.exceptions.HxbBusinessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yangjiachang on 2017/12/25.
 */
public class HxbExceptionResolver extends SimpleMappingExceptionResolver {

    public static final String ERRORCODE = "errorCode";

    public static final String MESSAGE = "message";

    public static final String ERRORCODE_AND_MESSAGE = "errorMessage";


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String viewName = determineViewName(ex, request);
        response.setCharacterEncoding("UTF-8");
        if (viewName != null) {
            if (!(request.getHeader("accept").contains("application/json") ||
                    (request.getHeader("X-Requested-With") != null &&
                            request.getHeader("X-Requested-With").contains("XMLHttpRequest")))) {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getMV(viewName, ex);
            } else {
            // JSON格式返回
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(ex.getMessage());
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("JSON格式返回" + viewName);
                return null;
            }
        } else {
            return null;
        }
    }

    private ModelAndView getMV(String viewName, Exception ex){

        ModelAndView mv = getModelAndView(viewName, ex);
        if (ex instanceof HxbBusinessException){
            HxbBusinessException e = (HxbBusinessException)ex;
            mv.addObject(this.ERRORCODE, e.getErrorCode());
            mv.addObject(this.MESSAGE, e.getMessageWithoutCode());
        }
        return mv;
    }
}
