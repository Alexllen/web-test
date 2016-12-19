package org.serviceImp;

import org.bean.User;
import org.service.UserService;
import org.dao.*;
import org.tool.*;

public class UserServiceImp implements UserService {
	private UserDao userdao;
	private DlbDao dlbdao;
	public void setUserdao(UserDao userdao){
		this.userdao=userdao;
	}
	public void setDlbdao(DlbDao dlbdao){
		this.dlbdao=dlbdao;
	}
	@Override
	public boolean vaildate(int id, String passwd) {
		// TODO Auto-generated method stub
		return dlbdao.Validate(id, passwd);
	}

	@Override
	public User isUser(int id) {
		// TODO Auto-generated method stub
		return userdao.isUser(id);
	}

	@Override
	public boolean UpdateInfo(User user) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public User Register(int id, String passwd, String name) {
		// TODO Auto-generated method stub
		if(userdao.Init(id, passwd, name)&&dlbdao.Init(id, passwd))
		 return userdao.isUser(id);
		else return null;
	}

	@Override
	public String getUserName(int id) {
		// TODO Auto-generated method stub
		return userdao.getName(id);
	}

	@Override
	public boolean vaildateMD5(int id, String passwd) {
		// TODO Auto-generated method stub
		return passwd.equals(CreateMD5.getMd5(dlbdao.getPasswd(id)));
	}
	@Override
	public boolean isUser1(int id) {
		// TODO Auto-generated method stub
		
		return (userdao.isUser(id)!=null);
	}

}
