package org.serviceImp;

import java.util.ArrayList;

import org.bean.Topic;
import org.dao.CategoryDao;
import org.dao.TopicDao;
import org.dao.TypeDao;
import org.service.TopicService;

public class TopicServiceImp implements TopicService {
	private TopicDao topicdao;
	public void setTopicdao(TopicDao topicdao) {
		this.topicdao = topicdao;
	}
	private TypeDao typedao;
	public void setTypedao(TypeDao typedao) {
		this.typedao = typedao;
	}
	@Override
	public int getCommentCount(int topicid) {
		// TODO Auto-generated method stub
		return topicdao.getCommentCount(topicid);
	}

	@Override
	public ArrayList<Topic> getAllByUser(int userid) {
		// TODO Auto-generated method stub
		return topicdao.getAllByUser(userid);
	}

	@Override
	public boolean Init(int userid, int typeid, String title, String content) {
		// TODO Auto-generated method stub
		boolean pass=false;
		pass=topicdao.Init(userid, typeid, title, content);
		pass=typedao.AddTopic(typeid);
		return pass;
	}

	@Override
	public boolean delete(int topicid) {
		// TODO Auto-generated method stub
		return topicdao.delete(topicid);
	}
	@Override
	public Topic getTopic(int topicid) {
		// TODO Auto-generated method stub
		return topicdao.getTopic(topicid);
	}

}
