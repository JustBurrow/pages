package kr.lul.pages.how.to.use.orm.orm.repository;

import kr.lul.pages.how.to.use.orm.orm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author justburrow
 * @since 2019/10/20
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}