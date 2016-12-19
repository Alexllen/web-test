package org.bean;
// default package

import java.sql.Timestamp;


/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private Topic topic;
     private String content;
     private Integer floor;
     private Integer status;
     private Timestamp commentTime;
     private Integer commentsUserId;


    // Constructors

    /** default constructor */
    public Comment() {
    }
    public Comment(Topic topic, int userid, String content){
    	this.topic=topic;
    	this.commentsUserId=userid;
    	this.content=content;
    }
	/** minimal constructor */
    public Comment(Integer id, Topic topic, Integer commentsUserId) {
        this.id = id;
        this.topic = topic;
        this.commentsUserId = commentsUserId;
    }
    
    /** full constructor */
    public Comment(Integer id, Topic topic, String content, Integer floor, Integer status, Timestamp commentTime, Integer commentsUserId) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.floor = floor;
        this.status = status;
        this.commentTime = commentTime;
        this.commentsUserId = commentsUserId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Topic getTopic() {
        return this.topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFloor() {
        return this.floor;
    }
    
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCommentTime() {
        return this.commentTime;
    }
    
    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentsUserId() {
        return this.commentsUserId;
    }
    
    public void setCommentsUserId(Integer commentsUserId) {
        this.commentsUserId = commentsUserId;
    }
   








}