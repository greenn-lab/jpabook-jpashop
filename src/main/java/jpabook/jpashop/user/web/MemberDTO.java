package jpabook.jpashop.user.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jpabook.jpashop.user.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {

  private Long id;
  private String username;

  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  private String name;
  private Address address;

  @Setter
  @Getter
  public static class Search {

    private String type;
    private String keyword;

  }

}
