package com.example.demo.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Brand extends source {
	public Brand(String name, String source) {
		super(name, source);
		// TODO Auto-generated constructor stub
	}
	public Brand() {}
	public static List<Brand>getItemsSource(){
		List<Brand> ItemsList=new ArrayList<>();
		try {
			File file=new File("src/main/resources/static/ImageSource/Brand.txt");
					FileReader reader=new FileReader(file);
					BufferedReader BReader=new BufferedReader(reader);
					String line=null;
			while((line=BReader.readLine())!=null) {
				String[]Details=line.split(" ");
				ItemsList.add(new Brand(Details[0],Details[1]));
			}
			BReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ItemsList;
	}
}
