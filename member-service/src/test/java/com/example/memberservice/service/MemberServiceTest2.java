package com.example.memberservice.service;

import com.example.memberservice.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest2 {

    MemberService memberService = new MemberService();

    @Test // test는 한글명으로 만들어도 상관없음
    void 회원가입() {
        //given 테스트 환경시 무언가 주어진 상태
        Member member = new Member();
        member.setName("hello");
        //when 테스트 환경시 언제 테스트 해야하는지
        Long saveId = memberService.join(member);

        //then 테스트 환경시 when에 걸리면 어떻게 해야하는지
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}