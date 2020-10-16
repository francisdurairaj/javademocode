package com.ameya.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

	@Value("${msg:Hello world - Config Server Not Reachable !!!}")
	private String msg;
	
	@RequestMapping("/msg")
	String getMsg() {
		return msg;
	}
}
