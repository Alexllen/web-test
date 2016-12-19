package org.service;
import java.util.ArrayList;

import org.bean.*;
public interface CommentService {
	public boolean Init(int topicid,int userid,String content);
	public ArrayList<Comment> getCommentTopic(int topicid);
	public ArrayList<Comment> getCommentUser(int userid);
	public boolean delete(int commentid);
	public Comment getById(int topicid);
}
