package jpabook.jpashop.item.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

  private String artist;
  private String etc;

}
