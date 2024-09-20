package com.EZ.boot.notice.controller;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.EZ.boot.common.utility.Util;
import com.EZ.boot.notice.model.service.NoticeService;
import com.EZ.boot.notice.model.vo.Notice;
import com.EZ.boot.notice.model.vo.NoticeFile;
import com.EZ.boot.notice.model.vo.Pagination;



@Controller
@RequestMapping("/notice")
public class NoticeController {

private NoticeService nService;

public NoticeController() {}
		
@Autowired
public NoticeController(NoticeService nService) {
	this.nService=nService;
}
@GetMapping("/write") 
public String showWriteForm() {
	return "notice/noticeWrite";
}
@PostMapping("/write")
public String noticeWrite(Notice inputNotice
//		,@SessionAttribute("memberId") String memberId
		,@RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
//	inputNotice.setNoticeWriter(memberId);
	int result = nService.insertNotice(inputNotice,uploadFile);	
	return "redirect:/notice/list";
}
//@GetMapping("/detail/{noticeNo}")	
////@PathVariable --> 뒤에 와야하는 값 불러오는 Annotation
//public Notice showNoticeOne(@PathVariable("noticeNo") Integer noticeNo) {
//		Notice notice =nService.selectOne(noticeNo);
//		return notice;	
//	}
@GetMapping("/list")
public String showNoticeList(@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage
		,Model model){
	int totalCount = nService.getTotalCount();
	Pagination pn = new Pagination(totalCount,currentPage);
	int limit=pn.getNoticeLimit();
	int offset=(currentPage-1)*limit;
	RowBounds rowBounds = new RowBounds(offset,limit);
	List<Notice>nList = nService.selectList(rowBounds);
	model.addAttribute("nList",nList);
	model.addAttribute("pn",pn);
//	model.addAttribute("startNavi",1);
//	model.addAttribute("endNavi",10);@
	return "notice/noticeList";
}
@GetMapping("/detail/{noticeNo}")
public String showNoticeDetail(@PathVariable("noticeNo")Integer noticeNo
		,Model model) {
	Notice notice = nService.selectOne(noticeNo);
	model.addAttribute("notice",notice);
	return "notice/noticeDetail";
}
@GetMapping("/modify/{noticeNo}")
public String showModifyForm(@PathVariable("noticeNo")Integer noticeNo
		,Model model){
	Notice notice = nService.selectOne(noticeNo);
	model.addAttribute("notice",notice);
	//원래 model addattribute noticeFile 해야하는데 Notice안에 넣어놨기에 필요없음
	return "notice/noticeModify";
}

@PostMapping("/modify")
public String noticeModify(Notice notice
		,@RequestParam("reloadFile") MultipartFile reloadFile) throws IllegalStateException, IOException {
	int result = nService.updateNotice(notice,reloadFile);
	return "redirect:/notice/detail/"+notice.getNoticeNo();
}
@GetMapping("/delete/{noticeNo}")
public String deleteNotice(@PathVariable("noticeNo")Integer noticeNo) {
	int result = nService.deleteNotice(noticeNo);
	return "redirect:/notice/list";
}

}
//@GetMapping("/list")
//public List<Notice> showNoticeList(@RequestParam(value="currentPage" ,required=false , defaultValue="1")Integer currentPage){
//	/*
//	 * int NaviTotal=10; int countToTal; int countPerPage=10; int
//	 * startNavi=(currentPage-1)/NaviTotal*NaviTotal; int endNavi=
//	 * startNavi+NaviTotal-1;
//	 */
//	
//	List<Notice>nList = nService.selectList(currentPage);
//	return nList;
//}
