package com.house;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.main.Main;

public class Room {
	
	String roomType;
	List<Devices> arrDevice=new ArrayList<Devices>();
//	public Devices[] arrDevice = new Devices[10];
	
	static Scanner sc=new Scanner(System.in);
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public Room(String roomType, List<Devices> arrDevice) {
		super();
		this.roomType = roomType;
		this.arrDevice = arrDevice;
	}

	public void setArrDevice(List<Devices> arrDevice) {
		this.arrDevice = arrDevice;
	}
	public List<Devices> getArrDevice() {
		return arrDevice;
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

	@Override
	public int hashCode() {
		return Objects.hash(roomType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(roomType, other.roomType);
	}

	@Override
	public String toString() {
		return "Room [roomType=" + roomType + ", arrDevice=" + arrDevice + "]";
	}
	
}
