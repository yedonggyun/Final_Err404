package com.kh.efp.band.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.efp.band.model.service.BandService;
import com.kh.efp.band.model.vo.Band;
import com.kh.efp.band.model.vo.Member_Band;
import com.kh.efp.band.model.vo.Scehdule;
import com.kh.efp.commons.DayWeek;
import com.kh.efp.member.model.vo.Member;


@Controller
public class BandController {
	@Autowired private BandService bs;

	@RequestMapping("bandCalendarList.bd")
	public String showBandCalendar(Model model) throws Exception{
		
		System.out.println("달력 호출");
		
		List<Object> list = new ArrayList<Object>();
		
		list = bs.scehduleList();
		
		model.addAttribute("sList", list); 
		
		for(int i=0; i<list.size(); i++){
			String str = ((Scehdule) list.get(i)).getsDate();
			/*System.out.println(str.substring(8, 10));*/
			((Scehdule) list.get(i)).setDayNum(str.substring(5, 10));
			
			String day = DayWeek.getDateDay(((Scehdule) list.get(i)).getsDate().substring(0, 11), "yyyy-MM-dd");
			
			((Scehdule) list.get(i)).setDayWeek(day);
			
		}
		return "band/calandar";
	}
	

	@RequestMapping(value="eventCheck.bd", method=RequestMethod.POST)
	@ResponseBody 
	public Object eventCheck(@RequestParam String title, Map<String, Object> map,
										HttpServletResponse response) throws Exception{
			
			
		System.out.println("eventCheck 컨트롤러 호출..");
		
		List<Object> list = new ArrayList<Object>();
		
		list = bs.scehduleList();
		
		for(int i=0; i<list.size(); i++){
			String str = ((Scehdule) list.get(i)).getsDate();
			/*System.out.println(str.substring(8, 10));*/
			((Scehdule) list.get(i)).setDayNum(str.substring(5, 10));
			
			String day = DayWeek.getDateDay(((Scehdule) list.get(i)).getsDate().substring(0, 11), "yyyy-MM-dd");
			
			((Scehdule) list.get(i)).setDayWeek(day);
			
		}
		
		Map<String, Object> ret = new HashMap<String, Object>();
		
		ret.put("eList", list);
		return ret;	
	}
	
	@RequestMapping("addCalendar.bd")
	public @ResponseBody HashMap<String, Object> addCalendar(
			@RequestParam String title, String content, String sDate, String eDate){
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("sDate : " + sDate);
		System.out.println("eDate : " + eDate);
		
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();

		Scehdule s = new Scehdule(sDate, eDate, title, content);
		
		int result = bs.insertScehdule(s);
		
		int next = bs.selectCurrval();

		hmap.put("next", next);

		return hmap;
	}
	
	/*@RequestMapping(value="deleteCalendar.bd")
	public String deleteCalendar(@RequestParam int did, Model model,
										HttpServletResponse response){
			
			
		
		System.out.println("일정 삭제 컨트롤러 호출");
		
		System.out.println("did :" + did);
		
		int result = bs.deleteScehdule(did);
		
		return "redirect:/bandCalendarList.bd";
		
		
	}*/
	
	@RequestMapping(value="deleteCalendar.bd")
	public @ResponseBody void deleteCalendar(@RequestParam int did, Model model,
										HttpServletResponse response){
		
		System.out.println("일정 삭제 컨트롤러 호출");
		
		System.out.println("did :" + did);
		
		bs.deleteScehdule(did);
		
	}
	

	@RequestMapping(value="updateCalendar.bd")
	public @ResponseBody void updateCalendar(@RequestParam int did,
							String title, String content, Model model,
										HttpServletResponse response){
			
			
		
		System.out.println("일정 수정 컨트롤러 호출");
		
		System.out.println("did :" + did);
		
		Scehdule s = new Scehdule(did, title, content);
		
		bs.updateScehdule(s);
		
		
		
	}
	
	@RequestMapping("Member_BandInsert.bd")
	public String Member_BandInsert(@RequestParam int bid, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		System.out.println("Member_BandInsert.bd 호출");
		System.out.println("bid : " + bid);
		
		int mid = ((Member)request.getSession().getAttribute("loginUser")).getMid();
		
		String b = bs.selectBstatus(bid);
		
		Member_Band mb = new Member_Band();
		
		mb.setBid(bid);
		mb.setMid(mid);
		
		if(b.equals("PUB")){
			mb.setIstatus("Y");
		}else if(b.equals("PTD")){
			mb.setIstatus("S");
		}
		
		bs.insertMember_Band(mb);

		return "redirect:/bandLeader.bd?bid=" + bid;
	}
	

}
