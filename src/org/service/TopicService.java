package org.service;

import java.util.ArrayList;

import org.bean.Topic;

public interface TopicService {
	public int getCommentCount(int topicid);
	public ArrayList<Topic> getAllByUser(int userid);
	public boolean Init(int userid,int typeid,String title,String content);
	public boolean delete(int topicid);
	public Topic getTopic(int topicid);//获得帖子
}
