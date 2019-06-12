package jpabook.jpashop.user.web;

import java.util.List;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService service;

  @GetMapping("/user")
  public List<MemberDTO> user(MemberDTO.Search search) {
    return service.getUsers(search);
  }

  @GetMapping("/user/{id}")
  public Member user(@PathVariable Long id) {
    return service.getUser(id);
  }

  @PostMapping("/user/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public Member signUp(@RequestBody @Validated Member member) {
    return service.signUp(member);
  }
}
