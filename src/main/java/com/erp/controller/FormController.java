package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:  
 * @date 2015年8月13日 下午8:30:37 
 * @version V1.0   
 */

/**
 * 动态页面跳转控制器
 *
 * 这个控制器其实是把所有不符合其他请求映射的url的请求（也就是对静态资源的请求）接收到，然后返回给视图解析器
 * 不然的话所有对静态资源的请求都不会经过拦截器，也就不能起到拦截的作用了
 * */
@Controller
public class FormController {


	@RequestMapping(value="/{formName}")
	 public String loginForm(@PathVariable String formName){
		// 动态跳转页面
		System.out.println("uri="+formName);

		return formName;
	}

}

