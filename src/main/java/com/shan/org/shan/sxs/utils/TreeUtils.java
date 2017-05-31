package com.shan.org.shan.sxs.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

	public static List<Long> getTreeEner(Long energy) {
		List<Long> list = new ArrayList<>();
		Long begin;
		Long end;
		Long img;
		if (energy >= 0 && energy <= 80) {
			begin = 0l;
			end = 80l;
			img = 1l;
		} else if (energy > 80 && energy <= 500) {
			begin = 80l;
			end = 500l;
			img = 2l;
		} else if (energy > 500 && energy <= 1200) {
			begin = 500l;
			end = 1200l;
			img = 3l;
		} else if (energy > 1200 && energy <= 3000) {
			begin = 1200l;
			end = 3000l;
			img = 4l;
		} else if (energy > 3000 && energy <= 5000) {
			begin = 3000l;
			end = 5000l;
			img = 5l;
		} else if (energy > 5000 && energy <= 8000) {
			begin = 5000l;
			end = 8000l;
			img = 6l;
		} else if (energy > 8000 && energy <= 12000) {
			begin = 8000l;
			end = 12000l;
			img = 7l;
		} else if (energy > 12000 && energy <= 18000) {
			begin = 12000l;
			end = 18000l;
			img = 8l;
		} else if (energy > 18000 && energy <= 25000) {
			begin = 18000l;
			end = 25000l;
			img = 9l;
		} else if (energy > 25000 && energy <= 40000) {
			begin = 25000l;
			end = 40000l;
			img = 10l;
		} else if (energy > 40000 && energy <= 60000) {
			begin = 40000l;
			end = 60000l;
			img = 11l;
		} else if (energy > 60000 && energy <= 100000) {
			begin = 60000l;
			end = 100000l;
			img = 12l;
		} else {
			begin = 100000l;
			end = 100001l;
			img = 13l;
		}
		list.add(begin);
		list.add(end);
		list.add(img);
		return list;
	}
	
	public static String getTreeAge(Long energy) {
		String age;
		if (energy >= 0 && energy <= 80) {
			age = "种子";
		} else if (energy > 80 && energy <= 500) {
			age = "半年";
		} else if (energy > 500 && energy <= 1200) {
			age = "一年";
		} else if (energy > 1200 && energy <= 3000) {
			age = "二年";
		} else if (energy > 3000 && energy <= 5000) {
			age = "三年";
		} else if (energy > 5000 && energy <= 8000) {
			age = "四年";
		} else if (energy > 8000 && energy <= 12000) {
			age = "五年";
		} else if (energy > 12000 && energy <= 18000) {
			age = "六年";
		} else if (energy > 18000 && energy <= 25000) {
			age = "七年";
		} else if (energy > 25000 && energy <= 40000) {
			age = "八年";
		} else if (energy > 40000 && energy <= 60000) {
			age = "九年";
		} else if (energy > 60000 && energy <= 100000) {
			age = "十年";
		} else {
			age = "参天大树";
		}
		return age;
	}
}
