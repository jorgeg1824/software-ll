package com.parking.application.usecase;

public interface UseCase <D, R> {
	
	R execute(D data);

}
