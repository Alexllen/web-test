package org.dao;

import java.util.ArrayList;

import org.bean.Comment;

public interface CommentDao {
	public boolean Init(int topicid,int userid,String content,int floor);
	public ArrayList<Comment> getCommentTopic(int topicid);
	public ArrayList<Comment> getCommentUser(int userid);
	public boolean delete(int commentid);
	public Comment getById(int topicid);
}
