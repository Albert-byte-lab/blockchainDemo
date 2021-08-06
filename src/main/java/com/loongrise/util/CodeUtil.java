package com.loongrise.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码处理工具类;
 * @author yy
 *
 */
public class CodeUtil {
	
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//前台生成的验证码图片的值;
		String verifyCodeExpected = (String)request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		//接受前台传过来的真实输入的验证码;
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		
		//判断二者是否相等;
		if(verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}else {
			return true;
		}
	}
}
