package com.slgerkamp.introductory.spring.boot.multipart.file.upload.application.controller.form;

import java.util.List;

import lombok.Data;

/**
 * Multipart 形式で送信されるデータをアカウントのリスト単位で格納するクラスです。
 *
 */
@Data
public class AccountFormList {

	public List<AccountForm> list;

}
