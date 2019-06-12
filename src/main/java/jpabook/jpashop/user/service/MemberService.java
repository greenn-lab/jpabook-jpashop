package jpabook.jpashop.user.service;

import java.util.List;

import jpabook.jpashop.user.web.MemberDTO;

public interface MemberService {

  MemberDTO signUp(MemberDTO member);

  List<MemberDTO> getUsers(MemberDTO.Search search);

  MemberDTO getUser(Long id);
}
