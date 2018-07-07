package it.mysite.business;

import it.mysite.dao.IProductDAO;
import it.mysite.dao.Product;

import java.util.List;

public class ProductsBusinessImpl implements IProductBusiness {
	
	private IProductDAO dao;
	
	public IProductDAO getDao() {
		return dao;
	}

	public void setDao(IProductDAO dao) {
		this.dao = dao;
	}

	public void addProduct(Product p) {
		dao.addProduct(p);
	}

	public void deleteProduct(Long id) {
		dao.deleteProduct(id);
	}

	public Product getProductById(Long id) {
		return dao.getProductById(id);
	}

	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

}
