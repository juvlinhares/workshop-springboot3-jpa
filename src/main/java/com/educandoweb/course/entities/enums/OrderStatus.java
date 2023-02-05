package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	// values:
	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	//create vaiable code:
	
	private Integer code;
	
	//constructor privado:
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//metodo que pega o código:
	public int getCode() {
		return code;
	}
	
	//metodo que pega o valor:
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid oderStatus code");
	}
}
