package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Service.ScreenRepo;



/**
 * @author Admin
 *
 */
@Entity()
@Table(name="Screen")
public class Screen extends source {
	private int size;
	
	public Screen() {
		super();
	}

	public Screen(long price,String type, int size) {
		super(type, price);
		this.size=size;
		// TODO Auto-generated constructor stub
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public static List<Screen>getItemsDetails(){
		List<Screen> ItemsList=new ArrayList<>();
		try {
			File file=new File("src/main/resources/static/Details/ScreenDetails.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				ItemsList.add(new Screen(Long.parseLong(Details[0]),Details[1],Integer.parseInt(Details[2])));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemsList;
	}
	public static List<Screen>getItemsSource(){
		List<Screen> ItemsList=getItemsDetails();
		int count=0;
		try {
			File file=new File("src/main/resources/static/ImageSource/ScreenName.txt");
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

	@Override
	public String toString() {
		return "Screen [size=" + size + "]";
	}
}
