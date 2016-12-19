package org.daoImp;

import java.util.List;

import org.bean.Dlb;
//import org.bean.User;
import org.dao.DlbDao;
//import org.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DlbDaoImp implements DlbDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	@Override
	public boolean Init(int id, String passwd) {
		// TODO Auto-generated method stub
		try {
			Dlb dlb = new Dlb(id, passwd);
			ss = ssf.openSession(); // ͨ��������������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.save(dlb); // ͨ�����ӱ���dlb
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
	public boolean Validate(int id, String passwd) {
		// TODO Auto-generated method stub
		boolean validate=false;
		try{
		ss = ssf.openSession();
		hql = "select password from dlb where id=?";
		tr = ss.beginTransaction();
		Query qy = ss.createSQLQuery(hql).setParameter(0, id);
		if(qy.list()!=null){
			List<String> list=qy.list();
			validate=passwd.equals(list.get(0));
		}
		tr.commit();
		}catch(Exception e){
			System.out.println("Error:Validate Error");
			e.printStackTrace();
			return false;
		}finally{
			if(ss!=null) ss.close();
		}
		return validate;
	}

	@Override
	public String getPasswd(int id) {
		// TODO Auto-generated method stub
		List<String> list;
		try{
		ss = ssf.openSession();
		hql = "select password from dlb where id=?";
		tr = ss.beginTransaction();
		Query qy = ss.createSQLQuery(hql).setParameter(0, id);
		list = qy.list();
		tr.commit();
		}catch(Exception e){
			tr.rollback(); // �����쳣�ع�
			return null;
		}finally{
			if(ss!=null) ss.close();
		}
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			Dlb dlb = new Dlb();
			dlb.setId(id);
			ss = ssf.openSession(); // ͨ��������������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.delete(dlb); // ͨ��delete dlb
			tr.commit(); // �ύ

		} catch (Exception e) {
			tr.rollback(); // �����쳣�ع�
			return false;

		}finally{
			if(ss!=null) ss.close();
		}
		return true;
	}

}
