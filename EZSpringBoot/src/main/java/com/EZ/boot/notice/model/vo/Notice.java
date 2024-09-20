package com.EZ.boot.notice.model.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// @Data : getter , setter , tostring , equals ,hashcode 자동생성
@Getter
@Setter
@NoArgsConstructor // 기본 생성자
// @AllArgsConstructor // 모든 필드 가진 매개변수 생성자
@ToString
public class Notice {
private Integer noticeNo;
private String noticeSubject;
private String noticeContent;
private String noticeWriter;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss",timezone="Asia/Seoul")
private Timestamp noticeDate;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss",timezone="Asia/Seoul")
private Timestamp updateDate;
private Integer viewCount;

//파일 정보
private NoticeFile noticeFile;
}
