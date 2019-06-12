package jpabook.jpashop.user.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import jpabook.jpashop.user.domain.Address;
import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private MemberService service;

  @Test
  public void 회원이_만들어져요() throws Exception {
    // GIVEN
    MemberDTO member = new MemberDTO();
    member.setUsername("test");
    member.setPassword("test123!");
    member.setName("tester");
    member.setAddress(
        Address.builder().city("Incheon").street("Gulporo 105").zipcode("21328").build());

    given(service.signUp(any())).willReturn(member);

    // WHEN
    final ResultActions perform = mvc.perform(
        post("/user/sign-up")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(
                "{"
                    + "\"id\":null,"
                    + "\"username\":\"test\","
                    + "\"password\":\"test123!\","
                    + "\"name\":\"tester\","
                    + "\"address\":{"
                    + "\"city\":\"Incheon\","
                    + "\"street\":\"Gulporo 105\","
                    + "\"zipcode\":\"21328\"}"
                    + "}")
    );

    // THEN
    perform
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.password").doesNotExist())
        .andDo(print());
  }

  @Test
  public void username_이_너무_짧아서_400_에러에요() throws Exception {
    // GIVEN
    Member member = new Member();
    member.setUsername("t");

    // WHEN
    final ResultActions perform = mvc
        .perform(post("/user/sign-up").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\"username\":\"t\"}"));

    // THEN
    perform
        .andExpect(status().isBadRequest());
  }

  @Test
  public void 회원목록을_불러와요() throws Exception {
    // given
    MemberDTO member = new MemberDTO();
    member.setUsername("test");
    member.setName("tester");

    given(service.getUsers(any())).willReturn(Arrays.asList(member));


    // when
    final ResultActions perform = mvc.perform(
        get("/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
    );

    // then
    perform
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].username", "test").value("tester"))
    ;

  }
}
