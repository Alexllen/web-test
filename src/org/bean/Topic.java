package org.bean;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private Type type;
     private String title;
     private String content;
     private Integer commentCount;
     private Integer niceTopic;
     private Timestamp topicTime;
     private Integer status;
     private Integer topicsUserId;
     private Set<Comment> comments = new HashSet<Comment>(0);


    // Constructors

    /** default constructor */
    public Topic() {
    }
    public Topic(int id){
    	this.id=id;
    }
	/** minimal constructor */
    public Topic(Integer id, Type type, Integer topicsUserId) {
        this.id = id;
        this.type = type;
        this.topicsUserId = topicsUserId;
    }
    public Topic(Integer topicsUserId,Type type,String title,String content){
    	this.topicsUserId = topicsUserId;
    	this.type=type;
    	this.title = title;
        this.content = content;
    }
    /** full constructor */
    public Topic(Integer id, Type type, String title, String content, Integer commentCount, Integer niceTopic, Timestamp topicTime, Integer status, Integer topicsUserId, Set<Comment> comments) {
        this.id = id;
        this.type=type;
        this.content = content;
        this.content = content;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.niceTopic = niceTopic;
        this.topicTime = topicTime;
        this.status = status;
        this.topicsUserId = topicsUserId;
        this.comments = comments;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return this.type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }
    
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getNiceTopic() {
        return this.niceTopic;
    }
    
    public void setNiceTopic(Integer niceTopic) {
        this.niceTopic = niceTopic;
    }

    public Timestamp getTopicTime() {
        return this.topicTime;
    }
    
    public void setTopicTime(Timestamp topicTime) {
        this.topicTime = topicTime;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTopicsUserId() {
        return this.topicsUserId;
    }
    
    public void setTopicsUserId(Integer topicsUserId) {
        this.topicsUserId = topicsUserId;
    }

    public Set<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
   








}