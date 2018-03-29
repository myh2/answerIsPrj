package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.answeris.web.model.Codelet;

public interface CodeletDao {

	public List<Codelet> getList(@Param("regMemberId") String regMemberId,@Param("sortFlag") String sortFlag, @Param("query")String query,@Param("select") String select,@Param("sortSelec") String sortSelec );
	
	public List<Codelet> getLangList(String regMemberId);

	public Codelet get(String code);

	public int add(Codelet codelet);

	public int update(Codelet codelet);

	public int delete(String code);

	public int addFav(String code);

	public int delFav(String code);

	public int updateRec(String code);

	public List<Codelet> getFavList();

	public List<Codelet> getRecList();

	public List<Codelet> getHashTags(@Param("userFlag") String userFlag, @Param("ht") String ht, @Param("regMemberId") String regMemberId);
}
