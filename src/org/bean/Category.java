package org.bean;
// default package



/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String name;
     private Integer counttopic;
     private Integer countcomments;


    // Constructors

    /** default constructor */
    public Category() {
    }

	/** minimal constructor */
    public Category(Integer id) {
        this.id = id;
    }
    public Category(Integer id ,String name){
    	this.id = id;
        this.name = name;
    }
    /** full constructor */
    public Category(Integer id, String name, Integer counttopic, Integer countcomments) {
        this.id = id;
        this.name = name;
        this.counttopic = counttopic;
        this.countcomments = countcomments;
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

    public Integer getCounttopic() {
        return this.counttopic;
    }
    
    public void setCounttopic(Integer counttopic) {
        this.counttopic = counttopic;
    }

    public Integer getCountcomments() {
        return this.countcomments;
    }
    
    public void setCountcomments(Integer countcomments) {
        this.countcomments = countcomments;
    }
   








}