package aashish.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aashish.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAOInt {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product prd) {

		Session ses = sessionFactory.openSession();
		prd.setProductid(generateProductId());

		ses.save(prd);
		ses.flush();
		ses.close();
		saveProductImage(prd);
	}
	public void deleteProduct(String pid) {
		Session ses= sessionFactory.openSession();
		Product temp=(Product)ses.get(Product.class,pid);
		ses.delete(temp);
		ses.flush();
		ses.close();		
	}
	public void updateProduct(Product prd) {
		Session ses=sessionFactory.openSession();
		ses.update(prd);
		ses.flush();
		ses.close();
		
	}
	public List<Product> getProducts() {
		Session ses = sessionFactory.openSession();
		Query qr = ses.createQuery("from Product");
		List<Product> data = qr.list();
		ses.close();
		return data;
	}
	public Product getProductByID(String pid) {
		Session ses=sessionFactory.openSession();//TO GET PRODUCT INFO BY ID
		Product temp=(Product)ses.get(Product.class, pid);
		ses.close();
        return temp;	
        }


	private String generateProductId() {

		String newPid = "";

		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Product");
		List<Product> data = qr.list();
		s.close();
		if (data.size() == 0) { // if table is empty
			newPid = "PRD00001";
		} else {// if table is not empty
			Session ss = sessionFactory.openSession();
			Query q = ss.createQuery("select max(productid) from Product");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newPid = "PRD0000" + id;
			else if (id <= 99)
				newPid = "PRD000" + id;
			else if (id <= 999)
				newPid = "PRD00" + id;
			else if (id <= 9999)
				newPid = "PRD0" + id;
			else
				newPid = "PRD" + id;
			System.out.print("\nGenerated : " + newPid);
			ss.close();
		}
		return newPid;

	}

	private void saveProductImage(Product prd) {

		System.out.print("\nprd img : " + prd.getImagefile());

		try {
			if (prd.getImagefile() != null) {
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\
				//C:\DT-22-Workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\project1\resources\images\products
				
				//Path path=Paths.get("C://DT-22-Workspace//project1//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");	
				Path path = Paths.get("D://WorkSpace 4-niit//cellphones//src//main//webapp//resources//images//products//"
						+ prd.getProductid() + ".jpg");
				prd.getImagefile().transferTo(new File(path.toString()));
				System.out.print("\nProduct Image saved");
			}
		} catch (Exception ex) {
			System.out.print("\nProduct Image not saved...");
		}
	}
	
}
