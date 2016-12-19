package org.bean;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String name;
     private Integer counttopics;
     private Integer countcomments;
     private Integer typesCategoryId;
     private Set<Topic> topics = new HashSet<Topic>(0);


    // Constructors

    /** default constructor */
    public Type() {
    }
    public Type(int id){
    	this.id = id;
    }
	/** minimal constructor */
    public Type(Integer id, Integer typesCategoryId) {
        this.id = id;
        this.typesCategoryId = typesCategoryId;
    }
    public Type(Integer id,String name){
    	this.id=id;
    	this.name=name;
    }
    /** full constructor */
    public Type(Integer id, String name, Integer counttopics, Integer countcomments, Integer typesCategoryId, Set<Topic> topics) {
        this.id = id;
        this.name = name;
        this.counttopics = counttopics;
        this.countcomments = countcomments;
        this.typesCategoryId = typesCategoryId;
        this.topics = topics;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounttopics() {
        return this.counttopics;
    }
    
    public void setCounttopics(Integer counttopics) {
        this.counttopics = counttopics;
    }

    public Integer getCountcomments() {
        return this.countcomments;
    }
    
    public void setCountcomments(Integer countcomments) {
        this.countcomments = countcomments;
    }

    public Integer getTypesCategoryId() {
        return this.typesCategoryId;
    }
    
    public void setTypesCategoryId(Integer typesCategoryId) {
        this.typesCategoryId = typesCategoryId;
    }

    public Set<Topic> getTopics() {
        return this.topics;
    }
    
    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
   








}