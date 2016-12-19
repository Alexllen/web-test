package org.service;
import java.util.Map;

import org.bean.*;
public interface TypeService {
	public Type getById(int id);
	public Map<Integer,String> getByCId(int id);
	public boolean delete(int id);
}
