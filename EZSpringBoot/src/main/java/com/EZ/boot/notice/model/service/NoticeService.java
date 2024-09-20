package com.EZ.boot.notice.model.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import com.EZ.boot.notice.model.vo.Notice;
import com.EZ.boot.notice.model.vo.NoticeFile;

public interface NoticeService {
/**
 * 공지사항 상세조회 Service
 * @param noticeNo
 * @return Notice
 */
	Notice selectOne(Integer noticeNo);

/**
 * 공지 사항 목록 조회 Service
 * @return List<Notice>
 */
List<Notice> selectList(RowBounds rowBounds);

/**
 *  공지 등록 Service
 * @param inputNotice
 * @return
 */
int insertNotice(Notice inputNotice,MultipartFile uploadFile)throws IllegalStateException, IOException;

/**
 * 공지 개수 구하기 Service
 * @return int
 */
int getTotalCount();

/**
 * 공지 수정 Service
 * @param notice
 * @param reloadFile 
 * @return
 */
int updateNotice(Notice notice, MultipartFile reloadFile) throws IllegalStateException, IOException;
/**
 * 공지 삭제 Service
 * @param noticeNo
 * @return
 */
int deleteNotice(Integer noticeNo);
/**
 * 파일 삽입 Service
 * @param noticeFile
 * @return
 * @throws IOException 
 * @throws IllegalStateException 
 */
//int insertNoticeFile(NoticeFile noticeFile) throws IllegalStateException, IOException;

}
