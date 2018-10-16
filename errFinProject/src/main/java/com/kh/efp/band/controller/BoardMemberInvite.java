package com.kh.efp.band.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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
import com.kh.efp.band.model.vo.BanMemberList;
import com.kh.efp.band.model.vo.Board;
import com.kh.efp.band.model.vo.Member_Band;
import com.kh.efp.band.model.service.BandService;
import com.kh.efp.band.model.service.BoardMemberService;

 
@Controller
public class BoardMemberInvite {
	
	
 
	@Inject
	BoardMemberService boardMemberService;
    
	// 01. 회원 목록
	@RequestMapping("boardMemberInvite.do")
	public String BoardMemberList(Model model){
		
		//임시로 지정
		int bid = 1;
	
		
		Member_Band mb = new Member_Band();
		
		mb.setBid(bid);
	/*	
		ArrayList<Member_Band> mbList = boardMemberService.boardMemberInvite(mb);
		
		
		model.addAttribute("list", mbList);
		model.addAttribute("banList", banList);*/
		
		return "boardBand/memberInvite";
	}
    
    
    
}