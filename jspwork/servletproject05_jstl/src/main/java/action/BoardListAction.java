package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

 public class BoardListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<BoardBean> articleList=new ArrayList<BoardBean>();
	  	int page=1;  //현재 선택한 페이지를 받을 변수(nowBtn에 해당됨)
		int limit=5; //한 페이지에 보여줄 목록 개수 (onePageListCnt에 해당됨)
		
		if(request.getParameter("page")==null || request.getParameter("page").equals("")) page = 1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		BoardListService boardListService = new BoardListService();
		int listCount=boardListService.getListCount(); //총 목록 개수를 받아옴.
		articleList = boardListService.getArticleList(page,limit); //리스트를 받아옴.
		
		//총 페이지 수(총 버튼 수 : totalBtnCnt에 해당됨)_수정
   		int maxPage;
   		if(listCount%limit==0) maxPage = listCount/limit;
   		else  maxPage = listCount/limit+1 ;
   		
   		//현재 페이지에서 보여줄 시작 페이지번호(시작 버튼 버튼번호)_수정
   		int startPage = (((int) ((double)page / limit + 0.9)) - 1) * limit + 1;
   		//현재 페이지에 보여줄 마지막 페이지 번호(마지막 버튼 버튼번호)_수정
   	    int endPage = startPage+limit-1;

   		if (endPage> maxPage) endPage= maxPage;
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		
		ActionForward forward= new ActionForward();
   		forward.setPath("/board/qna_board_list.jsp");
   		return forward;
   		
	 }
	 
 }