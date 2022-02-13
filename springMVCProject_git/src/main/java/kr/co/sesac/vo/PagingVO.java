package kr.co.sesac.vo;

public class PagingVO {
	
	//paging
	private int totalCount; // 전체 게시글 수 (get)
	private int currentPage; // 현재 페이지 (get)
	private int totalPage; // 전체 페이지 수 (get)
	
	//pagination
	private int displayPage = 5; // 한 페이지에 몇 개의 페이지 (선택 set)
	private int displayRow = 10; // 한 페이지에 몇 개의 로우 (선택 set)
	private int beginPage; // 페이징 시작 페이지 수
	private int endPage; // 페이징 종료 페이지 수
	
	
	
	
	public PagingVO(int totalCount, int currentPage, int totalPage, int displayPage, int displayRow, int beginPage,
			int endPage) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.displayPage = displayPage;
		this.displayRow = displayRow;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}
	public PagingVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", displayPage=" + displayPage + ", displayRow=" + displayRow + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + "]";
	}
	
	
}