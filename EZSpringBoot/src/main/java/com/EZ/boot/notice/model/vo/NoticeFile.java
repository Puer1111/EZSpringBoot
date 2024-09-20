package com.EZ.boot.notice.model.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeFile {
	private int fileNo;
	private String fileName;
	private String fileRename;
	private String filePath;
	private int NoticeNo;
	
	private MultipartFile uploadFile;
}
