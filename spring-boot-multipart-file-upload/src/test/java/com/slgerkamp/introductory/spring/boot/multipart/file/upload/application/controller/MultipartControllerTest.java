package com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.restassured.RestAssured;
import com.slgerkamp.introductory.spring.boot.multipart.file.upload.Application;

/**
 * メッセージを送受信する
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
public class MultipartControllerTest {

	
	@Value("${local.server.port}")
	int port;

	@Before
	public void 事前準備() {
		RestAssured.port = port;
	}

	@Test
	public void multipartで投稿する() {


		// HTTPステータスが201であることを確認
		// HTTPボディにMessageIdがあることを確認
		given()
					.multiPart("name", "controlName1")
					.multiPart("mail", "controlName1@mail.com")
					.when().post("/file")
					.then()
					.statusCode(HttpStatus.CREATED.value());
	}


}
