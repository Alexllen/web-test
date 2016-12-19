package org.dao;

import java.util.Map;

public interface CategoryDao {
	public Map<Integer,String> get();
	public int getTopiccount(int id);
}
