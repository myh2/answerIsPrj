package net.answeris.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.answeris.web.model.Blog;
import net.answeris.web.model.MainSearch;

public interface MainSearchDao {
   public List<MainSearch> get(
         /*@Param("field") String field,
         @Param("query") String query,
         @Param("page") int page*/
         String keyword);
   public List<MainSearch> getQnA(
         
         String keyword);

   public List<MainSearch> getNext(String keyword, String count);
  
   
   public List<MainSearch> getQnANext(String keyword, String count);
   
   }