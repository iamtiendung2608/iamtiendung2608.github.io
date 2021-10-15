package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;




@Entity
public class Laptop extends source {
	private String Core;
	private String CPU;
	private int Ram;
	private String VGA;
	private String Reso;
	public Laptop(String type, long price) {
		super(type, price);
		// TODO Auto-generated constructor stub
	}


	public String getCore() {
		return Core;
	}
	public void setCore(String core) {
		Core = core;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public int getRam() {
		return Ram;
	}
	public void setRam(int ram) {
		Ram = ram;
	}
	public String getVGA() {
		return VGA;
	}
	public void setVGA(String vGA) {
		VGA = vGA;
	}
	public String getReso() {
		return Reso;
	}
	public void setReso(String reso) {
		Reso = reso;
	}
	public Laptop() {
		super();
	}
	public Laptop(String core, String cPU, int ram, String vGA, String reso
			,String type, long price) {
		super(type, price);
		Core = core;
		CPU = cPU;
		Ram = ram;
		VGA = vGA;
		Reso = reso;
	}
	public static List<Laptop>getItemsDetails(){
		List<Laptop> ItemsList=new ArrayList<>();
		try {
			File file=new File("src/main/resources/static/Details/LaptopDetails.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				String core=Details[0]+" "+Details[1]+" "+Details[2];
				String cpu=Details[3]+" "+Details[4];
				int ram=Integer.parseInt(Details[5]);
				String vga=Details[6]+" "+Details[7]+" "+Details[8];
				String reso=Details[9]+" "+Details[10];
				ItemsList.add(new Laptop(core,cpu,ram,vga,reso,Details[11],Long.parseLong(Details[12])));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemsList;
	}
	public static List<Laptop>getItemsSource(){
		List<Laptop> ItemsList=getItemsDetails();
		int count=0;
		try {
			File file=new File("src/main/resources/static/ImageSource/LaptopName.txt");
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
