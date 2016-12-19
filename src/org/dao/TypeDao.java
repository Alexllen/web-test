package org.dao;

import java.util.Map;

import org.bean.Type;

public interface TypeDao {
	public Type getById(int id);
	public Map<Integer,String> getByCId(int id);
	public boolean delete(int id);
	public boolean AddTopic(int tyid);
	public boolean AddComment(int tyid);
}
