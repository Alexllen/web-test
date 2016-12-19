package org.daoImp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bean.Comment;
import org.bean.Topic;
import org.bean.Type;
import org.dao.CommentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommentDaoImp implements CommentDao {
	String hql = "";
	Session ss = null;
	private SessionFactory ssf=null;
	Transaction tr = null;
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	@Override
	public boolean Init(int topicid, int userid, String content,int floor) {
		// TODO Auto-generated method stub
		try {
			Comment com=new Comment((new Topic(topicid)),userid,content);
			com.setCommentTime(new Timestamp(System.currentTimeMillis()));
			com.setFloor(floor);
			ss = ssf.openSession(); // ͨ���������
			tr = ss.beginTransaction(); // ͨ�����ӿ�������
			ss.save(com); // ͨ�����ӱ���user
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
	public ArrayList<Comment> getCommentTopic(int topicid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comment> getCommentUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int commentid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Comment getById(int comid) {
		// TODO Auto-generated method stub
		List<Comment> list;
		try{
			ss = ssf.openSession();
			hql = "from Comment where id=?";
			tr = ss.beginTransaction();
			Query qy = ss.createQuery(hql).setParameter(0, comid);
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

}
