package jpabook.jpashop.item.repository;

import java.util.List;

import jpabook.jpashop.item.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  /**
   * Find category by name.
   *
   * @param name category name
   * @return category
   */
  Category findByName(String name);


  List<Category> findAllByName(String name);

  List<Category> findAllByParentName(String parentName);
}
