package jpabook.jpashop.item.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
@Setter
@Getter
public class Book extends Item {

  private String author;
  private String isbn;

}
