package aashish.service;

import aashish.model.UserDetails;

public interface UserDetailsServiceInt {
	public String addUser(UserDetails ud);

	public UserDetails loginCheck(UserDetails ud);
}
