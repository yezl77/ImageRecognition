package com.ssm.service;

import java.util.List;

import com.ssm.entity.Image;
import com.ssm.entity.User;

public interface SearchService {
	public List<Image> getHistory(User user,int start,int length);
	public List<Image> getHistoryByCondition(User user,String startTime,String endTime,String keyword,int start,int length);
	public Image getImage(int id);
}
