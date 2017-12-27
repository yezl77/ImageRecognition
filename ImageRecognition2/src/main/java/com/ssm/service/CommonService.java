package com.ssm.service;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.ssm.entity.User;
import com.ssm.util.StatusCode;

/**
*@author 书生
*/
public interface CommonService {
	public User login(User user);
	
	public StatusCode register(User user);
	
	public User getInfo(String phonenum);
	
	public int setInfo(User user);
	
	public String getPassword(String phonenum);
	
	public int resetPassword(String phonenum,String password);
	
	public int sendMail(User user) throws Exception;
	public MimeMessage createMimeMessage(Session session,User user,int num, String sendMail, String receiveMail) throws Exception;
}
