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

import com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller.form.AccountFormList;

/**
 * Multipart形式で送られてくるファイルを含む複数のアカウント情報を取得するAPIです。
 *
 */
@RestController
@RequestMapping("/file")
public class MultipartController {
	
	// ログ
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> multipart(@ModelAttribute AccountFormList list){
		
		list.list.stream().forEach(form -> {
			logger.info("name:" + form.name);
			logger.info("mail:" + form.mail);	
			if(form.file != null){
				logger.info("file:" + form.file.getOriginalFilename());	
			}
		});
		Map<String, Object> map = new HashMap<>();
		map.put("status", "ok");
		return map;
	}
}
