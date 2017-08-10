package aashish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.UserDetailsDAOInt;
import aashish.model.UserDetails;
@Service
public class UserDetailsServiceImpl implements UserDetailsServiceInt {
	@Autowired
	private UserDetailsDAOInt userDetailsDao;
		

	public String addUser(UserDetails ud) {
		return userDetailsDao.addUser(ud);
	}

	public UserDetails loginCheck(UserDetails ud) {
		return userDetailsDao.loginCheck(ud);
	}

}
