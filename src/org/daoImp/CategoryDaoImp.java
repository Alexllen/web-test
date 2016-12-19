package org.daoImp;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bean.Category;
import org.dao.CategoryDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CategoryDaoImp implements CategoryDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	@Override
	public Map<Integer, String> get() {
		// TODO Auto-generated method stub
		List<Category> list;
		Map<Integer,String> map = new TreeMap<Integer,String>();
		try{
			ss = ssf.openSession();
			hql = "from Category";
			tr = ss.beginTransaction();
			Query qy = ss.createQuery(hql);
			list=qy.list();
			if(list.size()!=0)for(int i=0;i<list.size();i++){                                                        
                map.put(list.get(i).getId(), list.get(i).getName());                           
            }
			tr.commit();
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				if(ss!=null) ss.close();
			}
			return map;
	}

	@Override
	public int getTopiccount(int id) {
		// TODO Auto-generated method stub
		List<Integer> list;
		try{
			ss = ssf.openSession();
			hql = "select counttopic from category where id=?";
			tr = ss.beginTransaction();
			Query qy = ss.createSQLQuery(hql).setParameter(0, id);
			list = qy.list();
			tr.commit();
			}catch(Exception e){
				tr.rollback(); 
				return 0;
			}finally{
				if(ss!=null) ss.close();
			}
			if (list.size() == 0)
				return 0;
			else
				return list.get(0);
	}

}
