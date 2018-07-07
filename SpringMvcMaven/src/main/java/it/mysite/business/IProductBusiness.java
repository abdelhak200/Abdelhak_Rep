package it.mysite.business;

import it.mysite.dao.Product;

import java.util.List;

public interface IProductBusiness {

	public void addProduct(Product p);
	public void deleteProduct(Long id);
	public Product getProductById(Long id);
	public List<Product> getAllProducts();
}
