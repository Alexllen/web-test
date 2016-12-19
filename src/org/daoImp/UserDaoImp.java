package org.daoImp;

import java.util.List;

import org.bean.User;
import org.hibernate.*;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.dao.UserDao;

public class UserDaoImp implements UserDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String getName(int id) {
		// TODO Auto-generated method stub
		List<String> list;
		try{
		ss = ssf.openSession();
		hql = "select username from user where id=?";
		tr = ss.beginTransaction();
		Query qy = ss.createSQLQuery(hql).setParameter(0, id);
		list = qy.list();
		tr.commit();
		}catch(Exception e){
			tr.rollback(); // �����쳣�ع�
			return null;
		}
		finally{
			if(ss!=null) ss.close();
		}
		if (list==null||list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public boolean Init(int id, String passwd, String name) {
		// TODO Auto-generated method stub
		try {
			User user = new User(id, passwd, name);
			ss = ssf.openSession(); // ͨ���������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.save(user); // ͨ�����ӱ���user
			tr.commit(); // �ύ

		} catch (Exception e) {
			tr.rollback(); // �����쳣�ع�
			return false;

		} finally{
			if(ss!=null) ss.close();
		}
		return true;
	}

	@Override
	public User isUser(int id) {
		// TODO Auto-generated method stub
		List<User> list;
		try{
		ss = ssf.openSession();
		hql = "from User where id=?";
		tr = ss.beginTransaction();
		Query qy = ss.createQuery(hql).setParameter(0, id);
//		list = qy.list();
		if(qy.list()!=null)
			list = qy.list();
		else list=null;
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
}
