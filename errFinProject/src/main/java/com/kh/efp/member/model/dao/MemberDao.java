package com.kh.efp.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.efp.member.model.vo.Member;
import com.kh.efp.member.model.vo.Profile;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	String selectEncPassword(SqlSessionTemplate sqlSession, Member m);

	Member selectMember(SqlSessionTemplate sqlSession, Member m);

	int checkmName(SqlSessionTemplate sqlSession, String mName);

	int selectMid(SqlSessionTemplate sqlSession, Member m);

	int insertMemberProfile(SqlSessionTemplate sqlSession, Profile pf);

	Profile selectMemberProfile(SqlSessionTemplate sqlSession, int mid);

	int insertChangedProfile(SqlSessionTemplate sqlSession, Profile pf);

	int selectMemberName(SqlSessionTemplate sqlSession, Member m);

	int updateMemberName(SqlSessionTemplate sqlSession, Member m);

	int selectmPhone(SqlSessionTemplate sqlSession, String mPhone);

	int updateMemberPhone(SqlSessionTemplate sqlSession, Member m);

	int updateMemberPwd(SqlSessionTemplate sqlSession, Member m);

	int selectCntEmail(SqlSessionTemplate sqlSession, String mEmail);

	String selectmEmail(SqlSessionTemplate sqlSession, Member m);

	int updateMidmPwd(SqlSessionTemplate sqlSession, Member m);

	int selectAuthmEmail(SqlSessionTemplate sqlSession, Member m);

	int updatemStatus(SqlSessionTemplate sqlSession, int imid);

}
