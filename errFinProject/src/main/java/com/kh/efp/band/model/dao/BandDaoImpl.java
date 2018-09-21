package com.kh.efp.band.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.efp.band.model.vo.Scehdule;

@Repository
public class BandDaoImpl implements BandDao{

	@Override
	public void insertScehdule(SqlSessionTemplate sqlSession, Scehdule s) {
		//System.out.println("BandDaoImpl 호출됨..");
		
		sqlSession.insert("Scehdule.insertScehdule", s);
		
	}

	@Override
	public List<Object> scehduleList(SqlSessionTemplate sqlSession) {
		
		List<Object> objectList = new ArrayList<Object>(sqlSession.selectList("Scehdule.scehduleList"));
		
		
		return objectList;
	}

	@Override
	public void deleteScehdule(SqlSessionTemplate sqlSession, int did) {
		
		System.out.println("BandDaoImpl 호출됨..");
		
		sqlSession.delete("Scehdule.deleteScehdule", did);
		
		
	}

	@Override
	public int selectCurrval(SqlSessionTemplate sqlSession) {

		return sqlSession.selectOne("Scehdule.selectCurrval");
	}


	
	
	
}
