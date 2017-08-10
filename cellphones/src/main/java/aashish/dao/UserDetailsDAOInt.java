package aashish.dao;

import aashish.model.UserDetails;

public interface UserDetailsDAOInt {
	public String addUser(UserDetails ud);
	public UserDetails loginCheck(UserDetails ud);

}
