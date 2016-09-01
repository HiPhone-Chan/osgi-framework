package com.chf.common.core.domain;

import com.chf.common.core.util.RandomUtil;

public class User {

	private String id;

	private String name;

	private String mobile;

	public User() {
	}

	public User(String name) {
		this.id = String.valueOf(RandomUtil.nextInt());
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
}
