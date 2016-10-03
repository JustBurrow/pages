package kr.lul.pages.spring.boot14.v2.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.lul.pages.spring.boot14.v2.jpa.entity.FooEntity;

/**
 * @author Just Burrow
 * @since 2016. 10. 3.
 */
@Repository
public interface FooRepository extends JpaRepository<FooEntity, Integer> {
}
