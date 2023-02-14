package com.cjc.mapper.Service;

import java.util.List;

import com.cjc.mapper.Entity.Product;
import com.cjc.mapper.Entity.ProductDto;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProduct();

	ProductDto getproductdto(int pid);

	List<ProductDto> getAllproductDto();

	ProductDto getprodto(int pid);

	ProductDto updateProductToproductDto(int pid, Product product);

	ProductDto updateProductToproductDto(int pid);

	void deleteProduct(int pid);

}
