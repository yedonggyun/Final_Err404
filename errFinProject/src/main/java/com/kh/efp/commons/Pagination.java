package com.kh.efp.commons;

import com.kh.efp.member_band.model.vo.PageInfo;

public class Pagination {

	public static PageInfo getPageInfo(int currentPage, int listCount) {
		PageInfo pi = null;
		
		int limit = 10;			//한 페이지에 게시글이 몇개 보여질 것인가
		int buttonCount = 10;	//한 페이지에 보여질 페이징 버튼의 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한 번에 표시될 페이지 버튼의 시작할 페이지 번호
		int endPage;			//한번에 표시될 페이지 버튼의 끝나는 페이지 번호
		
		//총 페이지 수 계산
		maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 페이지에 보여줄 시작 페이지 수
		startPage = (((int)((double)currentPage / buttonCount + 0.9)) - 1) * buttonCount + 1;
		
		//마지막 페이지
		endPage = startPage + buttonCount - 1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		return pi;
	}

}
