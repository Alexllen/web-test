package org.dao;

import org.bean.User;

public interface UserDao {
	public String getName(int id);
	public boolean Init(int id,String passwd,String name);
	public User isUser(int id);
}
