package com.mycompany.myapp;

import java.util.Date;

public class BoardVO {
private int sid;
private String title;
private String photo;
private String detail;
private String password;
private int good;
private int bad;
private Date  regdate;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getGood() {
	return good;
}
public void setGood(int good) {
	this.good = good;
}
public int getBad() {
	return bad;
}
public void setBad(int bad) {
	this.bad = bad;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
}
