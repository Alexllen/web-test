package org.serviceImp;

import java.util.ArrayList;

import org.bean.Comment;
import org.dao.CommentDao;
import org.dao.TopicDao;
import org.dao.TypeDao;
import org.service.CommentService;

public class CommentServiceImp implements CommentService {
	private CommentDao comdao;
	public void setComdao(CommentDao comdao) {
		this.comdao = comdao;
	}
	private TopicDao topicdao;
	public void setTopicdao(TopicDao topicdao) {
		this.topicdao = topicdao;
	}
	@Override
	public boolean Init(int topicid, int userid, String content) {
		// TODO Auto-generated method stub
		boolean pass=false;
		pass=comdao.Init(topicid, userid, content,topicdao.getCommentCount(topicid)+2);
		pass=topicdao.AddComment(topicid);
		return pass;
	}

	@Override
	public ArrayList<Comment> getCommentTopic(int topicid) {
		// TODO Auto-generated method stub
		return comdao.getCommentTopic(topicid);
	}

	@Override
	public ArrayList<Comment> getCommentUser(int userid) {
		// TODO Auto-generated method stub
		return comdao.getCommentUser(userid);
	}

	@Override
	public boolean delete(int commentid) {
		// TODO Auto-generated method stub
		return comdao.delete(commentid);
	}

	@Override
	public Comment getById(int topicid) {
		// TODO Auto-generated method stub
		return comdao.getById(topicid);
	}

}
