package com.cjc.mapper.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductDto {
//we Have to take same field as its source class
	@Id
	private int pid;
	private String pname;
	private String warrenty;
	private String deller;
	
}
