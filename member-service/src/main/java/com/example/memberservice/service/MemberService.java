package com.example.memberservice.service;

import com.example.memberservice.domain.Member;
import com.example.memberservice.repository.MemberRepository;
import com.example.memberservice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        // 같은 회원 중복 이름을 쓰지 않으려한다면
        // memberRepository.findByName(member.getName()); //ctrl+alt+v 맥에서는 cmd+opt+v
        validateDuplicateMember(member); // 중복회원 검증 메서드 추출? 이게 대체 뭐임..
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
