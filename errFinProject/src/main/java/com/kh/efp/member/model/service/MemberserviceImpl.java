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
import com.kh.efp.member.model.vo.loginUser;

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
		
		int result2 = md.insertMemberProfile(sqlSession, pf);	//여기서 에러
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
	public int selectCntEmail(String mEmail) {
		return md.selectCntEmail(sqlSession, mEmail);
	}

	@Override
	public String selectmEmail(Member m) {
		return md.selectmEmail(sqlSession, m);
	}

	@Override
	public int updatemEmailmPwd(Member m) {
		// TODO Auto-generated method stub
		return md.updatemEmailmPwd(sqlSession, m);
	}

	@Override
	public int selectAuthmEmail(Member m) {
		// TODO Auto-generated method stub
		return md.selectAuthmEmail(sqlSession, m);
	}

	@Override
	public int updatemStatus(int imid) {
		// TODO Auto-generated method stub
		return md.updatemStatus(sqlSession, imid);
	}

	@Override
	public loginUser loginMember2(Member m) throws LoginException {
		loginUser loginUser = null;
		Member member = null;
 		String encPassword = md.selectEncPassword(sqlSession, m);
 		if(!passwordEncoder.matches(m.getmPwd(), encPassword)){
			throw new LoginException("로그인 정보가 존재하지 않습니다");
		}else{
			member = md.selectMember(sqlSession, m);
			m.setMid(member.getMid());
			loginUser = md.selectLoginUser(sqlSession, m);
		}
		
		return loginUser;
	}

	@Override
	public void selectPwd(int mid, String nowPwd, String newPwd) throws LoginException {
		Member m = new Member();
		m.setMid(mid);
		
		String encPassword = md.selectEncPassword(sqlSession, m);
		
		if(!passwordEncoder.matches(nowPwd, encPassword)){
			throw new LoginException("비밀번호가 일치하지 않습니다.");
		}else{
			m.setmPwd(passwordEncoder.encode(newPwd));
			int result = md.updateMidmPwd(sqlSession, m);
			
			if(result <= 0){
				throw new LoginException("비밀번호 수정에 실패했습니다.");
			}
		}
		
		
	}

	@Override
	public void selectInfo(Member m) throws LoginException {
		String encPassword = md.selectEncPassword(sqlSession, m);

		if(!passwordEncoder.matches(m.getmPwd(), encPassword)){
			throw new LoginException("비밀번호가 일치하지 않습니다.");
		}else{
			int result = md.updateInfo(sqlSession, m);

			if(result <= 0){
				throw new LoginException("회원정보 수정에 실패했습니다.");
			}
		}
	}





}
