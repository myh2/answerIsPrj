package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.answeris.web.model.MainSearch;

public class MybatisMainSearchDao implements MainSearchDao {
   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<MainSearch> get(/*String field, String query, int page*/ String keyword) {
      MainSearchDao mainSearchDao = sqlSession.getMapper(MainSearchDao.class);
      return mainSearchDao.get(/*field,query,page*/ keyword);
   }

   @Override
   public List<MainSearch> getQnA(/*String field, String query, int page*/ String keyword) {
      MainSearchDao mainSearchDao = sqlSession.getMapper(MainSearchDao.class);
      return mainSearchDao.getQnA(/*field,query,page*/ keyword);
   }
   @Override
   public List<MainSearch> getQnANext(/*String field, String query, int page*/ String keyword, String count) {
      MainSearchDao mainSearchDao = sqlSession.getMapper(MainSearchDao.class);
      return mainSearchDao.getQnANext(/*field,query,page*/ keyword, count);
   }

@Override
public List<MainSearch> getNext(String keyword, String count) {
	// TODO Auto-generated method stub
	MainSearchDao mainSearchDao = sqlSession.getMapper(MainSearchDao.class);
	return mainSearchDao.getNext(/*field,query,page*/ keyword, count);
}
   
   
   
}