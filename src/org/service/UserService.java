package org.service;
import org.bean.*;
public interface UserService {
	public boolean vaildate(int id,String passwd);
	public boolean vaildateMD5(int id,String passwd);
	public User isUser(int id);
	public boolean isUser1(int id);
	public boolean UpdateInfo(User user);
	public User Register(int id,String passwd,String name);
	public String getUserName(int id);
}
