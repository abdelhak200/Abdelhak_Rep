package it.mysite.dao;

import java.util.List;

public interface IProductDAO {
	
	public void addProduct(Product p);
	public void deleteProduct(Long id);
	public void updateProduct(Product p);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
	

}
