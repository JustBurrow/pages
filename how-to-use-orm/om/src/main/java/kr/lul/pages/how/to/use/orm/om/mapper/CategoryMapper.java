package kr.lul.pages.how.to.use.orm.om.mapper;

import kr.lul.pages.how.to.use.orm.om.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Mapper
public interface CategoryMapper {
  @Insert("INSERT INTO category(name) VALUES (#{name})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int create(Category category);

  @Select("SELECT * FROM category WHERE id = #{id}")
  Category read(@Param("id") long id);

  @Select("SELECT * FROM category")
  List<Category> list();
}
