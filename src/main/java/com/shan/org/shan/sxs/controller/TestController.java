package com.shan.org.shan.sxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	/*
	@RequestMapping(value = "/{path}")
	public String toindex(@PathVariable String path){
		return path;
	}*/
	
	@RequestMapping(value = "/tologin")
	public String login(){
		return "/a";
	}
}
