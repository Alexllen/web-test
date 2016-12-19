package org.daoImp;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bean.Category;
import org.bean.Dlb;
import org.bean.Topic;
import org.bean.Type;
import org.dao.TypeDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TypeDaoImp implements TypeDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	public Type getById(int id) {
			List<Type> list;
			try{
				ss = ssf.openSession();
				hql = "from Type where id=?";
				tr = ss.beginTransaction();
				Query qy = ss.createQuery(hql).setParameter(0, id);
				list = qy.list();
				tr.commit();
				}catch(Exception e){
					tr.rollback(); // �����쳣�ع�
					return null;
				}
				finally{
					if(ss!=null) ss.close();
				}
				if (list.size()==0)
					return null;
				else
					return list.get(0);
	}

	@Override
	public Map<Integer, String> getByCId(int id) {
		// TODO Auto-generated method stub
		List<Type> list;
		Map<Integer,String> map = new TreeMap<Integer,String>();
		try{
			ss = ssf.openSession();
			hql = "from Type where typesCategoryId=?";
			tr = ss.beginTransaction();
			Query qy = ss.createQuery(hql).setParameter(0, id);
			list=qy.list();
			if(list.size()!=0)for(Type tp:list){                                                        
                map.put(tp.getId(), tp.getName());                           
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			Type type=new Type();
			type.setId(id);
			ss = ssf.openSession(); // ͨ���������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.delete(type); // ͨ��delete dlb
			tr.commit(); // �ύ

		} catch (Exception e) {
			tr.rollback(); // �����쳣�ع�
			return false;

		}finally{
			if(ss!=null) ss.close();
		}
		return true;
	}
	@Override
	public boolean AddTopic(int tyid) {
		// TODO Auto-generated method stub
		Type tp=getById(tyid);
		if(tp.getCounttopics()!=null)
			tp.setCounttopics(tp.getCounttopics()+1);
		else tp.setCounttopics(1);
		try{
			ss = ssf.openSession();
			tr = ss.beginTransaction();
			ss.update(tp); 
			tr.commit();
			}catch(Exception e){
				tr.rollback(); // �����쳣�ع�
				return false;
			}
			finally{
				if(ss!=null) ss.close();
			}return true;
	}
	@Override
	public boolean AddComment(int tyid) {
		// TODO Auto-generated method stub
		Type tp=getById(tyid);
		if(tp.getCountcomments()!=null)
			tp.setCountcomments(tp.getCountcomments()+1);
		else tp.setCountcomments(1);
		try{
			ss = ssf.openSession();
			tr = ss.beginTransaction();
			ss.update(tp); 
			tr.commit();
			}catch(Exception e){
				tr.rollback(); // �����쳣�ع�
				return false;
			}
			finally{
				if(ss!=null) ss.close();
			}return true;
	}

}
