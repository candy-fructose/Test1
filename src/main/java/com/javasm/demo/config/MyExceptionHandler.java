/**
 * @FileName:
 * @Date:2020/6/1 21:18
 * @Description:
 */
package com.javasm.demo.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
/*自定义异常属性*/
@Component
public class MyExceptionHandler extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes= super.getErrorAttributes(webRequest, options);
        errorAttributes.put("mymsg","我的自定义信息");
       /* System.out.println(errorAttributes);
        {timestamp=Mon Jun 01 22:44:44 CST 2020,
                status=500,
                error=Internal Server Error,
                trace=org.thymeleaf.exceptions.TemplateInputException:
                message=Error resolving template [date],Template Resolvers,
                path=/date,
                mymsg=我的自定义信息}*/

        return errorAttributes;
    }
}
