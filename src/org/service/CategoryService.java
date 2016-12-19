package org.service;
import java.util.Map;

public interface CategoryService {
	public Map<Integer,String> get();
	public int getTopiccount(int id);
}
