package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	//valores do oredrStatus:
	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5); 
	
	//código dos status:
	private int code;
	
	//acesso ao código:
	
	public int getCode() {
		return code;
	}
	
	//construtor (privado)
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//método pra converter o código em valor(PAID,SHIPPED, etc)
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
