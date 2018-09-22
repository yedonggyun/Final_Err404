package com.kh.efp.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.efp.member.model.dao.MemberDao;
import com.kh.efp.member.model.exception.LoginException;
import com.kh.efp.member.model.vo.Member;
import com.kh.efp.member.model.vo.Profile;

@Service
public class MemberserviceImpl implements MemberService {
	@Autowired private SqlSessionTemplate sqlSession;
	@Autowired private MemberDao md;
	@Autowired private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Member loginMember(Member m) throws LoginException {
		Member loginUser = null;

		String encPassword = md.selectEncPassword(sqlSession, m);

		if(!passwordEncoder.matches(m.getmPwd(), encPassword)){
			throw new LoginException("로그인 정보가 존재하지 않습니다");
		}else{
			loginUser = md.selectMember(sqlSession, m);
		}

		return loginUser;
	}

	@Override
	public int checkmName(String mName) {
		int ckVal = md.checkmName(sqlSession, mName);
		
		return ckVal;
	}


	@Override
	@Transactional
	public int insertMember(Member m, Profile pf) {
		int result = -99;

		System.out.println("service m : " + m + " / pf : " + pf);
		int result1 = md.insertMember(sqlSession, m);
		
		int mid = md.selectMid(sqlSession, m);
		pf.setMid(mid);
		System.out.println(mid);
		System.out.println("pf : " + pf);
		
		int result2 = md.insertMemberProfile(sqlSession, pf);
		System.out.println(result2);
		
		if(result1 > 0 && result2 > 0){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}
	
	@Override
	public Profile selectMemberProfile(int mid) {
		Profile pf = md.selectMemberProfile(sqlSession, mid);
		
		return pf;
	}
 	@Override
	public int insertChangedProfile(Profile pf) {
		return md.insertChangedProfile(sqlSession, pf);
	}

	@Override
	public int updatemName(Member m) {
		int ck = md.selectMemberName(sqlSession, m);
		int result = 0;

		if(ck == 0){
			result = md.updateMemberName(sqlSession, m);
		}
		
		return result;
	}

	@Override
	public Member selectMember(Member m) {
		// TODO Auto-generated method stub
		return md.selectMember(sqlSession, m);
	}

	@Override
	public int selectmPhone(String mPhone) {
		// TODO Auto-generated method stub
		return md.selectmPhone(sqlSession, mPhone);
	}

	@Override
	public int updatemPhone(Member m) {
		String phone = m.getmPhone();
		
		int ck = md.selectmPhone(sqlSession, phone);
		int result = 0;

		if(ck == 0){
			result = md.updateMemberPhone(sqlSession, m);
		}
		
		return result;
	}


}
