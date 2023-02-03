package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	// values:
	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	// create code variable:
	private int code;

	// create private constructor:
	private OrderStatus(int code) {
		this.code = code;
	}

	// acess orderStatus code
	public int getCode() {
		return code;
	}

	// create static method to converter code in orderStatus value:
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
