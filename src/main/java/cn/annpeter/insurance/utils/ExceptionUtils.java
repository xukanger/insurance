package cn.annpeter.insurance.utils;

import org.springframework.stereotype.Component;

@Component
public class ExceptionUtils extends Exception{

	private static final long serialVersionUID = -5873827074352234193L;
	
	public ExceptionUtils(String message){
		super(message);
	}
	
	public ExceptionUtils(){
		
	}
}
