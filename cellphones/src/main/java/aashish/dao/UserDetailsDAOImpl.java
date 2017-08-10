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

import aashish.model.UserDetails;
@Repository
public class UserDetailsDAOImpl implements UserDetailsDAOInt {
	@Autowired
	private SessionFactory sessionFactory;
	

	public String addUser(UserDetails ud) {
		Session ses=sessionFactory.openSession();
		ud.setUserid(generateUserId());

		ses.save(ud);
		ses.flush();
		ses.close();
		saveUserImage(ud);
		return ud.getUserid();	
		}

	public UserDetails loginCheck(UserDetails ud) {
		Session ses = sessionFactory.openSession();
		String qr = "from UserDetails where userid=? and password=? and enabled=true";
		Query qry=ses.createQuery(qr);
		qry.setParameter(0, ud.getUserid());
		qry.setParameter(1, ud.getPassword());
		UserDetails result=(UserDetails)qry.uniqueResult();
		ses.close();
		return result;
	}
	private String generateUserId(){


		String newUid="";

		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from UserDetails");
		List<UserDetails> data = qr.list();
		s.close();
		if(data.size()==0){ // if table is empty
		newUid="USR00001";
		}
		else {// if table is not empty
		Session ss = sessionFactory.openSession();
		Query q = ss.createQuery("select max(userid) from UserDetails");
		String prevId = q.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(3));
		System.out.print("\nExisting id : "+id);
		id=id+1;
		if(id<=9)
		newUid="USR0000"+id;
		else if(id<=99)
		newUid="USR000"+id;
		else if(id<=999)
		newUid="USR00"+id;
		else if(id<=9999)
		newUid="USR0"+id;
		else
		newUid="USR"+id;
		System.out.print("\nGenerated : "+newUid);
		ss.close();
		}
		return newUid;

		}
	private void saveUserImage(UserDetails ud){

		System.out.print("\nprd img : " + ud.getImageFile());

		try{    
		if (ud.getImageFile() != null ) {
		           Path path=Paths.get("D://WorkSpace 4-niit//cellphones//src//main//webapp//resources//images//users//"+ud.getUserid()+".jpg");
		           ud.getImageFile().transferTo(new File(path.toString()));                       
		            System.out.print("\nUser Image saved");            
		        }
		}
		catch(Exception ex){
		System.out.print("\nUser Image not saved...");
		}
		}

	

}
