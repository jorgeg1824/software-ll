package com.parking.application.inputport;

public interface InputPort <T, R> {
	
	R execute(T data);

}