package com.main;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.house.*;

public class Main 
{
	static Scanner sc=new Scanner(System.in);
	public static int roomCtr=0;
	static int choice=0;
	static House h1=new House();
	public static void main(String[] args) {
		
		performOperation();

	}
	public static void performOperation()
	{
		System.out.println("Enter House No : ");
		int houseNo=sc.nextInt();
		System.out.println("Enter Owner Name : ");
		String ownerName=sc.next();
		h1.setHouseNo(houseNo);
		h1.setOwnerName(ownerName);
		do 
		{
			System.out.println("\n|--------------------------------------------------|");
			System.out.println("|             HOUSE MANAGEMENT SYSTEM              |");
			System.out.println("|--------------------------------------------------|");
			System.out.println("|   Option   |             Operations              |");
			System.out.println("|--------------------------------------------------|");
			System.out.println("|      1     |       Add Room in House             |");
			System.out.println("|      2     |       Add Device in Room            |");
			System.out.println("|      3     |      Access Devices in Room         |");
			System.out.println("|      4     |     Check Device List in Room       |");
			System.out.println("|      5     |     Check Room List in House        |");
			System.out.println("|      0     |               Exit                  |");
			System.out.println("|--------------------------------------------------|");
//			System.out.println("\nEnter Choice : ");
			choice=choiceInput();
			switch(choice)
			{
				case 1:
				{
					addRoomHouse();
					break;
				}	
				case 2:
				{
					System.out.println("\nEnter Your Room Type : ");
					String roomType=stringTypeInput();
					addDeviceRoom(roomType);
					break;
				}
				case 3:
				{
					System.out.println("\nEnter Your Room Type : ");
					String roomType=stringTypeInput();
					accessDevice(roomType);
					break;
				}
				case 4:
				{
					System.out.println("Enter Your Room Type : ");
					String roomType=stringTypeInput();
					deviceList(roomType);
					break;
				}
				case 5:
				{
					displayRoomList();
					break;
				}
			}
		}while(choice!=0);
	}
	public static void addRoomHouse()
	{
		System.out.println("\n|-----------------------------------------------|");
		System.out.println("|             HOUSE MANAGEMENT SYSTEM           |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|   Option   |             Operations           |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|      1     |             Kitchen              |");
		System.out.println("|      2     |             Living Room          |");
		System.out.println("|      3     |      	   Bed Room             |");
		System.out.println("|      4     |             Dining Area          |");
		System.out.println("|      5     |             Wash Room            |");
		System.out.println("|      6     |            Corridor Area         |");
		System.out.println("|      0     |               Back               |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("\nEnter Type of Room : ");
		String roomType=stringTypeInput();
		addRoom(roomType);
	}
	public static void addDeviceRoom(String roomType)
	{
		int index=findRoom(roomType);
		if(index!=-1)
		{
			int deviceId=101;
			do 
			{
				System.out.println("\n|------------------------------------------|");
				System.out.println("|        HOUSE MANAGEMENT SYSTEM           |");
				System.out.println("|------------------------------------------|");
				System.out.println("|   Option   |        Operations           |");
				System.out.println("|------------------------------------------|");
				System.out.println("|      1     |         Light               |");
				System.out.println("|      2     |          Fan                |");
				System.out.println("|      3     |      	 AC                |");
				System.out.println("|      4     |           TV                |");
				System.out.println("|      5     |         Shower              |");
				System.out.println("|      6     |        Refrigerator         |");
				System.out.println("|      7     |          Back               |");
				System.out.println("|------------------------------------------|");
//				System.out.println("\nEnter Choice : ");
				choice=choiceInput();
				switch(choice)
				{
					case 1:
					{	//light
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Lights(deviceId++,"Light",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("Light Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
					case 2:
					{	//fan
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Fan(deviceId++,"Fan",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("Fan Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
					case 3:
					{	//ac
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Ac(deviceId++,"AC",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("AC Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
					case 4:
					{	//tv
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Tv(deviceId++,"TV",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("TV Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
					case 5:
					{	//shower
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Shower(deviceId++,"Shower",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("Shower Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
					case 6:
					{	//refrigerator
						h1.roomArr[index].arrDevice[h1.roomArr[index].getDeviceCtr()]=new Refrigerators(deviceId++,"Refrigerators",LocalTime.now());
						h1.roomArr[index].setDeviceCtr();
						System.out.println("Refrigerators Added Succesfully in "+h1.roomArr[index].getRoomType()+" ");
						break;
					}
				}
			}while(choice!=7);	
		}
		else
			System.out.println("Room Not Available !!");
	}
	
	public static void accessDevice(String roomType)
	{
		int index=findRoom(roomType);
		if(index!=-1)
		{
			deviceList(h1.roomArr[index].getRoomType());
			System.out.println("\nEnter Device Name : ");
			String device=stringTypeInput();
			int foundDevice=findDevice(device,index);
			do {
					System.out.println("\n|--------------------------------------------------|");
					System.out.println("|             HOUSE MANAGEMENT SYSTEM              |");
					System.out.println("|--------------------------------------------------|");
					System.out.println("|   Option   |             Operations              |");
					System.out.println("|--------------------------------------------------|");
					System.out.println("|      1     |          Turn On Device             |");
					System.out.println("|      2     |          Turn Off Device            |");
					System.out.println("|      3     |      Check Status of Device         |");
					System.out.println("|      4     |             Check Time              |");
					System.out.println("|      5     |               Back                  |");
					System.out.println("|--------------------------------------------------|");
//					System.out.println("\nEnter Choice : ");
					choice=choiceInput();
					switch(choice)
					{
						case 1:
						{
							if(h1.roomArr[index].arrDevice[foundDevice] instanceof Lights)
							{
								///already on asel tya sathi remaing ahe 
								Lights lt=(Lights)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									lt.turnOnDevice();
									System.out.println("Light is Turn On in "+roomType);
								}
								else
									System.out.println("Light is Already On in "+roomType);
								
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Fan)
							{
								Fan fan=(Fan)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									fan.turnOnDevice();
									System.out.println("Fan is Turn On in "+roomType);
								}
								else
									System.out.println("Fan is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Ac ac=(Ac)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									ac.turnOnDevice();
									System.out.println("AC is Turn On in "+roomType);
								}
								else
									System.out.println("AC is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Tv)
							{
								Tv tv=(Tv)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									tv.turnOnDevice();
									System.out.println("TV is Turn On in "+roomType);
								}
								else
									System.out.println("TV is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Shower)
							{
								Shower shower=(Shower)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									shower.turnOnDevice();
									System.out.println("Shower is Turn On in "+roomType);
								}
								else
									System.out.println("Shower is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Refrigerators ref=(Refrigerators)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==false)
								{
									ref.turnOnDevice();
									System.out.println("Refrigerator is Turn On in "+roomType);
								}
								else
									System.out.println("Refrigerator is Already On in "+roomType);
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 2:
						{
							if(h1.roomArr[index].arrDevice[foundDevice] instanceof Lights)
							{
								//already of remaining
								
								Lights lt=(Lights)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									lt.turnOffDevice();
									System.out.println("Light is Turn Off in "+roomType);
								}
								else
									System.out.println("Light is Already Off in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Fan)
							{
								Fan fan=(Fan)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									fan.turnOffDevice();
									System.out.println("Fan is Turn Off in "+roomType);
								}
								else
									System.out.println("Fan is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Ac ac=(Ac)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									ac.turnOffDevice();
									System.out.println("AC is Turn Off in "+roomType);
								}
								else
									System.out.println("AC is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Tv)
							{
								Tv tv=(Tv)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									tv.turnOffDevice();
									System.out.println("TV is Turn Off in "+roomType);
								}
								else
									System.out.println("TV is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Shower)
							{
								Shower shower=(Shower)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									shower.turnOffDevice();
									System.out.println("Shower is Turn Off in "+roomType);
								}
								else
									System.out.println("Shower is Already On in "+roomType);
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Refrigerators)
							{
								Refrigerators ref=(Refrigerators)h1.roomArr[index].arrDevice[foundDevice];
								if(h1.roomArr[index].arrDevice[foundDevice].getStatus()==true)
								{
									ref.turnOffDevice();
									System.out.println("Refigerator is Turn Off in "+roomType);
								}
								else
									System.out.println("Refrigerator is Already On in "+roomType);
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 3:
						{
							if(h1.roomArr[index].arrDevice[foundDevice] instanceof Lights)
							{
								Lights lt=(Lights)h1.roomArr[index].arrDevice[foundDevice];
								if(lt.getStatus()==true)
									System.out.println("Light Status is On !!");
								else
									System.out.println("Light Status is Off !!");
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Fan)
							{
								Fan fan=(Fan)h1.roomArr[index].arrDevice[foundDevice];
								if(fan.getStatus()==true)
									System.out.println("Fan Status is On !!");
								else
									System.out.println("Fan Status is Off !!");
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Ac ac=(Ac)h1.roomArr[index].arrDevice[foundDevice];
								if(ac.getStatus()==true)
									System.out.println("AC Status is On !!");
								else
									System.out.println("AC Status is Off !!");
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Tv)
							{
								Tv tv=(Tv)h1.roomArr[index].arrDevice[foundDevice];
								if(tv.getStatus()==true)
									System.out.println("TV Status is On !!");
								else
									System.out.println("TV Status is Off !!");
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Shower)
							{
								Shower shower=(Shower)h1.roomArr[index].arrDevice[foundDevice];
								if(shower.getStatus()==true)
									System.out.println("Shower Status is On !!");
								else
									System.out.println("Shower Status is Off !!");
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Refrigerators)
							{
								Refrigerators ref=(Refrigerators)h1.roomArr[index].arrDevice[foundDevice];
								if(ref.getStatus()==true)
									System.out.println("Refrigerator Status is On !!");
								else
									System.out.println("Refrigerator Status is Off !!");
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}
						case 4:
						{	
							if(h1.roomArr[index].arrDevice[foundDevice] instanceof Lights)
							{
								Lights lt=(Lights)h1.roomArr[index].arrDevice[foundDevice];
								lt.getDeviceTime();
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Fan)
							{
								Fan fan=(Fan)h1.roomArr[index].arrDevice[foundDevice];
								fan.getDeviceTime();
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Ac ac=(Ac)h1.roomArr[index].arrDevice[foundDevice];
								ac.getDeviceTime();
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Tv)
							{
								Tv tv=(Tv)h1.roomArr[index].arrDevice[foundDevice];
								tv.getDeviceTime();
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Shower)
							{
								Shower shower=(Shower)h1.roomArr[index].arrDevice[foundDevice];
								shower.getDeviceTime();
							}
							else if(h1.roomArr[index].arrDevice[foundDevice] instanceof Ac)
							{
								Refrigerators ref=(Refrigerators)h1.roomArr[index].arrDevice[foundDevice];
								ref.getDeviceTime();
							}
							else
							{
								System.out.println("This Device is Not Available !!");
							}
							break;
						}	
					}
			}while(choice!=5);
		}
		else
			System.out.println("Room Not Available !!");
	}
	///add room
	public static void addRoom(String roomType)
	{
		h1.roomArr[roomCtr++]=new Room(roomType);
		System.out.println(roomType+" Added Succesfully in House !!");
	}
	//room list
	public static void displayRoomList()
	{
		System.out.println("|-|-|-|---- ROOMS IN HOUSE ----|-|-|-|\n");
		for(int i=0;i<roomCtr;i++)
		{
			System.out.println("\t"+(i+1)+". "+h1.roomArr[i].getRoomType());
		}	
	}
	//device list
	public static void deviceList(String roomType)
	{
		int index=findRoom(roomType);
		System.out.println("|-|-|-|---- DEVICES IN ROOM ----|-|-|-|\n");
		for(int i=0;i <h1.roomArr[index].getDeviceCtr();i++)
		{
			System.out.println("\t"+(i+1)+". "+h1.roomArr[index].arrDevice[i].getName()); 
		}
	}
	//room type input with exception
	public static String stringTypeInput()
	{
		while(true) 
		{
			try
			{
				String str=sc.next();
				
				if(!str.matches("[a-zA-Z]+"))
				{
					throw new InputMismatchException("Input Mismatch !! \nPlease Enter String !! You Enter Numeric Value !!");
				}
				else 
				{
					return str; 
				}
				}
			catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	//choice (Integer) input with exception
		public static int choiceInput()
		{
			while(true)
			{
				try
				{
					System.out.println("\nEnter Choice : ");
					choice=sc.nextInt();
					return choice; 
				}
				catch(InputMismatchException e)
				{
					System.out.println("Input Mismatch !! \nPlease Enter Only from Above List Numeric Option !!");
					sc.next();
				}
			}
		}
		//findroom in house
		public static int findRoom(String roomType)
		{
			for(int i=0;i<roomCtr;i++)
			{
				if(h1.roomArr[i].getRoomType().equalsIgnoreCase(roomType))
				{
					return i;
				}
			}
			return -1;
		}
		//find device in room
		public static int findDevice(String device,int roomIndex)
		{
			for(int i=0;i<h1.roomArr[roomIndex].getDeviceCtr();i++)
			{ 
				if(h1.roomArr[roomIndex].arrDevice[i].getName().equalsIgnoreCase(device))
				{
					return i;
				}
			}
			return 0;
		}
}

