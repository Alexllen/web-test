package org.dao;

public interface DlbDao {
	public boolean Init(int id,String passwd);
	public boolean Validate(int id,String passwd);
	public String getPasswd(int id);
	public boolean delete(int id);
}
