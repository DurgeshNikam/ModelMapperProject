package com.cjc.mapper.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.mapper.Dao.ProductRepo;
import com.cjc.mapper.Entity.Product;
import com.cjc.mapper.Entity.ProductDto;
import com.cjc.mapper.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void saveProduct(Product product) {
		System.out.println("Product Save In Controller");
		repo.save(product);

	}

	@Override
	public List<Product> getAllProduct() {

		return repo.findAll();
	}

	@Override
	public ProductDto getproductdto(int pid) {
		// we have to match the pid and get data from product to ProductDto with help of
		// pid

		ProductDto dto = new ProductDto();
		Optional<Product> product = repo.findById(pid);
		if (product.get().getPid() == pid) {
			dto.setPid(product.get().getPid());
			dto.setPname(product.get().getPname());
			dto.setWarrenty(product.get().getWarrenty());
			dto.setDeller(product.get().getDeller());

		}

		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getAllproductDto() {
		List<ProductDto> ldtopro = new ArrayList<ProductDto>();

		List<Product> lpro = repo.findAll();

		// mapper.map(lpro , ProductDto.class);
		ldtopro = (List<ProductDto>) mapper.map(lpro, ProductDto.class);

		return ldtopro;
	}

	@Override
	public ProductDto getprodto(int pid) {
		ProductDto pdto = new ProductDto();// Destination
		Optional<Product> product = repo.findById(pid);// Source
		if (product.get().getPid() == pid) {

			pdto = mapper.map(product, ProductDto.class);

		}
		return pdto;
	}

	@Override
	public ProductDto updateProductToproductDto(int pid, Product product) {

		ProductDto odto = new ProductDto();
		Product product2 = repo.save(product);

		if (product2.getPid() == pid) {
			odto = mapper.map(product, ProductDto.class);
		}
		return odto;
	}

	@Override
	public ProductDto updateProductToproductDto(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int pid) {
Optional<Product> product = repo.findById(pid);
		if(product.get().getPid()==pid)
		{
			repo.deleteById(pid);
		}
		
	}

}
