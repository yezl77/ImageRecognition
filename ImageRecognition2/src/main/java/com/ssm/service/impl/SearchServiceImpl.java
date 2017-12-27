package com.ssm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.ImageMapper;
import com.ssm.entity.Image;
import com.ssm.entity.ImageExample;
import com.ssm.entity.User;
import com.ssm.service.SearchService;
import com.ssm.util.PaginationUtil;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	ImageMapper imagerMapper;

	@Override
	public List<Image> getHistory(User user, int start, int length) {
		// TODO Auto-generated method stub
		ImageExample ie = new ImageExample();
		ImageExample.Criteria iec = ie.createCriteria();
		iec.andUserIdEqualTo(user.getId());
		ie.setPagination(new PaginationUtil(start, length));
		List<Image> list = imagerMapper.selectByExample(ie);
		return list;
	}

	@Override
	public List<Image> getHistoryByCondition(User user, String startTime, String endTime, String keyword, int start,
			int length) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ImageExample ie = new ImageExample();
		ie.setPagination(new PaginationUtil(start, length));
		ImageExample.Criteria iec = ie.createCriteria();
		List<Image> list = null;
		try {
			iec.andUserIdEqualTo(user.getId()).andUploadtimeBetween(formatter.parse(startTime),
					formatter.parse(endTime));
			ImageExample.Criteria iec2 = ie.createCriteria();
			iec2.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime)).andOriginLike(keyword);
			ie.or(iec2);
			ImageExample.Criteria iec3 = ie.createCriteria();
			iec3.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime))
					.andSeparatepositionLike(keyword);
			ie.or(iec3);
			ImageExample.Criteria iec4 = ie.createCriteria();
			iec4.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime))
					.andBacterialLike(keyword);
			ie.or(iec4);
			ImageExample.Criteria iec5 = ie.createCriteria();
			iec5.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime)).andMethodLike(keyword);
			ie.or(iec5);
			ImageExample.Criteria iec6 = ie.createCriteria();
			iec6.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime)).andRemarkLike(keyword);
			ie.or(iec6);
			ImageExample.Criteria iec7 = ie.createCriteria();
			iec7.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime))
					.andProvinceLike(keyword);
			ie.or(iec7);
			ImageExample.Criteria iec8 = ie.createCriteria();
			iec8.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime)).andCityLike(keyword);
			ie.or(iec8);
			ImageExample.Criteria iec9 = ie.createCriteria();
			iec9.andUserIdEqualTo(user.getId())
					.andUploadtimeBetween(formatter.parse(startTime), formatter.parse(endTime))
					.andLocationLike(keyword);
			ie.or(iec9);
			list = imagerMapper.selectByExample(ie);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Image getImage(int id) {
		// TODO Auto-generated method stub

		return imagerMapper.selectByPrimaryKey(id);
	}

}
