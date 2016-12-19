package org.serviceImp;

import java.util.Map;

import org.bean.Type;
import org.dao.TypeDao;
import org.service.TypeService;

public class TypeServiceImp implements TypeService {
	private TypeDao typedao;
	public void setTypedao(TypeDao typedao) {
		this.typedao = typedao;
	}

	@Override
	public Map<Integer, String> getByCId(int id) {
		// TODO Auto-generated method stub
		return typedao.getByCId(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return typedao.delete(id);
	}
	@Override
	public Type getById(int id) {
		// TODO Auto-generated method stub
		return typedao.getById(id);
	}

}
