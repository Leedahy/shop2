package com.shop.entity;

import com.shop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberTest {

  @Autowired
  MemberRepository memberRepository;

  @PersistenceContext
  EntityManager em;

  @Test
  @DisplayName("Auditing 테스트")
  @WithMockUser(username = "dahye", roles = "USER")
  public void auditingTest() {
    Member member2 = new Member();
    memberRepository.save(member2);

    em.flush();
    em.clear();

    Member memeber = memberRepository.findById(member2.getId())
        .orElseThrow(EntityNotFoundException::new);

    System.out.println("reg time : " + memeber.getRegTime());
    System.out.println("update time : " + memeber.getUpdateTime());
    System.out.println("create time : " + memeber.getCreatedBy());
    System.out.println("modi time : " + memeber.getModifiedBy());
  }
}