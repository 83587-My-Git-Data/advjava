package com.sunbeam.entities;

public enum Type {
	SINGLE(1000), DOUBLE(1500), SUITE(2000);

	private double price;
	
	Type(double price) {
		this.price = price;
	}
	
	public double value() {
        return price;
    }
}
