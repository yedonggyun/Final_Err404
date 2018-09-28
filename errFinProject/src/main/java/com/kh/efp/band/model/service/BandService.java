
package com.kh.efp.band.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.efp.band.model.vo.Band;
import com.kh.efp.band.model.vo.Member_Band;
import com.kh.efp.band.model.vo.Scehdule;
import com.kh.efp.member.model.exception.LoginException;
import com.kh.efp.member.model.vo.Member;

public interface BandService {

	int insertScehdule(Scehdule s);

	List<Object> scehduleList();

	int deleteScehdule(int did);

	int selectCurrval();

	void updateScehdule(Scehdule s);

	void updateBandOpenStatus(Band b);

	ArrayList<Member_Band> selectMember_BandList(Member_Band mb);

	void insertBandMultiLeader(int mbid);

	void deleteBandMultiLeader(int mbid);

	ArrayList<Member_Band> searchMember_BandList(Member_Band mb);

	void changeBandLeader(Member_Band mb);

	void secessionBand(Member_Band mb);

	void deleteBand(int bid);

	void updateBandIntro(Band b);


}
