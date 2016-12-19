package org.serviceImp;

import java.util.Map;

import org.dao.CategoryDao;
import org.service.CategoryService;

public class CategoryServiceImp implements CategoryService {
	private CategoryDao categorydao;
	public void setCategorydao(CategoryDao categorydao) {
		this.categorydao = categorydao;
	}
	@Override
	public Map<Integer, String> get() {
		// TODO Auto-generated method stub
		return categorydao.get();
	}

	@Override
	public int getTopiccount(int id) {
		// TODO Auto-generated method stub
		return categorydao.getTopiccount(id);
	}


}
