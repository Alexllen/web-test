package org.bean;
// default package

import java.sql.Timestamp;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String username;
     private String password;
     private String sex;
     private String picture;
     private String email;
     private String introduction;
     private String nickname;
     private Integer topcount;
     private Integer comcount;
     private Timestamp registertime;
     private Integer status;
     private String lastip;


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(Integer id) {
        this.id = id;
    }
    public User(Integer id,String passwd){
    	this.id=id;
    	this.password=passwd;
    }
    /** full constructor */
    public User(Integer id, String username, String password, String sex, String picture, String email, String introduction, String nickname, Integer topcount, Integer comcount, Timestamp registertime, Integer status, String lastip) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.picture = picture;
        this.email = email;
        this.introduction = introduction;
        this.nickname = nickname;
        this.topcount = topcount;
        this.comcount = comcount;
        this.registertime = registertime;
        this.status = status;
        this.lastip = lastip;
    }

   
    // Property accessors

    public User(int id2, String passwd, String name) {
		// TODO Auto-generated constructor stub
    	this.id=id2;this.password=passwd;this.username=name;
	}

	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getTopcount() {
        return this.topcount;
    }
    
    public void setTopcount(Integer topcount) {
        this.topcount = topcount;
    }

    public Integer getComcount() {
        return this.comcount;
    }
    
    public void setComcount(Integer comcount) {
        this.comcount = comcount;
    }

    public Timestamp getRegistertime() {
        return this.registertime;
    }
    
    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLastip() {
        return this.lastip;
    }
    
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }
   








}