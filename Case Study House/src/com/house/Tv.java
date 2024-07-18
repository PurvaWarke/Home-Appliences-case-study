package com.house;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Tv extends Devices implements Switchable{

	public Tv() {
		// TODO Auto-generated constructor stub
	}
	public Tv(int deviceId, String name,LocalTime time) {
		super(deviceId,name,time);
	}
	@Override
	public void turnOnDevice() {
		// TODO Auto-generated method stub
		this.setStatus(true);
	}

	@Override
	public void turnOffDevice() {
		// TODO Auto-generated method stub
		this.setStatus(false);
	}

	@Override
	public long getDeviceTime() {
		// TODO Auto-generated method stub
		if(this.getStatus()==true)
		{
			long timeDiff=ChronoUnit.SECONDS.between(getTime(),LocalTime.now());
			System.out.println("Tv is Turn On "+timeDiff+"Sec Ago !!");
			return timeDiff;
		}
		else
			System.out.println("Device is Off !!");
		return 0;
	}
}
