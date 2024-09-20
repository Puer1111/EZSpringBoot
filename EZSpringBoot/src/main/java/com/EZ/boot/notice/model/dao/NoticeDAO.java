package com.EZ.boot.notice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.EZ.boot.notice.model.vo.Notice;


// DaoImpl에 아래 메소드 들을 사용하게 하는 Annotation 
public interface NoticeDAO {
/**
 * 공지사항 상세조회 DAO
 * @param noticeNo
 * @return Notice
 */
Notice selectOne(Integer noticeNo);

/**
 * 공지사항 목록 조회 DaO
 * @return List<notice>
 */

List<Notice> selectList(Integer currentPage);

/**
 * 공지사항 등록 Daos
 * @param inputNotice
 * @return int
 */
int insertNotice(Notice inputNotice);

/**
 * 공지 가져오기 Dao
 * @return int
 */
int getTotalCount();
/**
 * 공지 수정 DAO
 * @param notice
 * @return
 */
int updateNotice(Notice notice);
/**
 * 공지 삭제 DAO
 * @param noticeNo
 * @return int
 */
int deleteNotice(Integer noticeNo);

}
