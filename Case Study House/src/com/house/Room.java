package com.house;

import java.util.Scanner;

import com.main.Main;

public class Room {
	
	String roomType;
	public Devices[] arrDevice = new Devices[10];
	int deviceCtr;
	
	static Scanner sc=new Scanner(System.in);
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(String roomType, Devices[] arrDevice) {
		super();
		this.roomType = roomType;
		this.arrDevice = arrDevice;
		this.deviceCtr = 0;
	}

	public Room(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Devices[] getArrDevice() {
		return arrDevice;
	}
	public void setArrDevice(Devices[] arrDevice) {
		this.arrDevice = arrDevice;
	}
	
	public int getDeviceCtr() {
		return deviceCtr;
	}

	public void setDeviceCtr() {
		this.deviceCtr = ++deviceCtr;
	}
}
