package com.example.demo.interceptor

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class WebMvcInterceptorsConfig : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(MyInterceptor())
    }
}

    class MyInterceptor : HandlerInterceptor {

        private val logger = LoggerFactory.getLogger(MyInterceptor::class.java)

     //This method is invoked before the actual handler method (controller method) is called.
        override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
            super.preHandle(request, response, handler)
            var name = request.getParameter("user")
            if(name != null && name.toString().length > 30){
                response.contentType = "text/html"
                response.writer.println("user should contain less than 30 char")
                return false
            }
            logger.info("Pre-processing request: ${request.requestURI}")
            return true
        }

        //This method is called after the handler method but before the view is rendered.
        override fun postHandle(
            request: HttpServletRequest,
            response: HttpServletResponse,
            handler: Any,
            modelAndView: ModelAndView?
        ) {
            super.postHandle(request, response, handler, modelAndView)
            modelAndView?.addObject("customAttribute", "Hello from CustomHandlerInterceptor")
            logger.info("Post-processing request: ${request.requestURI}")
        }

        override fun afterCompletion(
            request: HttpServletRequest,
            response: HttpServletResponse,
            handler: Any,
            ex: Exception?
        ) {
            super.afterCompletion(request, response, handler, ex)
            logger.info("Request completed: ${request.requestURI}")
        }
    }
