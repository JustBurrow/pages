package kr.lul.pages.how.to.use.orm.om.mapper;

import kr.lul.pages.how.to.use.orm.om.model.Category;
import kr.lul.pages.how.to.use.orm.om.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Mapper
public interface ProductMapper {
  @Insert("INSERT INTO product (name) VALUES (#{name})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int create(Product product);

  @Insert("INSERT INTO rel_category_product(product, category) VALUES (#{p.id}, #{c.id})")
  int createRelation(@Param("p") Product product, @Param("c") Category category);

  @Select("SELECT * FROM product WHERE id= #{id}")
  Product read(@Param("id") long id);

  @Select("SELECT * FROM product")
  List<Product> list();

  @Select("SELECT p.* FROM product AS p, rel_category_product AS r WHERE p.id = r.product AND r.category = #{category}")
  List<Product> listByCategory(@Param("category") long category);
}
