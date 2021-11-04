package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Chair extends source{
	private int standAngle;
	private int lyingAngle;
	private int Height;
	public Chair(int standAngle, int lyingAngle, int height,String type, long price) {
		super(type, price);
		this.standAngle = standAngle;
		this.lyingAngle = lyingAngle;
		Height = height;
	}
	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chair(String name, String source) {
		super(name, source);
		// TODO Auto-generated constructor stub
	}
	public int getStandAngle() {
		return standAngle;
	}
	public void setStandAngle(int standAngle) {
		this.standAngle = standAngle;
	}
	public int getLyingAngle() {
		return lyingAngle;
	}
	public void setLyingAngle(int lyingAngle) {
		this.lyingAngle = lyingAngle;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public static List<Chair>getItemsDetails(){
		List<Chair> ItemsList=new ArrayList<>();
		try {
			File file=new File("src/main/resources/static/Details/ChairDetails.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				int StandAngle=Integer.parseInt(Details[0]);
				int LyingAngle=Integer.parseInt(Details[1]);
				int Height=Integer.parseInt(Details[2]);
				Long Price=Long.parseLong(Details[4]); 
				ItemsList.add(new Chair(StandAngle,LyingAngle,Height,Details[3],Price));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemsList;
	}
	public static List<Chair>getItemsSource(){
		List<Chair> ItemsList=getItemsDetails();
		int count=0;
		try {
			File file=new File("src/main/resources/static/ImageSource/ChairName.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				ItemsList.get(count).setName(Details[0]+" "+Details[1]+" "+Details[2]);
				ItemsList.get(count).setSource(Details[3]);
				count++;
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemsList;
	}
	
}
