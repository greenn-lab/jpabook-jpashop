package jpabook.jpashop.user.service;

import java.util.List;
import java.util.stream.Collectors;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.exception.AlreadyExistsUsernameException;
import jpabook.jpashop.user.repository.MemberRepository;
import jpabook.jpashop.user.web.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository repository;
  private final ModelMapper mapper;

  public MemberDTO signUp(MemberDTO member) {
    final String username = member.getUsername();

    if (existsUsername(username)) {
      throw new AlreadyExistsUsernameException();
    }

    final Member savedMember = mapper.map(member, Member.class);
    return mapper.map(repository.save(savedMember), MemberDTO.class);
  }

  @Override
  public List<MemberDTO> getUsers(MemberDTO.Search search) {
    final List<Member> all = repository.findAll();
    return all.stream()
        .map(member -> mapper.map(member, MemberDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public MemberDTO getUser(Long id) {
    final Member member = repository.findById(id).orElse(null);

    if (member == null) {
      throw new NullPointerException("This username was not exists");
    }

    return mapper.map(member, MemberDTO.class);
  }

  private boolean existsUsername(String username) {
    return repository.existsByUsername(username);
  }
}
