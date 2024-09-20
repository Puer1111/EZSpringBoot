package com.EZ.boot.notice.model.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EZ.boot.notice.model.dao.NoticeDAO;
import com.EZ.boot.notice.model.vo.Notice;

//@Repository
public class NoticeDAOImpl{ //implements NoticeDAO{
//
//private SqlSession session;
//
//public NoticeDAOImpl() {}
//@Autowired
//public NoticeDAOImpl(SqlSession session) {
//	this.session= session;
//}
//@Override
//public Notice selectOne(Integer noticeNo) {
//	Notice result = session.selectOne("NoticeMapper.selectOne",noticeNo);
//	
//	return result;
//}
//@Override
//public List<Notice> selectList(Integer currentPage) {
//	int limit= 10;
//	int offset=(currentPage-1)*limit;
//	RowBounds rowbounds = new RowBounds(offset,limit);
//	List<Notice>nList = session.selectList("NoticeMapper.selectList",null,rowbounds);
//	return nList;
//}
//@Override
//public int insertNotice(Notice inputNotice) {
//	int result = session.insert("NoticeMapper.insertNotice",inputNotice);
//	return result;
//}
//@Override
//public int getTotalCount() {
//	int result= session.selectOne("NoticeMapper.getTotalCount");
//	return result;
//}
//@Override
//public int updateNotice(Notice notice) {
//	int result= session.update("NoticeMapper.updateNotice",notice);
//	return result;
//}
//@Override
//public int deleteNotice(Integer noticeNo) {
//	int result =session.delete("NoticeMapper.deleteNotice",noticeNo);
//	return result;
//}


}
