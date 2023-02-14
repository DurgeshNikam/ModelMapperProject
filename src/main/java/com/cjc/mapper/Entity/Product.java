package com.cjc.mapper.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	
	@Id
	private int pid;
	private String pname;
	private float price;
	private String brand;
	private String  seller;
	private String warrenty;
	private String deller;
	//private List<String> deller;
	
}
