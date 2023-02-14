package com.cjc.mapper.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.mapper.Entity.Product;
import com.cjc.mapper.Entity.ProductDto;
import com.cjc.mapper.Service.ProductService;

@RestController
@RequestMapping("/map-api")
public class HomeController {
	
    @Autowired
	private ProductService service;

	@GetMapping("/")
	public ResponseEntity<String> check()
	{
		return new ResponseEntity<String>("App Working Fine...!" , HttpStatus.OK);
		
	}
//	 we have to create two model one is complete second is partial data model bc we have partial data from this so this we have to use mapper
	
	@PostMapping("/saveproduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		
		service.saveProduct(product);
		return new ResponseEntity<Product>(product ,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getProduct()
	{
		
	
		List<Product> plist = service.getAllProduct();
		return new ResponseEntity<List<Product>>(plist , HttpStatus.FOUND);
	}
	
	//Now I Want This data In partial Form
	@GetMapping("/getproductdto/{pid}")
	public ResponseEntity<ProductDto> getProductdto(@PathVariable int pid)
	{
		  ProductDto dtopro=service.getproductdto(pid);
		return new ResponseEntity<ProductDto>(dtopro , HttpStatus.FOUND );
	}
	@GetMapping("/getAllproductdto")
	public ResponseEntity<List<ProductDto>> getAllDto()
	{
		
		List<ProductDto> allDtopro=service.getAllproductDto();
		return new ResponseEntity<List<ProductDto>>(allDtopro  , HttpStatus.ACCEPTED);
	}
	
	//With use ModelMapper librery
	@GetMapping("/getprodto/{pid}")
	public ResponseEntity<ProductDto> productToProductDto(@PathVariable int pid)
	{
		ProductDto prodto=service.getprodto(pid);
		return new ResponseEntity<ProductDto>(prodto , HttpStatus.OK);
	}
	@PutMapping("/updateproduct/{pid}")
	public ResponseEntity<ProductDto> editProductToProductDto(@PathVariable int pid , @RequestBody Product product)
	{
	ProductDto pdto	=service.updateProductToproductDto(pid , product);
		return new ResponseEntity<ProductDto>( pdto, HttpStatus.ACCEPTED);
	}
	
}
