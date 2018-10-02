package com.kh.efp.band.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.plus.Activity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.efp.band.model.service.BoardService;
import com.kh.efp.band.model.vo.Board;
 
@Controller
public class BoardController {
 
	//의존관계 주입
    @Autowired
    BoardService boardService;
    
    // 01.게시글 목록
    @RequestMapping("list.do")
    public ModelAndView list() throws Exception{
    	List<Board>list = boardService.listAll();
    	//ModelAndView - 모델과 뷰
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("boardBand/boardMain"); //뷰를 boardMain.jsp로 설정
    	mav.addObject("boardMain",list);//데이터를 저장
    	return mav;// boardMain.jsp로 List 전달
    }
    
    
 /*   //02_01 게시글 작성화면
    //@RequestMapping("board/write.do")
    //value="",method="전송방식"
    @RequestMapping(value = "write.do", method=RequestMethod.GET)
    public String write(){
    	return "board/write";//write.jsp로 이동
    }*/
    
    //02_02. 게시글 작성처리
    @RequestMapping(value="insert.do",method=RequestMethod.POST)
    public String insert(@ModelAttribute Board vo)throws Exception{
    	boardService.create(vo);
    	return "redirect:list.do";
    }
    
    //03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    //HttpSession 세션객체
    @RequestMapping(value="view.do",method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
    	//조회수 증가 처리
    	boardService.increaseViewcnt(bno,session);
    	//모델 (데이터)+뷰(화면) 함께 전달하는 객체
    	ModelAndView mav = new ModelAndView();
    	//뷰의 이름
    	mav.setViewName("board/view");
    	//뷰에 전달할 데이터
    	mav.addObject("dto",boardService.read(bno));
    	return mav;
    }
    
    //04. 게시글 수정
    //폼에서 입력한 내용들은 @ModelAttribute Board vo로 전달
    @RequestMapping(value="update.do",method=RequestMethod.POST)
    public String update(@ModelAttribute Board vo)throws Exception{
    	return "redirect:list.do";
    }
    
    //05. 게시글 삭제
    @RequestMapping("delete.do")
    public String delete(@RequestParam int bno)throws Exception{
    	boardService.delete(bno);
    	return "redirect:list.do";
    }
    
    
}