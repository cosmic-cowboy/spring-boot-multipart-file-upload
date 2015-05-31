package com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller.form.AccountForm;

/**
 * 複数の
 *
 */
@RestController
@RequestMapping("/file")
public class MultipartController {
	
	// ログ
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> multipart(@ModelAttribute AccountForm form){
		
		logger.info("name:" + form.name);
		logger.info("mail:" + form.mail);
		Map<String, Object> map = new HashMap<>();
		map.put("status", "ok");
		return map;
	}
}
