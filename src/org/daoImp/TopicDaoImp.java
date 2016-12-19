package org.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.bean.Topic;
import org.bean.Type;
import org.dao.TopicDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TopicDaoImp implements TopicDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	@Override
	public int getCommentCount(int topicid) {
		// TODO Auto-generated method stub
		List<Integer> list;
		try{
			ss = ssf.openSession();
			hql = "select comment_count from topic where id=?";
			tr = ss.beginTransaction();
			Query qy = ss.createSQLQuery(hql).setParameter(0, topicid);
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

	@Override
	public ArrayList<Topic> getAllByUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Init(int userid, int typeid, String title, String content) {
		// TODO Auto-generated method stub
		try {
			Topic topic=new Topic(userid,(new Type(typeid)),title,content);
			topic.setTopicTime(new Timestamp(System.currentTimeMillis()));
			topic.setCommentCount(0);
			ss = ssf.openSession(); // ͨ���������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.save(topic); // ͨ�����ӱ���user
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
	public boolean delete(int topicid) {
		// TODO Auto-generated method stub
		try {
			Topic topic=new Topic(topicid);
			ss = ssf.openSession(); // ͨ���������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.delete(topic); // ͨ��delete dlb
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
	public Topic getTopic(int topicid) {
		// TODO Auto-generated method stub
		List<Topic> list;
		try{
			ss = ssf.openSession();
			hql = "from Topic where id=?";
			tr = ss.beginTransaction();
			Query qy = ss.createQuery(hql).setParameter(0, topicid);
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
	public boolean AddComment(int topicid) {
		// TODO Auto-generated method stub
		Topic topic=getTopic(topicid);
		if(topic.getCommentCount()!=null)
			topic.setCommentCount(topic.getCommentCount()+1);
		else topic.setCommentCount(1);
		try{
			ss = ssf.openSession();
			tr = ss.beginTransaction();
			ss.update(topic); 
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
