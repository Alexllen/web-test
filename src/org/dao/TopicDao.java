package org.dao;

import java.util.ArrayList;

import org.bean.Topic;

public interface TopicDao {
	public int getCommentCount(int topicid);//获取评论数
	public Topic getTopic(int topicid);//获得帖子
	public boolean AddComment(int topicid);//增加评论
	public ArrayList<Topic> getAllByUser(int userid);
	public boolean Init(int userid,int typeid,String title,String content);//创建帖子
	public boolean delete(int topicid);//删除帖子
}
