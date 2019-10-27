package kr.lul.pages.how.to.use.orm.om.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Mapper
public interface CategoryDao {
  @Insert("INSERT INTO category(name) VALUES (#{name})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int create(kr.lul.pages.how.to.use.orm.om.model.Category category);

  @Select("SELECT * FROM category WHERE id = #{id}")
  kr.lul.pages.how.to.use.orm.om.model.Category read(@Param("id") long id);

  @Select("SELECT * FROM category")
  List<kr.lul.pages.how.to.use.orm.om.model.Category> list();
}
