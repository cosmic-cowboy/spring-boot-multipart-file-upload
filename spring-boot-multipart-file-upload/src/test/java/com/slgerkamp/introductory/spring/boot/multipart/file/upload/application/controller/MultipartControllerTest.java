package com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.slgerkamp.introductory.spring.boot.multipart.file.upload.Application;

/**
 * Multipart形式で送られてくるファイルを含む複数のアカウント情報を取得するAPIです。
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
public class MultipartControllerTest {

	// ログ
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${local.server.port}")
	int port;

	@Before
	public void 事前準備() {
		RestAssured.port = port;
	}

	@Test
	public void multipartで投稿する() {


		File file = new File("resources/11.txt");
		logger.info("file:" + file.getAbsolutePath());
		// HTTPステータスが201であることを確認
		// HTTPボディにMessageIdがあることを確認
		given()
					.multiPart("list[0].name", "controlName0")
					.multiPart("list[0].mail", "controlName0@mail.com")
					.multiPart("list[0].file", file)
					.multiPart("list[1].name", "controlName1")
					.multiPart("list[1].mail", "controlName1@mail.com")
					.multiPart("list[2].name", "controlName2")
					.multiPart("list[2].mail", "controlName2@mail.com")
					.multiPart("list[3].name", "controlName3")
					.multiPart("list[3].mail", "controlName3@mail.com")
					.when().post("/file")
					.then()
					.statusCode(HttpStatus.CREATED.value());
	}


}
