package it.mysite.dao;

import it.mysite.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductImplDB implements IProductDAO {

	static final Logger logger = Logger.getLogger(ProductImplDB.class);

	public void addProduct(Product p) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			session.save(p);
			trns.commit();
		} catch (HibernateException e) {
			if (trns != null) {
				trns.rollback();
			}
			logger.error("Closing session after rollback error: ", e);
			throw e;
		}
		finally {
			session.flush();
            session.close();
		}
	}

	public void deleteProduct(Long id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			Product p = (Product) session.load(Product.class, id);
			session.delete(p);
		} catch (HibernateException e) {
			if (trns != null) {
				trns.rollback();
			}
			logger.error("Closing session after rollback error: ", e);
			throw e;
		} 
		finally {
			session.flush();
            session.close();
		}
	}

	public void updateProduct(Product p) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction trns = null;
		try {
            trns = session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            logger.error("Closing session after rollback error: ", e);
        } finally {
            session.flush();
            session.close();
        }

	}

	public Product getProductById(Long id) {
		Product p = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			p = (Product) session.load(Product.class, id);
		} catch (HibernateException e) {
			if (trns != null) {
				trns.rollback();
			}
			logger.error("Closing session after rollback error: ", e);
			throw e;
		}
		finally {
			session.flush();
            session.close();
		}
		return p;
	}

	public List<Product> getAllProducts() {
		logger.info("List of all products");
		List<Product> listProd = new ArrayList<Product>();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			listProd = session.createQuery("from Product").list();
		} catch (HibernateException e) {
			if (trns != null) {
				trns.rollback();
			}
			logger.error("Closing session after rollback error: ", e);
			throw e;
		} 
		finally {
				session.flush();
	            session.close();	
		}
		return listProd;
	}

}
