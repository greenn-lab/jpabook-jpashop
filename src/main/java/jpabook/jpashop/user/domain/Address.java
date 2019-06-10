package jpabook.jpashop.user.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Embeddable
public class Address implements Serializable {

  private String city;
  private String street;
  private String zipcode;

}
