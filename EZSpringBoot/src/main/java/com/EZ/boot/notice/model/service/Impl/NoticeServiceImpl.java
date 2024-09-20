package com.EZ.boot.notice.model.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.EZ.boot.common.utility.Util;
import com.EZ.boot.notice.model.dao.NoticeDAO;
import com.EZ.boot.notice.model.mapper.NoticeMapper;
import com.EZ.boot.notice.model.service.NoticeService;
import com.EZ.boot.notice.model.vo.Notice;
import com.EZ.boot.notice.model.vo.NoticeFile;

@Service
public class NoticeServiceImpl implements NoticeService {

//	private NoticeDAO nDao;
	private NoticeMapper mapper;

	public NoticeServiceImpl() {
	}

	@Autowired
	public NoticeServiceImpl(NoticeMapper mapper) {
		this.mapper = mapper;
	}
//
//@Autowired
//public NoticeServiceImpl(NoticeDAO nDao) {
//	this.nDao=nDao;
//}

	@Override
	public Notice selectOne(Integer noticeNo) {
		Notice result = mapper.selectOne(noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectList( RowBounds rowBounds) {
		List<Notice> nList = mapper.selectList(rowBounds);
		return nList;
	}

	@Override
	public int insertNotice(Notice inputNotice, MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = mapper.insertNotice(inputNotice);
		if (uploadFile != null) {
			String fileName = uploadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			// web용 파일 경로
			String filePath = "/images/notice/";
			uploadFile.transferTo(new File("C:/uploadFile/notice/" + fileRename));

			// long fileSize;
			// 절대 경로로 실제 파일 저장 , 저장할때는 Rename 파일명으로 저장
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setFileName(fileName);
			noticeFile.setFileRename(fileRename);
			noticeFile.setFilePath(filePath);
			// noticeFile.setUploadFile(uploadFile);
			noticeFile.setNoticeNo(inputNotice.getNoticeNo());
			result = mapper.insertNoticeFile(noticeFile);
		}
		return result;
	}

	@Override
	public int getTotalCount() {
		int result = mapper.getTotalCount();
		return result;
	}

	@Override
	public int updateNotice(Notice notice, MultipartFile reloadFile) throws IllegalStateException, IOException {
		int result = mapper.updateNotice(notice);
//	if(reloadFile!=null && "".equals(reloadFile.getOriginalFilename())) {
		if (reloadFile != null && !reloadFile.isEmpty()) {
			String fileName = reloadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath = "/images/notice/";
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setFileName(fileName);
			noticeFile.setFileRename(fileRename);
			noticeFile.setFilePath(filePath);
			// noticeModify.html에서 hidden 으로 noticeNo값이 있어야한다.
			noticeFile.setNoticeNo(notice.getNoticeNo());
			reloadFile.transferTo(new File("C:/uploadFile/notice/" + fileRename));
			// 기존에 파일이 없으면 파일을 update 하는게 아니라 insert 해야한다

			NoticeFile nFileOne = mapper.selectNoticeFile(notice.getNoticeNo());
			if (nFileOne != null) {
				//수정 시 기존 파일 삭제
				File nFile = new File("C:/uploadFile/notice/"+nFileOne.getFileRename());
				nFile.delete();
				// new File("").delete();
				result = mapper.updateNoticeFile(noticeFile);
			} else {

				result = mapper.insertNoticeFile(noticeFile);
			}
		}
			return result;
	}

	@Override
	public int deleteNotice(Integer noticeNo) {
		int result = mapper.deleteNotice(noticeNo);
		NoticeFile  noticeFile = mapper.selectNoticeFile(noticeNo);
		if(noticeFile !=null) {
			
			File nFile = new File("C:/uploadFile/notice/" + noticeFile.getFileRename());
			// 라이브러리 에서도 삭제
			nFile.delete();
			result = mapper.deleteNoticeFile(noticeNo);
		}
		return result;
	}

//@Override
//public int insertNoticeFile(NoticeFile noticeFile) 
//		throws IllegalStateException, IOException {
//	// 절대 경로로 실제 파일 저장하기
//	MultipartFile uploadFile = noticeFile.getUploadFile();
//	uploadFile.transferTo(new File("C:/uploadFile/notice/"+noticeFile.getFileRename()));
//	int result= mapper.insertNoticeFile(noticeFile);
//	return result;
//}

}
