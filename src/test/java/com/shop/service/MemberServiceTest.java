package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@test.com");
        memberFormDto.setName("test");
        memberFormDto.setAddress("서울시 서울구 서울동 서울 아파트");
        memberFormDto.setPassword("1234");

        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트 합니다")
    public void saveMemberTest() {
        Member member = createMember();
        Member sevedMember = memberService.seveMember(member);

        assertEquals(member.getEmail(), sevedMember.getEmail());
        assertEquals(member.getName(), sevedMember.getName());
        assertEquals(member.getAddress(), sevedMember.getAddress());
        assertEquals(member.getPassword(), sevedMember.getPassword());
        assertEquals(member.getRole(), sevedMember.getRole());
    }

    @Test
    @DisplayName("중복 회원 체크 테스트")
    public void userCheckTest() {

        Member member1 = createMember();
        Member member2 = createMember();

        memberService.seveMember(member1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.seveMember(member2);
        });

        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}
