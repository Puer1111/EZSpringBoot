package com.EZ.boot.notice.model.vo;

public class Pagination {

	private int currentPage; // 현재 페이지 
	private int totalCount; // 전체 게시물 갯수
	
	private int noticeLimit = 10; // 한 페이지당 보여줄 게시물 수 
	private int naviLimit = 10;  // 한 페이지당 보여줄 페이지 번호의 수
	
	private int maxPage;
	private int startNavi;
	private int endNavi;
	
	private int prevPage;
	private int nextPage;

	public Pagination() {}
	
	public Pagination(int totalCount , int currentPage) {
		this.totalCount=totalCount;
		this.currentPage=currentPage;
		makePagination();
	}
	
	private void makePagination() {
		maxPage=(int)Math.ceil((double)totalCount / noticeLimit);
		startNavi=((currentPage-1)/naviLimit)*naviLimit+1;
		endNavi= (startNavi - 1)+naviLimit ;
		endNavi= (endNavi>maxPage) ? maxPage : endNavi;
		if(currentPage <=10) prevPage=1;
		else prevPage=startNavi - 1 ;
		if(endNavi == maxPage) nextPage = maxPage;
		else nextPage = endNavi +1;
	}
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getNoticeLimit() {
		return noticeLimit;
	}
	public void setNoticeLimit(int noticeLimit) {
		this.noticeLimit = noticeLimit;
	}
	public int getNaviLimit() {
		return naviLimit;
	}
	public void setNaviLimit(int naviLimit) {
		this.naviLimit = naviLimit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartNavi() {
		return startNavi;
	}
	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}
	public int getEndNavi() {
		return endNavi;
	}
	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", totalCount=" + totalCount + ", noticeLimit=" + noticeLimit
				+ ", naviLimit=" + naviLimit + ", maxPage=" + maxPage + ", startNavi=" + startNavi + ", endNavi="
				+ endNavi + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	
}
