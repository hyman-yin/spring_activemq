package hyman.study.mq.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e){
		System.out.println("进入统一异常管理");
		e.printStackTrace();
		return "error";
	}
}
