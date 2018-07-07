package it.mysite.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProductDAO {

	List<Product> products = new ArrayList<Product>();
	
	public void init(){
		addProduct(new Product("TV1", "Mac", 875.90));
		addProduct(new Product("TV2", "Nick", 6376.0));
		addProduct(new Product("TV3", "Toshiba", 647.99));
		addProduct(new Product("TV4", "Philips", 787.90));
		addProduct(new Product("TV5", "Lg", 545.0));
		addProduct(new Product("TV6", "Samsung", 453.0));
		addProduct(new Product("TV7", "Sony", 343.0));
	}
	public void addProduct(Product p) {
		p.setId(new Long(products.size()) + 1);
		products.add(p);
	}

	public void deleteProduct(Long id) {
		products.remove(getProductById(id));
	}

	public void updateProduct(Product p) {
		p.setId(p.getId());
		products.add(p);
	}

	public Product getProductById(Long id) {
		for(Product p:products){
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}

	public List<Product> getAllProducts() {
		return products;
	}

}
