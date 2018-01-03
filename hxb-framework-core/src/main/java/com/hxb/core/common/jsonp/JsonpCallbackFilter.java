
package com.hxb.core.common.jsonp;

import com.hxb.core.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * 通过过滤器统一处理跨域请求
 * 跨域请求统一规范：1、要提交callback请求参数；2、需在请求URL后添加.jsonp后缀
 *  http(s)://xxxx/xxx.jsonp
 * @author MARK
 * @version 2017-03-20
 */
public class JsonpCallbackFilter implements Filter {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

    public void init(FilterConfig fConfig) throws ServletException {}

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String callback = request.getParameter("callback");
        if(StringUtils.isNotBlank(callback)) {
            OutputStream out = response.getOutputStream();
            GenericResponseWrapper wrapper = new GenericResponseWrapper(response);
            chain.doFilter(request, wrapper);            
            out.write(new String(callback + "(").getBytes());
            //Handle error case. If the callback is used, the Exception Handling is skipped
            if(wrapper.getData() == null || wrapper.getData().length == 0){
                //todo
            	throw new RuntimeException();
            }else{
            	out.write(wrapper.getData());            	
            }
            out.write(new String(");").getBytes());
            wrapper.setContentType("text/javascript;charset=UTF-8");
            wrapper.setHeader("Access-Control-Allow-Origin", "*");
            wrapper.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}