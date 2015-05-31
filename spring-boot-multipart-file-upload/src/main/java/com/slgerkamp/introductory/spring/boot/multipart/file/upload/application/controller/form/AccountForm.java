package com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller.form;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

/**
 * Multipart 形式で送信されるデータをアカウント単位で格納するクラスです。
 *
 */
@Data
public class AccountForm {

	public String name;

	public String mail;

	public MultipartFile file;


}
