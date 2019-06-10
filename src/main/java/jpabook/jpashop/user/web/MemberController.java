package jpabook.jpashop.user.web;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService service;

  @GetMapping("/user")
  public List<Member> user() {
    return service.getUsers(null);
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
