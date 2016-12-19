package org.bean;

// default package

/**
 * DlbId entity. @author MyEclipse Persistence Tools
 */

public class Dlb implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String password;

	// Constructors

	/** default constructor */
	public Dlb() {
	}

	/** full constructor */
	public Dlb(Integer id, String password) {
		this.id = id;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}