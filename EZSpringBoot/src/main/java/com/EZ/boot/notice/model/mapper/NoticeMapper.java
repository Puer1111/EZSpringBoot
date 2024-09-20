package com.EZ.boot.notice.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import com.EZ.boot.notice.model.vo.Notice;
import com.EZ.boot.notice.model.vo.NoticeFile;

/*
	@Mapper 어노테이션
 	Mapper 인터페이스 메소드 명과 mapper.xml 에 작성한 태그 아이디가 같은것 끼리 연결 해 주는
	Annotation 
	
	1.SqlSession Template bean에 의존성 주입 받는 코드 작성을 안함.
	작성을 안해도 Spring Container 에서 알아서 생성 후 사용
	2.namespace.id 값을 적지 안하도 된다.
	3.session 에서 사용한 메소드를 작성하지 않아도 된다.
	
	※주의 사항 
	★★★★★★★mapper.xml 에서 mapper 인터페이스의 경로를
	namespace에 적어주어야한다.
*/
@Mapper
// DaoImpl에 아래 메소드 들을 사용하게 하는 Annotation 
public interface NoticeMapper {
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

List<Notice> selectList(RowBounds rowBounds);

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
/**
 * 
 * @param noticeFile
 * @return
 */
int insertNoticeFile(NoticeFile noticeFile);
/**
 * 파일 업데이트 Mapper
 * @param noticeFile
 * @return
 */
int updateNoticeFile(NoticeFile noticeFile);
/**
 * 번호로 공지 선택
 * @param noticeNo
 * @return
 */
NoticeFile selectNoticeFile(Integer noticeNo);
/**
 * 공지사항 삭제 Mapper
 * @param noticeNo
 * @return int
 */
int deleteNoticeFile(Integer noticeNo);

}
